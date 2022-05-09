package com.lh.vo;

import com.lh.entity.TbNote;
import lombok.Data;
import lombok.EqualsAndHashCode;

//用于前端展示日期和类别分类的vo
@Data
@EqualsAndHashCode(callSuper = true)
public class NoteVo  extends TbNote {
    private Integer typeId;
    private  String groupName;
    private Integer noteCount;
    //用于查看某一个日记的详情
    private  String typeName;
}
