package org.omotcha.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.omotcha.entities.Block;
import org.omotcha.entities.Chain;
import org.omotcha.mappers.IBlockMapper;
import org.omotcha.mappers.IChainMapper;
import org.omotcha.services.BlockInfoService;
import org.omotcha.services.ChainInfoService;
import org.omotcha.services.MigrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class MigrateServiceImpl implements MigrateService {

    @Autowired
    private ChainInfoService chainInfoService;

    @Autowired
    private BlockInfoService blockInfoService;

    @Autowired
    private IChainMapper chainMapper;

    @Autowired
    private IBlockMapper blockMapper;
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
        blockMapper.insert(block);
    }
}
