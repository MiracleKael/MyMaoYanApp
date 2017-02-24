package com.jiaojing.mymaoyanmovie.home.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：xxx
 */
public class HomeHotListViewBean {


    /**
     * expires : 1800
     */

    private ControlBean control;
    /**
     * control : {"expires":1800}
     * status : 0
     * data : {"hasNext":false,"movies":[{"sn":0,"showInfo":"今天165家影院放映2090场","cnms":0,"late":false,"scm":"神奇动物城，法师显超能","src":"","img":"http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg","nm":"神奇动物在哪里","sc":9,"ver":"3D/IMAX 3D/中国巨幕","rt":"2016-11-25上映","dur":133,"imax":true,"snum":103056,"showDate":"","dir":"大卫·叶茨","star":"埃迪·雷德梅恩,凯瑟琳·沃特斯顿,艾莉森·萨多尔","cat":"冒险,奇幻,家庭","wish":130686,"3d":true,"pn":236,"preSale":0,"vd":"","time":"","id":248918},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"寻君千里行，心系君之名","src":"","img":"http://p0.meituan.net/165.220/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","nm":"你的名字。","sc":0,"ver":"2D","rt":"本周五上映","dur":107,"imax":false,"snum":17810,"showDate":"","dir":"新海诚","star":"上白石萌音,神木隆之介,长泽雅美","cat":"剧情,爱情,动画","wish":259255,"3d":false,"pn":166,"preSale":1,"vd":"","time":"","id":344881},{"sn":0,"showInfo":"今天162家影院放映962场","cnms":0,"late":false,"scm":"航海家后代，征程向大海","src":"","img":"http://p1.meituan.net/165.220/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg","nm":"海洋奇缘","sc":9.2,"ver":"2D/3D/中国巨幕/全景声","rt":"2016-11-25上映","dur":107,"imax":false,"snum":31357,"showDate":"","dir":"罗恩·克莱蒙兹,约翰·马斯克,唐·霍尔,克里斯·威廉姆斯","star":"奥伊伊·卡瓦略,道恩·强森,Rachel House","cat":"动画,动作,冒险","wish":42849,"3d":true,"pn":128,"preSale":0,"vd":"","time":"","id":246222},{"sn":0,"showInfo":"今天153家影院放映958场","cnms":0,"late":false,"scm":"夫妇皆仇敌，枕边藏杀机","src":"","img":"http://p0.meituan.net/165.220/movie/9aa8a2df88d43ad08fbf0d1c6878bb5579675.jpg","nm":"间谍同盟","sc":8.5,"ver":"2D/中国巨幕","rt":"本周三上映","dur":124,"imax":false,"snum":29597,"showDate":"","dir":"罗伯特·泽米吉斯","star":"布拉德·皮特,玛丽昂·歌迪亚,马修·古迪","cat":"爱情,动作,战争","wish":42631,"3d":false,"pn":210,"preSale":0,"vd":"","time":"","id":346564},{"sn":0,"showInfo":"今天159家影院放映812场","cnms":0,"late":false,"scm":"金莲戏中戏，官场局中局","src":"","img":"http://p1.meituan.net/165.220/movie/8e5eabeadf237a10227a3124419410ef549583.jpg","nm":"我不是潘金莲","sc":7.9,"ver":"2D/中国巨幕/全景声","rt":"2016-11-18上映","dur":140,"imax":false,"snum":182872,"showDate":"","dir":"冯小刚","star":"范冰冰,郭涛,董成鹏","cat":"剧情,喜剧","wish":185572,"3d":false,"pn":211,"preSale":0,"vd":"","time":"","id":341749},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"异能桃花源，穿越时光圈","src":"","img":"http://p0.meituan.net/165.220/movie/eccf1862c4f30042a373a080acc18ccf9587819.jpeg","nm":"佩小姐的奇幻城堡","sc":0,"ver":"2D/3D/中国巨幕/全景声","rt":"本周五上映","dur":126,"imax":false,"snum":1208,"showDate":"","dir":"蒂姆·波顿","star":"伊娃·格林,阿沙·巴特菲尔德,塞缪尔·杰克逊","cat":"冒险,奇幻","wish":99227,"3d":true,"pn":107,"preSale":1,"vd":"","time":"","id":246373},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"冬升携老怪，千仗无一败","src":"","img":"http://p0.meituan.net/165.220/movie/c3eaa8556346814f2a3a79ffef0924b4577174.jpg","nm":"三少爷的剑","sc":0,"ver":"3D/中国巨幕","rt":"本周五上映","dur":107,"imax":false,"snum":1218,"showDate":"","dir":"尔冬升","star":"林更新,何润东,蒋梦婕","cat":"剧情,动作,武侠","wish":95332,"3d":true,"pn":115,"preSale":1,"vd":"","time":"","id":79088},{"sn":0,"showInfo":"今天115家影院放映332场","cnms":0,"late":false,"scm":"美女有异瞳，黑暗再行动","src":"","img":"http://p0.meituan.net/165.220/movie/6742d5169d136a58a3b1ca2fd071e88c248086.jpg","nm":"名侦探柯南：纯黑的恶梦","sc":8.8,"ver":"2D","rt":"2016-11-25上映","dur":112,"imax":false,"snum":19670,"showDate":"","dir":"静野孔文","star":"高山南,天海佑希,林原惠美","cat":"动画,悬疑","wish":43219,"3d":false,"pn":80,"preSale":0,"vd":"","time":"","id":344073},{"sn":0,"showInfo":"今天74家影院放映195场","cnms":0,"late":false,"scm":"车祸手迟钝，修炼成神棍","src":"","img":"http://p1.meituan.net/165.220/movie/aa492b57443fc95a5b3b46c459d59e50898549.jpg","nm":"奇异博士","sc":9,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"2016-11-04上映","dur":115,"imax":true,"snum":337192,"showDate":"","dir":"斯科特·德瑞克森","star":"本尼迪克特·康伯巴奇,切瓦特·埃加福特,瑞秋·麦克亚当斯","cat":"动作,冒险,奇幻","wish":205273,"3d":true,"pn":534,"preSale":0,"vd":"","time":"","id":246124},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"中法韩跑男，为夺宝闯关","src":"","img":"http://p0.meituan.net/165.220/movie/658b714699f37110db35e343474ccf12808915.png","nm":"超级快递","sc":0,"ver":"2D/中国巨幕","rt":"本周五上映","dur":91,"imax":false,"snum":1680,"showDate":"","dir":"宋啸","star":"陈赫,宋智孝,大卫·贝利","cat":"喜剧,动作,冒险","wish":43562,"3d":false,"pn":143,"preSale":1,"vd":"","time":"","id":343866},{"sn":0,"showInfo":"今天74家影院放映153场","cnms":0,"late":false,"scm":"血清三路抢，大火吞真相","src":"","img":"http://p0.meituan.net/165.220/movie/a4469e30fc41d262ad021d5dd0dd73aa767743.jpg","nm":"冲天火","sc":7.1,"ver":"2D","rt":"2016-11-25上映","dur":100,"imax":false,"snum":21020,"showDate":"","dir":"林岭东,钱文锜","star":"吴彦祖,张孝全,张若昀","cat":"剧情,动作,悬疑","wish":29674,"3d":false,"pn":188,"preSale":0,"vd":"","time":"","id":341529},{"sn":0,"showInfo":"今天45家影院放映107场","cnms":0,"late":false,"scm":"半场无战事，少年初长时","src":"","img":"http://p0.meituan.net/165.220/movie/0469a4bbcf69d46357256bc100bed703787664.jpg","nm":"比利·林恩的中场战事","sc":8.3,"ver":"3D/中国巨幕","rt":"2016-11-11上映","dur":113,"imax":false,"snum":55206,"showDate":"","dir":"李安","star":"乔·阿尔文,克里斯汀·斯图尔特,加内特·赫德兰","cat":"剧情,战争","wish":33615,"3d":true,"pn":281,"preSale":0,"vd":"","time":"","id":247736},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"舍命战毒枭，为爱去狂飙","src":"","img":"http://p0.meituan.net/165.220/movie/394490e44943bebd375ffae1a7fe113e492426.jpg","nm":"极速之巅","sc":0,"ver":"2D/中国巨幕/3D","rt":"本周五上映","dur":88,"imax":false,"snum":99,"showDate":"","dir":"埃兰·克里维","star":"尼古拉斯·霍尔特,菲丽希缇·琼斯,Johny Mathew","cat":"动作,惊悚","wish":20216,"3d":true,"pn":90,"preSale":1,"vd":"","time":"","id":336835},{"sn":0,"showInfo":"2016-12-08 下周四上映","cnms":0,"late":false,"scm":"士兵有信仰，战场拒拿枪","src":"","img":"http://p1.meituan.net/165.220/movie/9581cfbc221ab927b6c856524e96d319769553.jpg","nm":"血战钢锯岭","sc":0,"ver":"2D/中国巨幕","rt":"下周四上映","dur":139,"imax":false,"snum":233,"showDate":"","dir":"梅尔·吉布森","star":"安德鲁·加菲尔德,雨果·维文,卢克·布雷西","cat":"剧情,战争","wish":13292,"3d":false,"pn":98,"preSale":1,"vd":"","time":"","id":338349},{"sn":0,"showInfo":"2016-12-01 本周四上映","cnms":0,"late":false,"scm":"女孩遭性侵，山村来打拼","src":"","img":"http://p1.meituan.net/165.220/movie/808a19b387ec5dcbbb016513f9634a9d1415574.jpg","nm":"爱你的人","sc":0,"ver":"2D","rt":"本周四上映","dur":92,"imax":false,"snum":69,"showDate":"","dir":"谢云鹏,杜昌博","star":"郑昊,张墨锡,王佳琦","cat":"剧情,爱情","wish":2157,"3d":false,"pn":265,"preSale":1,"vd":"","time":"","id":345529},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"驴友去探险，误闯食人岛","src":"","img":"http://p1.meituan.net/165.220/movie/99b80de56746a9de620f08cb33bd21e15407178.jpg","nm":"食人岛","sc":0,"ver":"2D","rt":"本周五上映","dur":94,"imax":false,"snum":142,"showDate":"","dir":"李凯","star":"娄淇,杨凯迪,谢波","cat":"恐怖,惊悚,科幻","wish":7289,"3d":false,"pn":47,"preSale":1,"vd":"","time":"","id":1132403},{"sn":0,"showInfo":"2016-12-09 下周五上映","cnms":0,"late":false,"scm":"绑架十二年，归家惹事端","src":"","img":"http://p0.meituan.net/165.220/movie/d4def49e4f1b238c939334f8915bd8ac829204.png","nm":"那年夏天你去了哪里","sc":0,"ver":"2D","rt":"下周五上映","dur":0,"imax":false,"snum":740,"showDate":"","dir":"周隼","star":"胡歌,宋佳,颜卓灵","cat":"爱情,悬疑,犯罪","wish":30878,"3d":false,"pn":52,"preSale":1,"vd":"","time":"","id":1187526},{"sn":0,"showInfo":"今天5家影院放映28场","cnms":0,"late":false,"scm":"至尊宝归来，穿越寻真爱","src":"","img":"http://p1.meituan.net/165.220/movie/c5c37139438c203a623e95d71a0181f0919589.jpg","nm":"大话西游3","sc":7,"ver":"2D/3D/中国巨幕","rt":"2016-09-14上映","dur":93,"imax":false,"snum":292833,"showDate":"","dir":"刘镇伟","star":"韩庚,唐嫣,吴京","cat":"喜剧,奇幻,爱情","wish":287204,"3d":true,"pn":200,"preSale":0,"vd":"","time":"","id":247259},{"sn":0,"showInfo":"今天23家影院放映28场","cnms":0,"late":false,"scm":"身高有差距，恋爱零距离","src":"","img":"http://p0.meituan.net/165.220/movie/63df54245e2a87bcbe4d9f7a4ee496e6963165.jpg","nm":"最萌身高差","sc":7.9,"ver":"2D","rt":"2016-11-25上映","dur":91,"imax":false,"snum":5763,"showDate":"","dir":"马侃","star":"高以翔,王水林,秦晓飞","cat":"喜剧,爱情","wish":40251,"3d":false,"pn":72,"preSale":0,"vd":"","time":"","id":345105},{"sn":0,"showInfo":"今天3家影院放映11场","cnms":0,"late":false,"scm":"哭成小笨蛋，笑回长大前","src":"","img":"http://p1.meituan.net/165.220/movie/f85de4d42c6fe3e958bd204fcb6a76f59235962.jpg","nm":"28岁未成年","sc":9.2,"ver":"2D","rt":"下周五上映","dur":109,"imax":false,"snum":73,"showDate":"","dir":"张末","star":"倪妮,霍建华,马苏","cat":"喜剧,爱情,奇幻","wish":92055,"3d":false,"pn":140,"preSale":1,"vd":"","time":"","id":343413},{"sn":0,"showInfo":"今天13家影院放映21场","cnms":0,"late":false,"scm":"海上遇井喷，英勇救同伴","src":"","img":"http://p0.meituan.net/165.220/movie/c8d8a0a51af8da4489727296ebf2d548617916.jpg","nm":"深海浩劫","sc":8.3,"ver":"2D/中国巨幕","rt":"2016-11-15上映","dur":108,"imax":false,"snum":30888,"showDate":"","dir":"彼得·博格","star":"马克·沃尔伯格,吉娜·罗德里格兹,库尔特·拉塞尔","cat":"剧情,动作,灾难","wish":26131,"3d":false,"pn":228,"preSale":0,"vd":"","time":"","id":248675},{"sn":0,"showInfo":"今天20家影院放映21场","cnms":0,"late":false,"scm":"夫人突暴毙，地下藏玄机","src":"","img":"http://p0.meituan.net/165.220/movie/b313dcb28fbd25fd116485ee9ada2737980656.jpeg","nm":"怨灵地下室","sc":3.3,"ver":"2D","rt":"2016-11-25上映","dur":89,"imax":false,"snum":2135,"showDate":"","dir":"周广兴","star":"那威,倪新宇,陈美行","cat":"恐怖,惊悚,悬疑","wish":17215,"3d":false,"pn":33,"preSale":0,"vd":"","time":"","id":1182756},{"sn":0,"showInfo":"今天13家影院放映20场","cnms":0,"late":false,"scm":"商船藏毒品，冤屈难洗清","src":"","img":"http://p0.meituan.net/165.220/movie/8f8efcd7a8c3dbcbe13fe2cd855ea6a42750455.jpg","nm":"湄公河行动","sc":9.3,"ver":"2D/中国巨幕","rt":"2016-09-30上映","dur":124,"imax":false,"snum":822041,"showDate":"","dir":"林超贤","star":"张涵予,彭于晏,冯文娟","cat":"动作,犯罪,剧情","wish":57407,"3d":false,"pn":296,"preSale":0,"vd":"","time":"","id":338391},{"sn":0,"showInfo":"今天11家影院放映20场","cnms":0,"late":false,"scm":"热血海贼王，冒险新起航","src":"","img":"http://p0.meituan.net/165.220/movie/e17eb219908416b7ee3bf07c2dc295ac945415.jpg","nm":"航海王之黄金城","sc":9.1,"ver":"2D","rt":"2016-11-11上映","dur":121,"imax":false,"snum":96519,"showDate":"","dir":"宫元宏彰","star":"田中真弓,大谷育江,冈村明美","cat":"动画,冒险","wish":118442,"3d":false,"pn":108,"preSale":0,"vd":"","time":"","id":344902},{"sn":0,"showInfo":"今天15家影院放映16场","cnms":0,"late":false,"scm":"只是被车撞，生活却变样","src":"","img":"http://p0.meituan.net/165.220/movie/501b866b4605b4933b1ebec67bc49da74245946.jpg","nm":"夏威夷之恋","sc":7.3,"ver":"2D","rt":"2016-11-25上映","dur":95,"imax":false,"snum":599,"showDate":"","dir":"林浩然","star":"陈妍希,杰克逊·拉斯波恩,成康","cat":"剧情,爱情,悬疑","wish":11823,"3d":false,"pn":39,"preSale":0,"vd":"","time":"","id":337195},{"sn":0,"showInfo":"今天10家影院放映15场","cnms":0,"late":false,"scm":"谎言圆不上，人比驴荒唐","src":"","img":"http://p1.meituan.net/165.220/movie/13d4883803f25244d266c7cd3ac2f15d327618.jpg","nm":"驴得水","sc":8.5,"ver":"2D","rt":"2016-10-28上映","dur":111,"imax":false,"snum":135980,"showDate":"","dir":"周申,刘露","star":"任素汐,大力,刘帅良","cat":"剧情,喜剧","wish":29385,"3d":false,"pn":157,"preSale":0,"vd":"","time":"","id":410612},{"sn":0,"showInfo":"今天13家影院放映15场","cnms":0,"late":false,"scm":"处女爱处男，结局并不惨","src":"","img":"http://p1.meituan.net/165.220/movie/98d1eac6f63b475e1d937c19666029c4238607.jpg","nm":"我是处女座","sc":7.9,"ver":"2D","rt":"2016-11-25上映","dur":90,"imax":false,"snum":1582,"showDate":"","dir":"陈兵","star":"安宰贤,安以轩,方中信","cat":"剧情,爱情","wish":20845,"3d":false,"pn":70,"preSale":0,"vd":"","time":"","id":344437},{"sn":0,"showInfo":"2016-12-09 下周五上映","cnms":0,"late":false,"scm":"飞机遇意外，机长险被害","src":"","img":"http://p0.meituan.net/165.220/movie/470b3d85956f801fdcdeaa1d1c1a5c84234487.jpg","nm":"萨利机长","sc":0,"ver":"2D/IMAX 2D/中国巨幕","rt":"下周五上映","dur":96,"imax":true,"snum":195,"showDate":"","dir":"克林特·伊斯特伍德","star":"汤姆·汉克斯,艾伦·艾克哈特,劳拉·琳妮","cat":"剧情,传记","wish":12648,"3d":false,"pn":79,"preSale":1,"vd":"","time":"","id":342003},{"sn":0,"showInfo":"今天5家影院放映8场","cnms":0,"late":false,"scm":"不惑未婚男，追女赴越南","src":"","img":"http://p1.meituan.net/165.220/movie/69920759ab83d5343db11ef889946ff0107209.jpg","nm":"越囧","sc":0,"ver":"2D","rt":"2016-11-25上映","dur":96,"imax":false,"snum":248,"showDate":"","dir":"郭翔","star":"马德钟,王大治,刘力扬","cat":"剧情,喜剧,爱情","wish":3016,"3d":false,"pn":77,"preSale":0,"vd":"","time":"","id":246674},{"sn":0,"showInfo":"今天6家影院放映7场","cnms":0,"late":false,"scm":"主播有点烦，儿孙太能缠","src":"","img":"http://p1.meituan.net/165.220/movie/119fc2dd0b9c55001831e6fc5dd2a374115176.jpg","nm":"外公芳龄38","sc":8.3,"ver":"2D","rt":"2016-11-11上映","dur":103,"imax":false,"snum":37213,"showDate":"","dir":"安兵基","star":"佟大为,陈妍希,吕云骢","cat":"剧情,喜剧,家庭","wish":39153,"3d":false,"pn":166,"preSale":0,"vd":"","time":"","id":342427},{"sn":0,"showInfo":"今天4家影院放映6场","cnms":0,"late":false,"scm":"穷人爱公主，神灯来帮助","src":"","img":"http://p1.meituan.net/165.220/movie/2d5fb108c7868e870daa1787cee484b7697168.jpg","nm":"阿拉丁与神灯","sc":7.4,"ver":"2D","rt":"2016-11-18上映","dur":101,"imax":false,"snum":11191,"showDate":"","dir":"亚瑟·本扎昆","star":"凯文·亚当斯,让-保罗·卢弗,凡妮莎·吉德","cat":"喜剧,爱情","wish":19648,"3d":false,"pn":76,"preSale":0,"vd":"","time":"","id":346365},{"sn":0,"showInfo":"今天4家影院放映5场","cnms":0,"late":false,"scm":"异世来相逢，勇者得重生","src":"","img":"http://p0.meituan.net/165.220/movie/c3cb7d5ec4d961c793bd812805a30bc4621134.jpg","nm":"勇士之门","sc":6.4,"ver":"2D/3D/中国巨幕","rt":"2016-11-18上映","dur":108,"imax":false,"snum":19343,"showDate":"","dir":"马蒂亚斯·霍恩","star":"赵又廷,倪妮,尤赖亚·谢尔顿","cat":"动作,冒险,奇幻","wish":23294,"3d":true,"pn":212,"preSale":0,"vd":"","time":"","id":248637},{"sn":0,"showInfo":"今天2家影院放映3场","cnms":0,"late":false,"scm":"夜奔百余里，行军创奇迹","src":"","img":"http://p0.meituan.net/165.220/movie/487c91816e531c33063fefa657d4c6e4656569.jpeg","nm":"勇士","sc":8.8,"ver":"2D/中国巨幕","rt":"2016-10-14上映","dur":102,"imax":false,"snum":17419,"showDate":"","dir":"宁海强","star":"李东学,聂远,于小伟","cat":"历史,战争,动作","wish":10456,"3d":false,"pn":134,"preSale":0,"vd":"","time":"","id":346759},{"sn":0,"showInfo":"今天1家影院放映2场","cnms":0,"late":false,"scm":"婚后无话讲，与谁诉短长","src":"","img":"http://p0.meituan.net/165.220/movie/44e7bf41b8d9bf7a061b5647bb3f0fc9586345.jpg","nm":"一句顶一万句","sc":7.7,"ver":"2D","rt":"2016-11-04上映","dur":110,"imax":false,"snum":6796,"showDate":"","dir":"刘雨霖","star":"毛孩,李倩,刘蓓","cat":"剧情","wish":11050,"3d":false,"pn":176,"preSale":0,"vd":"","time":"","id":345216},{"sn":0,"showInfo":"今天2家影院放映2场","cnms":0,"late":false,"scm":"神秘白云桥，阴阳交界处","src":"","img":"http://p0.meituan.net/165.220/movie/0b5e98a4b7044cc7e445da18c460e104373854.jpg","nm":"白云桥","sc":5.9,"ver":"2D","rt":"2016-11-18上映","dur":94,"imax":false,"snum":2380,"showDate":"","dir":"钟萱","star":"钟萱,温兆伦,刘宇珽","cat":"恐怖,惊悚,悬疑","wish":4173,"3d":false,"pn":50,"preSale":0,"vd":"","time":"","id":1187417},{"sn":0,"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"scm":"新郎要逃婚，中了大陷阱","src":"","img":"http://p0.meituan.net/165.220/movie/d0ccc26a636ae1a6ea4dcb7453758888675237.jpg","nm":"不离不弃","sc":7.3,"ver":"2D","rt":"2016-11-04上映","dur":96,"imax":false,"snum":829,"showDate":"","dir":"蒋钦民","star":"袁成杰,曹云金,江若琳","cat":"剧情,喜剧,爱情","wish":16812,"3d":false,"pn":35,"preSale":0,"vd":"","time":"","id":345494},{"sn":0,"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"scm":"哥哥久失踪，符号引惶恐","src":"","img":"http://p0.meituan.net/165.220/movie/584a35567b3baecfe7347481ba09d9a8418043.jpg","nm":"捉迷藏","sc":8.2,"ver":"2D","rt":"2016-11-04上映","dur":105,"imax":false,"snum":53485,"showDate":"","dir":"刘杰","star":"霍建华,秦海璐,万茜","cat":"惊悚,悬疑,犯罪","wish":42092,"3d":false,"pn":153,"preSale":0,"vd":"","time":"","id":346299},{"sn":0,"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"scm":"时光终将老，陪伴少不了","src":"","img":"http://p1.meituan.net/165.220/movie/447cc8fdcac0d0bcfaeca531b9f49ed2591404.jpg","nm":"盛先生的花儿","sc":8.2,"ver":"2D","rt":"2016-11-04上映","dur":90,"imax":false,"snum":290,"showDate":"","dir":"朱员成","star":"颜丙燕,王德顺,艾丽娅","cat":"剧情","wish":9000,"3d":false,"pn":55,"preSale":0,"vd":"","time":"","id":621219},{"sn":0,"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"scm":"红军开道路，迎接大部队","src":"","img":"http://p1.meituan.net/165.220/movie/e6bc541ab839d55e868948f850bc1d9c141987.jpg","nm":"生死96小时","sc":0,"ver":"2D","rt":"2016-11-09上映","dur":97,"imax":false,"snum":54,"showDate":"","dir":"苑本立","star":"聂远,叶一云","cat":"剧情","wish":46,"3d":false,"pn":11,"preSale":0,"vd":"","time":"","id":1196221},{"sn":0,"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"scm":"育儿新绝招，假装被破产","src":"","img":"http://p0.meituan.net/165.220/movie/34f14bdd361cae758f52dae3436082d1801317.jpg","nm":"贫穷富爸爸","sc":8.1,"ver":"2D","rt":"2016-11-10上映","dur":96,"imax":false,"snum":1944,"showDate":"","dir":"张坚庭","star":"郑嘉颖,小小彬,李呈媛","cat":"剧情,喜剧,爱情","wish":16655,"3d":false,"pn":61,"preSale":0,"vd":"","time":"","id":336061},{"sn":0,"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"scm":"燕赵大地上，鬼子无处藏","src":"","img":"http://p1.meituan.net/165.220/movie/04f0da4d0be4067a3a8066982ae63dfc64193.jpg","nm":"热土悲歌","sc":0,"ver":"2D","rt":"2016-11-25上映","dur":90,"imax":false,"snum":8,"showDate":"","dir":"崔志敏","star":"邹德江,章宇,卢倩文","cat":"剧情,战争","wish":7,"3d":false,"pn":7,"preSale":0,"vd":"","time":"","id":1189305},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"沙漠越野赛，飙车为求爱","src":"","img":"http://p0.meituan.net/165.220/movie/afb1ae81d7ef6a57c5abc20d9fcdd35920580551.jpg","nm":"沙漠之心","sc":0,"ver":"2D","rt":"本周五上映","dur":94,"imax":false,"snum":16,"showDate":"","dir":"李柯","star":"隋咏良,尤靖茹,薛祺","cat":"剧情,爱情,冒险","wish":2447,"3d":false,"pn":68,"preSale":1,"vd":"","time":"","id":1197460},{"sn":0,"showInfo":"2016-12-09 下周五上映","cnms":0,"late":false,"scm":"牧羊人进城，打碎纯真梦","src":"","img":"http://p1.meituan.net/165.220/movie/edb74b337c4f3175b2a45b045619963d460760.jpg","nm":"塔洛","sc":0,"ver":"2D","rt":"下周五上映","dur":120,"imax":false,"snum":427,"showDate":"","dir":"万玛才旦","star":"西德尼玛,杨秀措,扎西","cat":"剧情","wish":2153,"3d":false,"pn":44,"preSale":1,"vd":"","time":"","id":337708},{"sn":0,"showInfo":"今天暂无场次","cnms":0,"late":false,"scm":"医生有武器，心计和身体","src":"","img":"http://p0.meituan.net/165.220/movie/917740c10fed0a65f057c3acc14f4eab393827.jpg","nm":"判我有罪","sc":6.5,"ver":"2D","rt":"2016-05-06上映","dur":102,"imax":false,"snum":1348,"showDate":"","dir":"孙亮","star":"吴镇宇,戴立忍,李昕芸","cat":"悬疑,剧情","wish":5709,"3d":false,"pn":88,"preSale":0,"vd":"","time":"","id":343082},{"sn":0,"showInfo":"今天暂无场次","cnms":0,"late":false,"scm":"离家把侄寻，帮人带书信","src":"","img":"http://p0.meituan.net/165.220/movie/d089ecbfb74fc1a234b7b1b8c5cadcf0516192.jpg","nm":"路边野餐","sc":8.1,"ver":"2D","rt":"2016-07-15上映","dur":113,"imax":false,"snum":6050,"showDate":"","dir":"毕赣","star":"陈永忠,郭月,余世学","cat":"剧情,悬疑","wish":5647,"3d":false,"pn":95,"preSale":0,"vd":"","time":"","id":342073},{"sn":0,"showInfo":"今天暂无场次","cnms":0,"late":false,"scm":"红军历万难，决战生死间","src":"","img":"http://p0.meituan.net/165.220/movie/91b3eb5fd8ea1f15e6a4a6c35842f63389899.jpg","nm":"遵义会议","sc":0,"ver":"2D","rt":"2016-10-10上映","dur":94,"imax":false,"snum":443,"showDate":"","dir":"刘星,胡明钢,于兰","star":"佟瑞欣,郭伟华,马晓伟","cat":"战争,历史,剧情","wish":331,"3d":false,"pn":0,"preSale":0,"vd":"","time":"","id":1189048},{"sn":0,"showInfo":"今天暂无场次","cnms":0,"late":false,"scm":"东方魔幻书，怪力乱神出","src":"","img":"http://p0.meituan.net/165.220/movie/dd9d76aaa8a1bdad4f2907b78efb594f95916.jpeg","nm":"聊斋新编之画皮新娘","sc":5,"ver":"2D","rt":"2016-11-11上映","dur":88,"imax":false,"snum":4428,"showDate":"","dir":"摩撒利","star":"殷果儿,丁汇宇,刘小奇","cat":"爱情,惊悚,悬疑","wish":17879,"3d":false,"pn":34,"preSale":0,"vd":"","time":"","id":346546}]}
     */

