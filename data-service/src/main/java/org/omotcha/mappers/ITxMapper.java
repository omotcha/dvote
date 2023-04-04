package org.omotcha.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.omotcha.entities.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface ITxMapper extends BaseMapper<Transaction> {
}
