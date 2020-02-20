package data;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuggestData {
    private String[] suggestHead;
    private String[] suggestName;
    private String[] suggestTitle;
    private String[] suggestTest;

    private List<Map<String, Object>> data = new ArrayList<>();

    private void setData(){
        // 推荐标题
        suggestHead = new String[]{
                "你已经是成年人了，把“面子”戒了吧",
                "一名抑郁症患者，写给抑郁症患者的6句话",
                "怎样走出同年阴影",
                "心理困境自救法",
                "修复「内在小孩」心理创伤的六句话！"
        };

        //推荐作者
        suggestName = new String[]{
                "未知用户",
                "狗哥",
                "Chitanta",
                "刘小兰",
                "525心理网"
        };

        // 作者头衔
        suggestTitle = new String[]{
                "匿名",
                "网友",
                "心理咨询师",
                "网友",
                "心理网站"
        };

        // 推荐内容
        suggestTest = new String[]{
                "小时候,总以为成年人是优雅的,体面的。至少不会如此脆弱、不堪。可长大后却发现,我太高估成年人了。成年人要负起责任,成年人要承担一切。成年人并没有我们想象中的强大,成年人不是超人。成年人,只是一群过了18岁的普通人。他们可能被无情的现实一次次的击倒,一次次的丢掉面子和尊严。他们会逐渐认识到,年少时的面子比天大是多么可笑,生活中太多事情比面子重要了!",
                "抑郁症是一种什么样的体验?没有经历过的人是很难体会和了解的。无论是经历过抑郁的泥沼的人还是正身处其中的人,不放弃自己的希望,不放弃自己,这是非常重要的。 ",
                "绝大多数成长和成年后的困扰，源自同年时遭受的心理创伤。只有治愈童年创伤，才能彻底走出心理阴影。现代人习惯将个人心理问题归因于竞争压力，认为是竞争激烈的社会环境造成的。但他们往往忽略了人的心理在童年时塑造和养成",
                "人一生，不如意常八九，总有失意与困惑的时候。事业的挫折、家庭的矛盾、人际关系的冲突等都是经常会碰到的，如不注意调剂疏泄，会导致内心矛盾的冲突，使自己陷入郁恐、焦虑、悲痛等心理困境之中，对身心健康危害极大。此时，外界的帮助固然重要，关键还是自我解救，因而应学会一些心理困境自救法。",
                "我们每一个人都有童年,每个人的童年都会或多或少的受到伤害。或许现在的我们已经为人父母,在抚养孩子的过程中,又会有意无意的伤害过自己的孩子。我们都知道,童年时期的心理创伤会伴随一个人一生,会对一个人生活的各个层面产生影响。那么,该如何疗愈孩子内心的创伤?如何疗愈自己童年受到的伤害?",
        };

        for(int i = 0; i < suggestHead.length; i++){
            Map<String, Object> showItem = new HashMap<>();
            showItem.put("suggest_head",  suggestHead[i]);  // 推荐标题
            showItem.put("suggest_name",  suggestName[i]);  // 推荐作者
            showItem.put("suggest_title", suggestTitle[i]); // 作者头衔
            showItem.put("suggest_text",  suggestTest[i]);  // 推荐内容
            data.add(showItem);
        }
    }

    public List<Map<String, Object>> getData(){
        return data;
    }

    public Map<String, Object> getFriendData(int i){
        return data.get(i);
    }

    public SuggestData(){
        setData();
    }
}