    private int status;
    /**
     * hasNext : false
     * movies : [{"sn":0,"showInfo":"今天165家影院放映2090场","cnms":0,"late":false,"scm":"神奇动物城，法师显超能","src":"","img":"http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg","nm":"神奇动物在哪里","sc":9,"ver":"3D/IMAX 3D/中国巨幕","rt":"2016-11-25上映","dur":133,"imax":true,"snum":103056,"showDate":"","dir":"大卫·叶茨","star":"埃迪·雷德梅恩,凯瑟琳·沃特斯顿,艾莉森·萨多尔","cat":"冒险,奇幻,家庭","wish":130686,"3d":true,"pn":236,"preSale":0,"vd":"","time":"","id":248918},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"寻君千里行，心系君之名","src":"","img":"http://p0.meituan.net/165.220/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","nm":"你的名字。","sc":0,"ver":"2D","rt":"本周五上映","dur":107,"imax":false,"snum":17810,"showDate":"","dir":"新海诚","star":"上白石萌音,神木隆之介,长泽雅美","cat":"剧情,爱情,动画","wish":259255,"3d":false,"pn":166,"preSale":1,"vd":"","time":"","id":344881},{"sn":0,"showInfo":"今天162家影院放映962场","cnms":0,"late":false,"scm":"航海家后代，征程向大海","src":"","img":"http://p1.meituan.net/165.220/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg","nm":"海洋奇缘","sc":9.2,"ver":"2D/3D/中国巨幕/全景声","rt":"2016-11-25上映","dur":107,"imax":false,"snum":31357,"showDate":"","dir":"罗恩·克莱蒙兹,约翰·马斯克,唐·霍尔,克里斯·威廉姆斯","star":"奥伊伊·卡瓦略,道恩·强森,Rachel House","cat":"动画,动作,冒险","wish":42849,"3d":true,"pn":128,"preSale":0,"vd":"","time":"","id":246222},{"sn":0,"showInfo":"今天153家影院放映958场","cnms":0,"late":false,"scm":"夫妇皆仇敌，枕边藏杀机","src":"","img":"http://p0.meituan.net/165.220/movie/9aa8a2df88d43ad08fbf0d1c6878bb5579675.jpg","nm":"间谍同盟","sc":8.5,"ver":"2D/中国巨幕","rt":"本周三上映","dur":124,"imax":false,"snum":29597,"showDate":"","dir":"罗伯特·泽米吉斯","star":"布拉德·皮特,玛丽昂·歌迪亚,马修·古迪","cat":"爱情,动作,战争","wish":42631,"3d":false,"pn":210,"preSale":0,"vd":"","time":"","id":346564},{"sn":0,"showInfo":"今天159家影院放映812场","cnms":0,"late":false,"scm":"金莲戏中戏，官场局中局","src":"","img":"http://p1.meituan.net/165.220/movie/8e5eabeadf237a10227a3124419410ef549583.jpg","nm":"我不是潘金莲","sc":7.9,"ver":"2D/中国巨幕/全景声","rt":"2016-11-18上映","dur":140,"imax":false,"snum":182872,"showDate":"","dir":"冯小刚","star":"范冰冰,郭涛,董成鹏","cat":"剧情,喜剧","wish":185572,"3d":false,"pn":211,"preSale":0,"vd":"","time":"","id":341749},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"异能桃花源，穿越时光圈","src":"","img":"http://p0.meituan.net/165.220/movie/eccf1862c4f30042a373a080acc18ccf9587819.jpeg","nm":"佩小姐的奇幻城堡","sc":0,"ver":"2D/3D/中国巨幕/全景声","rt":"本周五上映","dur":126,"imax":false,"snum":1208,"showDate":"","dir":"蒂姆·波顿","star":"伊娃·格林,阿沙·巴特菲尔德,塞缪尔·杰克逊","cat":"冒险,奇幻","wish":99227,"3d":true,"pn":107,"preSale":1,"vd":"","time":"","id":246373},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"冬升携老怪，千仗无一败","src":"","img":"http://p0.meituan.net/165.220/movie/c3eaa8556346814f2a3a79ffef0924b4577174.jpg","nm":"三少爷的剑","sc":0,"ver":"3D/中国巨幕","rt":"本周五上映","dur":107,"imax":false,"snum":1218,"showDate":"","dir":"尔冬升","star":"林更新,何润东,蒋梦婕","cat":"剧情,动作,武侠","wish":95332,"3d":true,"pn":115,"preSale":1,"vd":"","time":"","id":79088},{"sn":0,"showInfo":"今天115家影院放映332场","cnms":0,"late":false,"scm":"美女有异瞳，黑暗再行动","src":"","img":"http://p0.meituan.net/165.220/movie/6742d5169d136a58a3b1ca2fd071e88c248086.jpg","nm":"名侦探柯南：纯黑的恶梦","sc":8.8,"ver":"2D","rt":"2016-11-25上映","dur":112,"imax":false,"snum":19670,"showDate":"","dir":"静野孔文","star":"高山南,天海佑希,林原惠美","cat":"动画,悬疑","wish":43219,"3d":false,"pn":80,"preSale":0,"vd":"","time":"","id":344073},{"sn":0,"showInfo":"今天74家影院放映195场","cnms":0,"late":false,"scm":"车祸手迟钝，修炼成神棍","src":"","img":"http://p1.meituan.net/165.220/movie/aa492b57443fc95a5b3b46c459d59e50898549.jpg","nm":"奇异博士","sc":9,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"2016-11-04上映","dur":115,"imax":true,"snum":337192,"showDate":"","dir":"斯科特·德瑞克森","star":"本尼迪克特·康伯巴奇,切瓦特·埃加福特,瑞秋·麦克亚当斯","cat":"动作,冒险,奇幻","wish":205273,"3d":true,"pn":534,"preSale":0,"vd":"","time":"","id":246124},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"中法韩跑男，为夺宝闯关","src":"","img":"http://p0.meituan.net/165.220/movie/658b714699f37110db35e343474ccf12808915.png","nm":"超级快递","sc":0,"ver":"2D/中国巨幕","rt":"本周五上映","dur":91,"imax":false,"snum":1680,"showDate":"","dir":"宋啸","star":"陈赫,宋智孝,大卫·贝利","cat":"喜剧,动作,冒险","wish":43562,"3d":false,"pn":143,"preSale":1,"vd":"","time":"","id":343866},{"sn":0,"showInfo":"今天74家影院放映153场","cnms":0,"late":false,"scm":"血清三路抢，大火吞真相","src":"","img":"http://p0.meituan.net/165.220/movie/a4469e30fc41d262ad021d5dd0dd73aa767743.jpg","nm":"冲天火","sc":7.1,"ver":"2D","rt":"2016-11-25上映","dur":100,"imax":false,"snum":21020,"showDate":"","dir":"林岭东,钱文锜","star":"吴彦祖,张孝全,张若昀","cat":"剧情,动作,悬疑","wish":29674,"3d":false,"pn":188,"preSale":0,"vd":"","time":"","id":341529},{"sn":0,"showInfo":"今天45家影院放映107场","cnms":0,"late":false,"scm":"半场无战事，少年初长时","src":"","img":"http://p0.meituan.net/165.220/movie/0469a4bbcf69d46357256bc100bed703787664.jpg","nm":"比利·林恩的中场战事","sc":8.3,"ver":"3D/中国巨幕","rt":"2016-11-11上映","dur":113,"imax":false,"snum":55206,"showDate":"","dir":"李安","star":"乔·阿尔文,克里斯汀·斯图尔特,加内特·赫德兰","cat":"剧情,战争","wish":33615,"3d":true,"pn":281,"preSale":0,"vd":"","time":"","id":247736},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"舍命战毒枭，为爱去狂飙","src":"","img":"http://p0.meituan.net/165.220/movie/394490e44943bebd375ffae1a7fe113e492426.jpg","nm":"极速之巅","sc":0,"ver":"2D/中国巨幕/3D","rt":"本周五上映","dur":88,"imax":false,"snum":99,"showDate":"","dir":"埃兰·克里维","star":"尼古拉斯·霍尔特,菲丽希缇·琼斯,Johny Mathew","cat":"动作,惊悚","wish":20216,"3d":true,"pn":90,"preSale":1,"vd":"","time":"","id":336835},{"sn":0,"showInfo":"2016-12-08 下周四上映","cnms":0,"late":false,"scm":"士兵有信仰，战场拒拿枪","src":"","img":"http://p1.meituan.net/165.220/movie/9581cfbc221ab927b6c856524e96d319769553.jpg","nm":"血战钢锯岭","sc":0,"ver":"2D/中国巨幕","rt":"下周四上映","dur":139,"imax":false,"snum":233,"showDate":"","dir":"梅尔·吉布森","star":"安德鲁·加菲尔德,雨果·维文,卢克·布雷西","cat":"剧情,战争","wish":13292,"3d":false,"pn":98,"preSale":1,"vd":"","time":"","id":338349},{"sn":0,"showInfo":"2016-12-01 本周四上映","cnms":0,"late":false,"scm":"女孩遭性侵，山村来打拼","src":"","img":"http://p1.meituan.net/165.220/movie/808a19b387ec5dcbbb016513f9634a9d1415574.jpg","nm":"爱你的人","sc":0,"ver":"2D","rt":"本周四上映","dur":92,"imax":false,"snum":69,"showDate":"","dir":"谢云鹏,杜昌博","star":"郑昊,张墨锡,王佳琦","cat":"剧情,爱情","wish":2157,"3d":false,"pn":265,"preSale":1,"vd":"","time":"","id":345529},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"驴友去探险，误闯食人岛","src":"","img":"http://p1.meituan.net/165.220/movie/99b80de56746a9de620f08cb33bd21e15407178.jpg","nm":"食人岛","sc":0,"ver":"2D","rt":"本周五上映","dur":94,"imax":false,"snum":142,"showDate":"","dir":"李凯","star":"娄淇,杨凯迪,谢波","cat":"恐怖,惊悚,科幻","wish":7289,"3d":false,"pn":47,"preSale":1,"vd":"","time":"","id":1132403},{"sn":0,"showInfo":"2016-12-09 下周五上映","cnms":0,"late":false,"scm":"绑架十二年，归家惹事端","src":"","img":"http://p0.meituan.net/165.220/movie/d4def49e4f1b238c939334f8915bd8ac829204.png","nm":"那年夏天你去了哪里","sc":0,"ver":"2D","rt":"下周五上映","dur":0,"imax":false,"snum":740,"showDate":"","dir":"周隼","star":"胡歌,宋佳,颜卓灵","cat":"爱情,悬疑,犯罪","wish":30878,"3d":false,"pn":52,"preSale":1,"vd":"","time":"","id":1187526},{"sn":0,"showInfo":"今天5家影院放映28场","cnms":0,"late":false,"scm":"至尊宝归来，穿越寻真爱","src":"","img":"http://p1.meituan.net/165.220/movie/c5c37139438c203a623e95d71a0181f0919589.jpg","nm":"大话西游3","sc":7,"ver":"2D/3D/中国巨幕","rt":"2016-09-14上映","dur":93,"imax":false,"snum":292833,"showDate":"","dir":"刘镇伟","star":"韩庚,唐嫣,吴京","cat":"喜剧,奇幻,爱情","wish":287204,"3d":true,"pn":200,"preSale":0,"vd":"","time":"","id":247259},{"sn":0,"showInfo":"今天23家影院放映28场","cnms":0,"late":false,"scm":"身高有差距，恋爱零距离","src":"","img":"http://p0.meituan.net/165.220/movie/63df54245e2a87bcbe4d9f7a4ee496e6963165.jpg","nm":"最萌身高差","sc":7.9,"ver":"2D","rt":"2016-11-25上映","dur":91,"imax":false,"snum":5763,"showDate":"","dir":"马侃","star":"高以翔,王水林,秦晓飞","cat":"喜剧,爱情","wish":40251,"3d":false,"pn":72,"preSale":0,"vd":"","time":"","id":345105},{"sn":0,"showInfo":"今天3家影院放映11场","cnms":0,"late":false,"scm":"哭成小笨蛋，笑回长大前","src":"","img":"http://p1.meituan.net/165.220/movie/f85de4d42c6fe3e958bd204fcb6a76f59235962.jpg","nm":"28岁未成年","sc":9.2,"ver":"2D","rt":"下周五上映","dur":109,"imax":false,"snum":73,"showDate":"","dir":"张末","star":"倪妮,霍建华,马苏","cat":"喜剧,爱情,奇幻","wish":92055,"3d":false,"pn":140,"preSale":1,"vd":"","time":"","id":343413},{"sn":0,"showInfo":"今天13家影院放映21场","cnms":0,"late":false,"scm":"海上遇井喷，英勇救同伴","src":"","img":"http://p0.meituan.net/165.220/movie/c8d8a0a51af8da4489727296ebf2d548617916.jpg","nm":"深海浩劫","sc":8.3,"ver":"2D/中国巨幕","rt":"2016-11-15上映","dur":108,"imax":false,"snum":30888,"showDate":"","dir":"彼得·博格","star":"马克·沃尔伯格,吉娜·罗德里格兹,库尔特·拉塞尔","cat":"剧情,动作,灾难","wish":26131,"3d":false,"pn":228,"preSale":0,"vd":"","time":"","id":248675},{"sn":0,"showInfo":"今天20家影院放映21场","cnms":0,"late":false,"scm":"夫人突暴毙，地下藏玄机","src":"","img":"http://p0.meituan.net/165.220/movie/b313dcb28fbd25fd116485ee9ada2737980656.jpeg","nm":"怨灵地下室","sc":3.3,"ver":"2D","rt":"2016-11-25上映","dur":89,"imax":false,"snum":2135,"showDate":"","dir":"周广兴","star":"那威,倪新宇,陈美行","cat":"恐怖,惊悚,悬疑","wish":17215,"3d":false,"pn":33,"preSale":0,"vd":"","time":"","id":1182756},{"sn":0,"showInfo":"今天13家影院放映20场","cnms":0,"late":false,"scm":"商船藏毒品，冤屈难洗清","src":"","img":"http://p0.meituan.net/165.220/movie/8f8efcd7a8c3dbcbe13fe2cd855ea6a42750455.jpg","nm":"湄公河行动","sc":9.3,"ver":"2D/中国巨幕","rt":"2016-09-30上映","dur":124,"imax":false,"snum":822041,"showDate":"","dir":"林超贤","star":"张涵予,彭于晏,冯文娟","cat":"动作,犯罪,剧情","wish":57407,"3d":false,"pn":296,"preSale":0,"vd":"","time":"","id":338391},{"sn":0,"showInfo":"今天11家影院放映20场","cnms":0,"late":false,"scm":"热血海贼王，冒险新起航","src":"","img":"http://p0.meituan.net/165.220/movie/e17eb219908416b7ee3bf07c2dc295ac945415.jpg","nm":"航海王之黄金城","sc":9.1,"ver":"2D","rt":"2016-11-11上映","dur":121,"imax":false,"snum":96519,"showDate":"","dir":"宫元宏彰","star":"田中真弓,大谷育江,冈村明美","cat":"动画,冒险","wish":118442,"3d":false,"pn":108,"preSale":0,"vd":"","time":"","id":344902},{"sn":0,"showInfo":"今天15家影院放映16场","cnms":0,"late":false,"scm":"只是被车撞，生活却变样","src":"","img":"http://p0.meituan.net/165.220/movie/501b866b4605b4933b1ebec67bc49da74245946.jpg","nm":"夏威夷之恋","sc":7.3,"ver":"2D","rt":"2016-11-25上映","dur":95,"imax":false,"snum":599,"showDate":"","dir":"林浩然","star":"陈妍希,杰克逊·拉斯波恩,成康","cat":"剧情,爱情,悬疑","wish":11823,"3d":false,"pn":39,"preSale":0,"vd":"","time":"","id":337195},{"sn":0,"showInfo":"今天10家影院放映15场","cnms":0,"late":false,"scm":"谎言圆不上，人比驴荒唐","src":"","img":"http://p1.meituan.net/165.220/movie/13d4883803f25244d266c7cd3ac2f15d327618.jpg","nm":"驴得水","sc":8.5,"ver":"2D","rt":"2016-10-28上映","dur":111,"imax":false,"snum":135980,"showDate":"","dir":"周申,刘露","star":"任素汐,大力,刘帅良","cat":"剧情,喜剧","wish":29385,"3d":false,"pn":157,"preSale":0,"vd":"","time":"","id":410612},{"sn":0,"showInfo":"今天13家影院放映15场","cnms":0,"late":false,"scm":"处女爱处男，结局并不惨","src":"","img":"http://p1.meituan.net/165.220/movie/98d1eac6f63b475e1d937c19666029c4238607.jpg","nm":"我是处女座","sc":7.9,"ver":"2D","rt":"2016-11-25上映","dur":90,"imax":false,"snum":1582,"showDate":"","dir":"陈兵","star":"安宰贤,安以轩,方中信","cat":"剧情,爱情","wish":20845,"3d":false,"pn":70,"preSale":0,"vd":"","time":"","id":344437},{"sn":0,"showInfo":"2016-12-09 下周五上映","cnms":0,"late":false,"scm":"飞机遇意外，机长险被害","src":"","img":"http://p0.meituan.net/165.220/movie/470b3d85956f801fdcdeaa1d1c1a5c84234487.jpg","nm":"萨利机长","sc":0,"ver":"2D/IMAX 2D/中国巨幕","rt":"下周五上映","dur":96,"imax":true,"snum":195,"showDate":"","dir":"克林特·伊斯特伍德","star":"汤姆·汉克斯,艾伦·艾克哈特,劳拉·琳妮","cat":"剧情,传记","wish":12648,"3d":false,"pn":79,"preSale":1,"vd":"","time":"","id":342003},{"sn":0,"showInfo":"今天5家影院放映8场","cnms":0,"late":false,"scm":"不惑未婚男，追女赴越南","src":"","img":"http://p1.meituan.net/165.220/movie/69920759ab83d5343db11ef889946ff0107209.jpg","nm":"越囧","sc":0,"ver":"2D","rt":"2016-11-25上映","dur":96,"imax":false,"snum":248,"showDate":"","dir":"郭翔","star":"马德钟,王大治,刘力扬","cat":"剧情,喜剧,爱情","wish":3016,"3d":false,"pn":77,"preSale":0,"vd":"","time":"","id":246674},{"sn":0,"showInfo":"今天6家影院放映7场","cnms":0,"late":false,"scm":"主播有点烦，儿孙太能缠","src":"","img":"http://p1.meituan.net/165.220/movie/119fc2dd0b9c55001831e6fc5dd2a374115176.jpg","nm":"外公芳龄38","sc":8.3,"ver":"2D","rt":"2016-11-11上映","dur":103,"imax":false,"snum":37213,"showDate":"","dir":"安兵基","star":"佟大为,陈妍希,吕云骢","cat":"剧情,喜剧,家庭","wish":39153,"3d":false,"pn":166,"preSale":0,"vd":"","time":"","id":342427},{"sn":0,"showInfo":"今天4家影院放映6场","cnms":0,"late":false,"scm":"穷人爱公主，神灯来帮助","src":"","img":"http://p1.meituan.net/165.220/movie/2d5fb108c7868e870daa1787cee484b7697168.jpg","nm":"阿拉丁与神灯","sc":7.4,"ver":"2D","rt":"2016-11-18上映","dur":101,"imax":false,"snum":11191,"showDate":"","dir":"亚瑟·本扎昆","star":"凯文·亚当斯,让-保罗·卢弗,凡妮莎·吉德","cat":"喜剧,爱情","wish":19648,"3d":false,"pn":76,"preSale":0,"vd":"","time":"","id":346365},{"sn":0,"showInfo":"今天4家影院放映5场","cnms":0,"late":false,"scm":"异世来相逢，勇者得重生","src":"","img":"http://p0.meituan.net/165.220/movie/c3cb7d5ec4d961c793bd812805a30bc4621134.jpg","nm":"勇士之门","sc":6.4,"ver":"2D/3D/中国巨幕","rt":"2016-11-18上映","dur":108,"imax":false,"snum":19343,"showDate":"","dir":"马蒂亚斯·霍恩","star":"赵又廷,倪妮,尤赖亚·谢尔顿","cat":"动作,冒险,奇幻","wish":23294,"3d":true,"pn":212,"preSale":0,"vd":"","time":"","id":248637},{"sn":0,"showInfo":"今天2家影院放映3场","cnms":0,"late":false,"scm":"夜奔百余里，行军创奇迹","src":"","img":"http://p0.meituan.net/165.220/movie/487c91816e531c33063fefa657d4c6e4656569.jpeg","nm":"勇士","sc":8.8,"ver":"2D/中国巨幕","rt":"2016-10-14上映","dur":102,"imax":false,"snum":17419,"showDate":"","dir":"宁海强","star":"李东学,聂远,于小伟","cat":"历史,战争,动作","wish":10456,"3d":false,"pn":134,"preSale":0,"vd":"","time":"","id":346759},{"sn":0,"showInfo":"今天1家影院放映2场","cnms":0,"late":false,"scm":"婚后无话讲，与谁诉短长","src":"","img":"http://p0.meituan.net/165.220/movie/44e7bf41b8d9bf7a061b5647bb3f0fc9586345.jpg","nm":"一句顶一万句","sc":7.7,"ver":"2D","rt":"2016-11-04上映","dur":110,"imax":false,"snum":6796,"showDate":"","dir":"刘雨霖","star":"毛孩,李倩,刘蓓","cat":"剧情","wish":11050,"3d":false,"pn":176,"preSale":0,"vd":"","time":"","id":345216},{"sn":0,"showInfo":"今天2家影院放映2场","cnms":0,"late":false,"scm":"神秘白云桥，阴阳交界处","src":"","img":"http://p0.meituan.net/165.220/movie/0b5e98a4b7044cc7e445da18c460e104373854.jpg","nm":"白云桥","sc":5.9,"ver":"2D","rt":"2016-11-18上映","dur":94,"imax":false,"snum":2380,"showDate":"","dir":"钟萱","star":"钟萱,温兆伦,刘宇珽","cat":"恐怖,惊悚,悬疑","wish":4173,"3d":false,"pn":50,"preSale":0,"vd":"","time":"","id":1187417},{"sn":0,"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"scm":"新郎要逃婚，中了大陷阱","src":"","img":"http://p0.meituan.net/165.220/movie/d0ccc26a636ae1a6ea4dcb7453758888675237.jpg","nm":"不离不弃","sc":7.3,"ver":"2D","rt":"2016-11-04上映","dur":96,"imax":false,"snum":829,"showDate":"","dir":"蒋钦民","star":"袁成杰,曹云金,江若琳","cat":"剧情,喜剧,爱情","wish":16812,"3d":false,"pn":35,"preSale":0,"vd":"","time":"","id":345494},{"sn":0,"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"scm":"哥哥久失踪，符号引惶恐","src":"","img":"http://p0.meituan.net/165.220/movie/584a35567b3baecfe7347481ba09d9a8418043.jpg","nm":"捉迷藏","sc":8.2,"ver":"2D","rt":"2016-11-04上映","dur":105,"imax":false,"snum":53485,"showDate":"","dir":"刘杰","star":"霍建华,秦海璐,万茜","cat":"惊悚,悬疑,犯罪","wish":42092,"3d":false,"pn":153,"preSale":0,"vd":"","time":"","id":346299},{"sn":0,"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"scm":"时光终将老，陪伴少不了","src":"","img":"http://p1.meituan.net/165.220/movie/447cc8fdcac0d0bcfaeca531b9f49ed2591404.jpg","nm":"盛先生的花儿","sc":8.2,"ver":"2D","rt":"2016-11-04上映","dur":90,"imax":false,"snum":290,"showDate":"","dir":"朱员成","star":"颜丙燕,王德顺,艾丽娅","cat":"剧情","wish":9000,"3d":false,"pn":55,"preSale":0,"vd":"","time":"","id":621219},{"sn":0,"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"scm":"红军开道路，迎接大部队","src":"","img":"http://p1.meituan.net/165.220/movie/e6bc541ab839d55e868948f850bc1d9c141987.jpg","nm":"生死96小时","sc":0,"ver":"2D","rt":"2016-11-09上映","dur":97,"imax":false,"snum":54,"showDate":"","dir":"苑本立","star":"聂远,叶一云","cat":"剧情","wish":46,"3d":false,"pn":11,"preSale":0,"vd":"","time":"","id":1196221},{"sn":0,"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"scm":"育儿新绝招，假装被破产","src":"","img":"http://p0.meituan.net/165.220/movie/34f14bdd361cae758f52dae3436082d1801317.jpg","nm":"贫穷富爸爸","sc":8.1,"ver":"2D","rt":"2016-11-10上映","dur":96,"imax":false,"snum":1944,"showDate":"","dir":"张坚庭","star":"郑嘉颖,小小彬,李呈媛","cat":"剧情,喜剧,爱情","wish":16655,"3d":false,"pn":61,"preSale":0,"vd":"","time":"","id":336061},{"sn":0,"showInfo":"今天1家影院放映1场","cnms":0,"late":false,"scm":"燕赵大地上，鬼子无处藏","src":"","img":"http://p1.meituan.net/165.220/movie/04f0da4d0be4067a3a8066982ae63dfc64193.jpg","nm":"热土悲歌","sc":0,"ver":"2D","rt":"2016-11-25上映","dur":90,"imax":false,"snum":8,"showDate":"","dir":"崔志敏","star":"邹德江,章宇,卢倩文","cat":"剧情,战争","wish":7,"3d":false,"pn":7,"preSale":0,"vd":"","time":"","id":1189305},{"sn":0,"showInfo":"2016-12-02 本周五上映","cnms":0,"late":false,"scm":"沙漠越野赛，飙车为求爱","src":"","img":"http://p0.meituan.net/165.220/movie/afb1ae81d7ef6a57c5abc20d9fcdd35920580551.jpg","nm":"沙漠之心","sc":0,"ver":"2D","rt":"本周五上映","dur":94,"imax":false,"snum":16,"showDate":"","dir":"李柯","star":"隋咏良,尤靖茹,薛祺","cat":"剧情,爱情,冒险","wish":2447,"3d":false,"pn":68,"preSale":1,"vd":"","time":"","id":1197460},{"sn":0,"showInfo":"2016-12-09 下周五上映","cnms":0,"late":false,"scm":"牧羊人进城，打碎纯真梦","src":"","img":"http://p1.meituan.net/165.220/movie/edb74b337c4f3175b2a45b045619963d460760.jpg","nm":"塔洛","sc":0,"ver":"2D","rt":"下周五上映","dur":120,"imax":false,"snum":427,"showDate":"","dir":"万玛才旦","star":"西德尼玛,杨秀措,扎西","cat":"剧情","wish":2153,"3d":false,"pn":44,"preSale":1,"vd":"","time":"","id":337708},{"sn":0,"showInfo":"今天暂无场次","cnms":0,"late":false,"scm":"医生有武器，心计和身体","src":"","img":"http://p0.meituan.net/165.220/movie/917740c10fed0a65f057c3acc14f4eab393827.jpg","nm":"判我有罪","sc":6.5,"ver":"2D","rt":"2016-05-06上映","dur":102,"imax":false,"snum":1348,"showDate":"","dir":"孙亮","star":"吴镇宇,戴立忍,李昕芸","cat":"悬疑,剧情","wish":5709,"3d":false,"pn":88,"preSale":0,"vd":"","time":"","id":343082},{"sn":0,"showInfo":"今天暂无场次","cnms":0,"late":false,"scm":"离家把侄寻，帮人带书信","src":"","img":"http://p0.meituan.net/165.220/movie/d089ecbfb74fc1a234b7b1b8c5cadcf0516192.jpg","nm":"路边野餐","sc":8.1,"ver":"2D","rt":"2016-07-15上映","dur":113,"imax":false,"snum":6050,"showDate":"","dir":"毕赣","star":"陈永忠,郭月,余世学","cat":"剧情,悬疑","wish":5647,"3d":false,"pn":95,"preSale":0,"vd":"","time":"","id":342073},{"sn":0,"showInfo":"今天暂无场次","cnms":0,"late":false,"scm":"红军历万难，决战生死间","src":"","img":"http://p0.meituan.net/165.220/movie/91b3eb5fd8ea1f15e6a4a6c35842f63389899.jpg","nm":"遵义会议","sc":0,"ver":"2D","rt":"2016-10-10上映","dur":94,"imax":false,"snum":443,"showDate":"","dir":"刘星,胡明钢,于兰","star":"佟瑞欣,郭伟华,马晓伟","cat":"战争,历史,剧情","wish":331,"3d":false,"pn":0,"preSale":0,"vd":"","time":"","id":1189048},{"sn":0,"showInfo":"今天暂无场次","cnms":0,"late":false,"scm":"东方魔幻书，怪力乱神出","src":"","img":"http://p0.meituan.net/165.220/movie/dd9d76aaa8a1bdad4f2907b78efb594f95916.jpeg","nm":"聊斋新编之画皮新娘","sc":5,"ver":"2D","rt":"2016-11-11上映","dur":88,"imax":false,"snum":4428,"showDate":"","dir":"摩撒利","star":"殷果儿,丁汇宇,刘小奇","cat":"爱情,惊悚,悬疑","wish":17879,"3d":false,"pn":34,"preSale":0,"vd":"","time":"","id":346546}]
     */

