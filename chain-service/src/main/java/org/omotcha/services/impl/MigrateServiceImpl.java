package org.omotcha.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.omotcha.entities.Block;
import org.omotcha.entities.Chain;
import org.omotcha.entities.Transaction;
import org.omotcha.mappers.IBlockMapper;
import org.omotcha.mappers.IChainMapper;
import org.omotcha.mappers.ITxMapper;
import org.omotcha.services.BlockInfoService;
import org.omotcha.services.ChainInfoService;
import org.omotcha.services.MigrateService;
import org.omotcha.services.TxInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class MigrateServiceImpl implements MigrateService {

    @Autowired
    private ChainInfoService chainInfoService;

    @Autowired
    private BlockInfoService blockInfoService;

    @Autowired
    private TxInfoService txInfoService;

    @Autowired
    private IChainMapper chainMapper;

    @Autowired
    private IBlockMapper blockMapper;

    @Autowired
    private ITxMapper txMapper;
    @Override
    public boolean migrateChain() {
        try{
            Chain chainInfo = chainInfoService.getChainOverall();
            chainMapper.insert(chainInfo);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean migrateBlock() {
        try{
            LambdaQueryWrapper<Block> wrapper = new LambdaQueryWrapper<>();
            wrapper.orderByDesc(Block::getHeight);
            wrapper.last("limit 1");
            Block block = blockMapper.selectOne(wrapper);
            BigInteger curDBHeight = block == null?BigInteger.ZERO:block.getHeight();
            BigInteger curChainHeight = chainInfoService.getLatestBlockNum();
            while(curDBHeight.compareTo(curChainHeight)<=0){
                migrateSingleBlock(curDBHeight);
                curDBHeight = curDBHeight.add(BigInteger.ONE);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void migrateSingleBlock(BigInteger height) throws Exception{
        Block block = blockInfoService.getBlockOverall(height.longValue());
        List<Transaction> txlist = txInfoService.getTxListByBlockNum(height.longValue());
        for (Transaction tx : txlist) {
            txMapper.insert(tx);
        }
        blockMapper.insert(block);
    }
}
