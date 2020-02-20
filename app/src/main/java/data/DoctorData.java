package data;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorData {
    private int[] doctorImg;
    private String[] doctorName;
    private String[] doctorField;
    private String[] doctorInformation;

    private List<Map<String, Object>> data = new ArrayList<>();

    private void setData(){
        // 用户头像
        doctorImg = new int[]{
                R.mipmap.doctor1, R.mipmap.doctor2, R.mipmap.doctor3,
                R.mipmap.doctor4, R.mipmap.doctor5, R.mipmap.doctor6,
                R.mipmap.doctor7, R.mipmap.doctor8, R.mipmap.doctor9,
                R.mipmap.doctor10};

        // 用户昵称
        doctorName = new String[]{
                "李翠华",
                "李卉  ",
                "王巍",
                "严勤奋",
                "杨晓冬",
                "杨晓英",
                "姚杰",
                "张兰欣",
                "张勤",
                "朱红宇"};

        //最新消息
        doctorField = new String[]{
                "国家二级心理咨询师    济宁市",
                "国家二级心理咨询师    徐州市",
                "国家二级心理咨询师    大连市",
                "心理学研究生          宁波市",
                "国家二级心理咨询师    无锡市",
                "国家二级心理咨询师    安阳市",
                "国家二级心理咨询师    金华市",
                "国家二级心理咨询师    保定市",
                "国家二级心理咨询师    成都市",
                "国家二级心理咨询师    北京市"};

        // 消息时间
        doctorInformation = new String[]{
                "擅长领域：厌学逃学、网瘾、人际关系、亲子关系、失眠、高效学习、婚恋情感、焦虑抑郁、强迫恐惧、逆反",
                "擅长领域:婚恋情感，亲子教育，焦虑症，抑郁症，恐怖症，强迫症等",
                "主攻深入研究叙事心理学，组建叙事读书小组（向叙事治疗各位国际先辈学习），带叙事取向心理成长小组，各种心理学主题沙龙",
                "擅长领域：焦虑抑郁、婚恋情感、催眠、失眠、厌学、社交恐惧、性心理、考试焦虑、强迫恐惧、青少年心理干预",
                "擅长领域：强迫症、社交恐惧、婚恋情感、焦虑抑郁、青少年心理干预",
                "擅长领域：抑郁症、婚恋情感、人际关系、强迫症、焦虑症",
                "擅长领域：婚恋情感、性上瘾症、职业规划、外遇、小三、焦虑抑郁、抑郁症、网瘾、焦虑症、产后抑郁症、厌学、性心理障碍、考试焦虑、青少年心理干预、人格障碍、同性恋、性冷淡、自慰、性欲强、孩子早恋、孩子逆反、孩子偷东西",
                "擅长领域：焦虑抑郁、婚恋情感、网瘾、厌学、社交恐惧、孩子教育、催眠、自卑、性心理障碍、精神病人的社会康复",
                "擅长解决自我认识、自我价值提升、情绪管理、拖延、焦虑、抑郁、恐惧、人际关系、亲子教育等系列问题",
                "擅长领域：青少年心理干预、孩子逆反、抑郁症、人际关系障碍、婚姻挽救"};

        for(int i = 0; i < doctorImg.length; i++){
            Map<String, Object> showItem = new HashMap<>();
            showItem.put("doctor_head_img", doctorImg[i]);              // 医生头像
            showItem.put("doctor_name", doctorName[i]);                 // 基本信息
            showItem.put("doctor_field", doctorField[i]);               // 擅长领域
            showItem.put("doctor_information", doctorInformation[i]);   // 相关评价
            data.add(showItem);
        }
    }

    public List<Map<String, Object>> getData(){
        return data;
    }

    public Map<String, Object> getFriendData(int i){
        return data.get(i);
    }

    public DoctorData(){
        setData();
    }

}
