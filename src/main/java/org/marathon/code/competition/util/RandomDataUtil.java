package org.marathon.code.competition.util;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateMidnight;

public class RandomDataUtil {

    private static final String[] MAIL_PROVIDERS = { "163", "126", "sina", "sohu", "gmail", "hotmail" };

    private static final String[] FAMILY_NAMES = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "梁", "何", "严", "龙", "张",
            "白", "余", "杨", "段" };

    private static final String[] NAMES = { "东", "南", "西", "北", "天", "金", "木", "冰", "阳", "洋", "明", "亮", "娥", "飞", "航",
            "斌", "源", "海", "燕" };

    private static final String[] CITIES = { "北京市", "上海市", "广州市", "深圳市", "天津市", "苏州市", "成都市" };
    private static final String[] AREAS = { "东城区", "西城区", "武侯区", "静安区", "福田区", "罗湖区", "金牛区" };
    private static final String[] STREET = { "长安街", "天府大道", "武侯大道", "北京路", "王府井大街", "解放路", "第五大道" };

    private static final String CHINESE_CHARACTERS = "的一了是我不在人们有来他这上着个地到大里说就去子得也和那要下看天时过出小么起你都把好还多没为又可家学只以主会样年想生同老中十从自面前头道它后然走很像见两用她国动进成回什边作对开而己些现山民候经发工向事命给长水几义三声于高手知理眼志点心战二问但身方实吃做叫当住听革打呢真全才四已所敌之最光产情路分总条白话东席次亲如被花口放儿常气五第使写军吧文运再果怎定许快明行因别飞外树物活部门无往船望新带队先力完却站代员机更九您每风级跟笑啊孩万少直意夜比阶连车重便斗马哪化太指变社似士者干石满日决百原拿群究各六本思解立河村八难早论吗根共让相研今其书坐接应关信觉步反处记将千找争领或师结块跑谁草越字加脚紧爱等习阵怕月青半火法题建赶位唱海七女任件感准张团屋离色脸片科倒睛利世刚且由送切星导晚表够整认响雪流未场该并底深刻平伟忙提确近亮轻讲农古黑告界拉名呀土清阳照办史改历转画造嘴此治北必服雨穿内识验传业菜爬睡兴形量咱观苦体众通冲合破友度术饭公旁房极南枪读沙岁线野坚空收算至政城劳落钱特围弟胜教热展包歌类渐强数乡呼性音答哥际旧神座章帮啦受系令跳非何牛取入岸敢掉忽种装顶急林停息句区衣般报叶压慢叔背细";

    public static String randomEmail() {
        int prefixLength = 3 + RandomUtils.nextInt(4);
        String prefix = RandomStringUtils.randomAlphanumeric(prefixLength).toLowerCase();
        String provider = randomElement(MAIL_PROVIDERS);
        return prefix + "@" + provider + ".com";
    }

    public static String randomPhoneNumber() {
        return "13" + RandomStringUtils.randomNumeric(9);
    }

    public static String randomChineseName() {
        String name = randomElement(FAMILY_NAMES) + randomElement(NAMES);
        return RandomUtils.nextBoolean() ? name : name + randomElement(NAMES);
    }

    public static String randomChineseCharacters(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(CHINESE_CHARACTERS.charAt(RandomUtils.nextInt(CHINESE_CHARACTERS.length())));
        }
        return sb.toString();
    }

    public static String randomAddress() {
        String prefix = randomElement(CITIES) + randomElement(AREAS) + randomElement(STREET);
        return prefix + RandomStringUtils.randomNumeric(2) + "号";
    }

    public static Date randomTime(int recentYears) {
        DateMidnight date = new DateMidnight();
        int year = date.getYear() - RandomUtils.nextInt(recentYears);
        int monthOfYear = 1 + RandomUtils.nextInt(11);
        int dayOfMonth = 1 + RandomUtils.nextInt(28);
        return new DateMidnight(year, monthOfYear, dayOfMonth).toDate();
    }

    public static Date randomTimeLastMonth() {
        DateMidnight date = new DateMidnight();
        return date.monthOfYear().addToCopy(-1).dayOfMonth().setCopy(1 + RandomUtils.nextInt(27)).toDate();
    }

    public static String randomElement(String[] arrays) {
        return arrays[RandomUtils.nextInt(arrays.length)];
    }

    public static <T> T randomElement(List<T> list) {
        return list.get(RandomUtils.nextInt(list.size()));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(randomURL(0, null));
        }
    }

    public static String randomURL(int level, String suffix) {
        StringBuilder sb = new StringBuilder("http://www.");
        sb.append(RandomStringUtils.randomAlphabetic(5).toLowerCase());
        sb.append(".com");
        for (int i = 0; i < level; i++) {
            sb.append("/").append(RandomStringUtils.randomAlphanumeric(3).toLowerCase());
        }
        if (suffix != null) {
            sb.append(suffix);
        }
        return sb.toString();
    }

}