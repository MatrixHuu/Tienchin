package org.javaboy.tienchin.channel.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.hibernate.validator.constraints.Range;
import org.javaboy.tienchin.common.core.domain.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/7/13 14:14
 */
public class ChannelVO extends BaseEntity {

    private Integer channelId;

    /**
     * 渠道名称
     */
    @NotBlank(message = "{channel.name.notnull}")
    private String channelName;

    /**
     * 渠道状态
     */

    @Max(value = 1, message = "{channel.status.invalid}")
    @Min(value = 0, message = "{channel.status.invalid}")
    @NotNull(message = "{channel.status.notnull}")
    private Byte status;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 渠道类型：1线上渠道  2线下渠道
     */
    @Max(value = 2, message = "{channel.type.invalid}")
    @Min(value = 1, message = "{channel.type.invalid}")
    @NotNull(message = "{channel.type.notnull}")
    private Integer type;

    private Integer delFlag;

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
