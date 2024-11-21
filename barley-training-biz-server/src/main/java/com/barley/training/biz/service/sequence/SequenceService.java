package com.barley.training.biz.service.sequence;

import com.barley.common.redis.SequenceRedisTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SequenceService {
    private final SequenceRedisTemplate sequenceRedisTemplate;

    /**
     * 创建供应商号.
     *
     * @return 序号.
     */
    public String createSupplierNo() {
        return sequenceRedisTemplate.createDateSequenceNumber("SUPPLIER",
                "S", 7);
    }

    /**
     * 创建供应商申请号.
     *
     * @return 序号.
     */
    public String createSupplierApplyNo() {
        return sequenceRedisTemplate.createDateSequenceNumber("SUPPLIER_APPLY",
                "SA", 7);
    }

    /**
     * 创建合同号.
     *
     * @return 序号.
     */
    public String createContractNo() {
        return sequenceRedisTemplate.createDateSequenceNumber("CONTRACT",
                "S", 7);
    }

    /**
     * 创建合同申请号.
     *
     * @return 序号.
     */
    public String createContractApplyNo() {
        return sequenceRedisTemplate.createDateSequenceNumber("CONTRACT_APPLY",
                "SA", 7);
    }
}