    private DataBean data;

    public ControlBean getControl() {
        return control;
    }

    public void setControl(ControlBean control) {
        this.control = control;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class ControlBean {
        private int expires;

        public int getExpires() {
            return expires;
        }

        public void setExpires(int expires) {
            this.expires = expires;
        }
    }

    public static class DataBean {
        private boolean hasNext;
        /**
         * sn : 0
         * showInfo : 今天165家影院放映2090场
         * cnms : 0
         * late : false
         * scm : 神奇动物城，法师显超能
         * src :
         * img : http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg
         * nm : 神奇动物在哪里
         * sc : 9
         * ver : 3D/IMAX 3D/中国巨幕
         * rt : 2016-11-25上映
         * dur : 133
         * imax : true
         * snum : 103056
         * showDate :
         * dir : 大卫·叶茨
         * star : 埃迪·雷德梅恩,凯瑟琳·沃特斯顿,艾莉森·萨多尔
         * cat : 冒险,奇幻,家庭
         * wish : 130686
         * 3d : true
         * pn : 236
         * preSale : 0
         * vd :
         * time :
         * id : 248918
         */

        private List<MoviesBean> movies;

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class MoviesBean {
            private int sn;
            private String showInfo;
            private int cnms;
            private boolean late;
            private String scm;
            private String src;
            private String img;
            private String nm;
            private float sc;
            private String ver;
            private String rt;
            private int dur;
            private boolean imax;
            private int snum;
            private String showDate;
            private String dir;
            private String star;
            private String cat;
            private int wish;
            @SerializedName("3d")
            private boolean value3d;
            private int pn;
            private int preSale;
            private String vd;
            private String time;
            private int id;

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public int getCnms() {
                return cnms;
            }

            public void setCnms(int cnms) {
                this.cnms = cnms;
            }

            public boolean isLate() {
                return late;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public float getSc() {
                return sc;
            }

            public void setSc(float sc) {
                this.sc = sc;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public boolean isImax() {
                return imax;
            }

            public void setImax(boolean imax) {
                this.imax = imax;
            }

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public String getShowDate() {
                return showDate;
            }

            public void setShowDate(String showDate) {
                this.showDate = showDate;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public boolean isValue3d() {
                return value3d;
            }

            public void setValue3d(boolean value3d) {
                this.value3d = value3d;
            }

            public int getPn() {
                return pn;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public int getPreSale() {
                return preSale;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public String getVd() {
                return vd;
            }

            public void setVd(String vd) {
                this.vd = vd;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
