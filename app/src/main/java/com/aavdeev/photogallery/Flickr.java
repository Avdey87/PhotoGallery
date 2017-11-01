package com.aavdeev.photogallery;


import java.util.List;

public class Flickr {

    public PhotosBean photos;
    public String stat;

    public PhotosBean getPhotos() {
        return photos;
    }

    public void setPhotos(PhotosBean photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public static class PhotosBean {
        /**
         * page : 1
         * pages : 10
         * perpage : 100
         * total : 1000
         * photo : [{"id":"24116386528","owner":"156464463@N04","secret":"a55f64eee5","server":"4449","farm":5,"title":"IMG_0283","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116390418","owner":"134230984@N04","secret":"a4e381f288","server":"4483","farm":5,"title":"","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116390498","owner":"23333771@N08","secret":"1648ef7aff","server":"4490","farm":5,"title":"As seen in nature: Rebel or Trendsetter? 🍁 . . . #fall2017 #lakewaban #autumnleaves #turningleaves #naturephotography #nature #trendsetter #canon5dmarkiii #lensbaby #mastinlabs @seeinanewway #mapleleaves #🍁","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116392618","owner":"146918691@N05","secret":"9305f0e1b0","server":"4464","farm":5,"title":"_DSC0108.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116393778","owner":"94236925@N05","secret":"1c4340a39e","server":"4450","farm":5,"title":"","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116394618","owner":"155402951@N02","secret":"19beaa760c","server":"4456","farm":5,"title":"imsi20171027115237","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116395208","owner":"151751311@N02","secret":"21cff850cd","server":"4500","farm":5,"title":"اصلاح\u200cطلبم و راه فرجی\u200cدانا را ادامه می\u200cدهم \u2013 فوج نیوز فوج نیوز: اخبار کنکور و دانشگاه تاریخ انتشار : شنبه, ۲۹ مهر ۱۳۹۶ ۰۷:۴۲ «آقای فرجی دانا بر اساس همان سوابق قبلی ما را به درد سر انداخت و درست یک هفته بعد از این که من آمدم، رفت. قطعا من راه فرجی دانا را","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116396408","owner":"11839279@N05","secret":"4a01529e94","server":"4455","farm":5,"title":"The Crinste Family artist reception 10/28 at Clarkston Community Center #acpfest","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116397638","owner":"46232173@N07","secret":"126404d44c","server":"4512","farm":5,"title":"Good times with Edmondson in town!","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116398628","owner":"147757074@N05","secret":"f041a3e312","server":"4504","farm":5,"title":"#2017says Trump! trump, mrw, people, files, jfk http://ift.tt/2zc2XaM","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116399718","owner":"153042213@N06","secret":"1bcf04b4b3","server":"4465","farm":5,"title":"imsi20171027115210","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116401738","owner":"39456881@N03","secret":"edda1ee8e1","server":"4446","farm":5,"title":"Untitled","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116402668","owner":"45431615@N00","secret":"62764d9a57","server":"4489","farm":5,"title":"Three Jumbo Marshmallows","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116405638","owner":"153233493@N05","secret":"2509e19619","server":"4453","farm":5,"title":"[EP] Danagog - Lost Tapes | @DanagogHKN","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116406578","owner":"49753711@N06","secret":"06bf661b0e","server":"4448","farm":5,"title":"20171021_203211","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116409168","owner":"60390222@N05","secret":"6d1ed2a925","server":"4449","farm":5,"title":"66848","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116409598","owner":"136175993@N04","secret":"3913962d0a","server":"4501","farm":5,"title":"Monument Valley in Southern UTAH","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116412438","owner":"7374177@N03","secret":"bea7d78cfe","server":"4459","farm":5,"title":"DUS_1186r","ispublic":1,"isfriend":0,"isfamily":0},{"id":"24116412968","owner":"12482362@N04","secret":"8ab054d9e7","server":"4450","farm":5,"title":"20171008-041.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"26191831699","owner":"154140146@N08","secret":"d2cbeaeb9a","server":"4470","farm":5,"title":"2017-10-27_10-47-00","ispublic":1,"isfriend":0,"isfamily":0},{"id":"26191832499","owner":"134238904@N04","secret":"cff0d9fdb6","server":"4501","farm":5,"title":"Home of Barbara Hvid","ispublic":1,"isfriend":0,"isfamily":0},{"id":"26191832769","owner":"149739395@N06","secret":"9147dc50b3","server":"4496","farm":5,"title":"1509114995-anh-chan-dung-tu-camera-ai-cua-google-pixel-2","ispublic":1,"isfriend":0,"isfamily":0},{"id":"26191835409","owner":"111633480@N03","secret":"098376381f","server":"4501","farm":5,"title":"Serpent Mound, Kentucky","ispublic":1,"isfriend":0,"isfamily":0},{"id":"26191838539","owner":"51300219@N02","secret":"4f1b410924","server":"4503","farm":5,"title":"SDQH1486","ispublic":1,"isfriend":0,"isfamily":0},{"id":"26191838669","owner":"139791896@N06","secret":"d2cbc39dd8","server":"4511","farm":5,"title":"West Staffa across McKinnons Cove, 1987","ispublic":1,"isfriend":0,"isfamily":0},{"id":"26191838969","owner":"135756588@N08","secret":"cd5eee7d17","server":"4455","farm":5,"title":"إعلان أبو حفيظة - إشحن وبضع ببلاش من كارفور - أورنچ - الجبنة","ispublic":1,"isfriend":0,"isfamily":0},{"id":"26191840059","owner":"101398523@N07","secret":"fa50176db3","server":"4512","farm":5,"title":"2017-10-27_04-52-39","ispublic":1,"isfriend":0,"isfamily":0},{"id":"26191840469","owner":"109588595@N06","secret":"5cf44e0f43","server":"4497","farm":5,"title":"IMG_0599.JPG","ispublic":1,"isfriend":0,"isfamily":0},{"id":"26191841429","owner":"158359628@N06","secret":"57c845cca6","server":"4508","farm":5,"title":"IMG_0631","ispublic":1,"isfriend":0,"isfamily":0},{"id":"26191843639","owner":"135481364@N08","secret":"9249f76386","server":"4465","farm":5,"title":"2017-10-27_04-44-04","ispublic":1,"isfriend":0,"isfamily":0},{"id":"26191843839","owner":"156453664@N07","secret":"4170b45521","server":"4498","farm":5,"title":"IMG_20171018_195019_773","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257678444","owner":"29403330@N05","secret":"f2998047fb","server":"4485","farm":5,"title":"20171026_205626","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257684794","owner":"150491279@N03","secret":"7247344e54","server":"4499","farm":5,"title":"Seb & Albert Edwards Photoγραφείο.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257685584","owner":"12440183@N04","secret":"f8c5fcf4d4","server":"4463","farm":5,"title":"The Autumn Blaze Maple","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257688474","owner":"144429258@N06","secret":"09fc95d136","server":"4457","farm":5,"title":"2017-10-27_14.51.03.UTC.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257693564","owner":"143177986@N08","secret":"2f5504c559","server":"4497","farm":5,"title":"IMG_20171020_172548","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257696644","owner":"44955330@N05","secret":"31f503aa5a","server":"4514","farm":5,"title":"Convention 2017","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257696994","owner":"58558794@N07","secret":"e428f51282","server":"4494","farm":5,"title":"Penn Libraries Schimmel Fiction 3868: Inscription","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257697664","owner":"132866818@N04","secret":"b954434cd8","server":"4496","farm":5,"title":"IMG_3466.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257698204","owner":"153527630@N04","secret":"5c6ac15c60","server":"4448","farm":5,"title":"","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257703144","owner":"79194990@N08","secret":"0a76ce14b8","server":"4456","farm":5,"title":"","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257705914","owner":"155775144@N02","secret":"c2bacf23f0","server":"4479","farm":5,"title":"Cách nhận biết bánh chưng luộc bằng pin độc hại","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257706134","owner":"144441294@N08","secret":"c0d5fe9f11","server":"4508","farm":5,"title":"IMG_4653","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257709004","owner":"19363422@N02","secret":"910141562d","server":"4459","farm":5,"title":"FSL: Trick or Treat on the Row","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37257710604","owner":"145606725@N06","secret":"20e9d6dd84","server":"4504","farm":5,"title":"Kế kiểm 59","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37914028286","owner":"40129895@N03","secret":"005f1cd461","server":"4505","farm":5,"title":"5.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37914032466","owner":"158255026@N05","secret":"b5b0b364c9","server":"4458","farm":5,"title":"Program of studies","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37914036006","owner":"150950853@N08","secret":"9ccd5a5a38","server":"4478","farm":5,"title":"2017-10-27_03-51-25","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37914036376","owner":"139986217@N03","secret":"aea93c2b51","server":"4480","farm":5,"title":"Aesthetic","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37914037296","owner":"37360125@N06","secret":"566f25835f","server":"4443","farm":5,"title":"Sales room Color Infusion Exclusives","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37914038306","owner":"153046354@N04","secret":"7fa5301422","server":"4443","farm":5,"title":"Air","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37914038316","owner":"153591378@N08","secret":"d5096c8600","server":"4476","farm":5,"title":"Husqvarna Construction Products 966481901 K 760 Cut and Break Deep Cutting Saw","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37914041086","owner":"140100007@N02","secret":"94ab6db4bd","server":"4455","farm":5,"title":"DSCN3883","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37914041346","owner":"137473377@N04","secret":"c3de93b805","server":"4470","farm":5,"title":"imsi20171027095245","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37914047016","owner":"105760685@N05","secret":"1a5e0e20f1","server":"4487","farm":5,"title":"R4020651.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37914048616","owner":"149875123@N06","secret":"5901c86ec5","server":"4443","farm":5,"title":"IMG_20171002_183901","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37914048836","owner":"144884853@N08","secret":"73dfa6b921","server":"4503","farm":5,"title":"Photo","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37914049116","owner":"130767399@N02","secret":"0cee0eb539","server":"4450","farm":5,"title":"PLEASE READ!!! I need red and black wrestling shoes in decent condition for this season size 9-10.5 I have 300 and bnibwt all white ultra boost otw","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936851032","owner":"66823268@N05","secret":"2366b10fe7","server":"4499","farm":5,"title":"171025-CONI-ScuoleMedie-93","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936855722","owner":"151809840@N04","secret":"7d955eefd1","server":"4452","farm":5,"title":"Fast Relief of all Car Crash Pain Symptoms Call Now","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936855752","owner":"89169354@N02","secret":"136bbcabe4","server":"4506","farm":5,"title":"Transjapa Turismo - Carro 1 -27.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936856192","owner":"122158273@N02","secret":"3fe49474d4","server":"4478","farm":5,"title":"Jackson Hole Sept 2017","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936858182","owner":"31291728@N05","secret":"7a726d40e9","server":"4494","farm":5,"title":"IMG_2711 (1 of 10)","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936859052","owner":"155807027@N08","secret":"d4aa1e065c","server":"4453","farm":5,"title":"WS1992 Gm1: Carter homers off Glavine in 4th","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936859202","owner":"153375220@N04","secret":"71730097f6","server":"4510","farm":5,"title":"imsi20171027115226","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936859322","owner":"94583930@N00","secret":"c489688beb","server":"4502","farm":5,"title":"Readymade Victroian Clothing Florenzo Vol 2 Fancy Poly Crepe Western Top Full Set-RAJ04655","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936860492","owner":"151888145@N08","secret":"0bf3782aff","server":"4469","farm":5,"title":"Cómo hacer ensalada chilena nortina - ParaCocinar.Org","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936862202","owner":"39730574@N07","secret":"483f681380","server":"4448","farm":5,"title":"Fri, Oct 27th, 2017 Lost Male Cat - Butterfield Grove, South Dublin","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936863422","owner":"102009808@N03","secret":"a612a9847f","server":"4454","farm":5,"title":"#Repost @capochino67 #beautiful #bestoftheday #nature #picoftheday #photooftheday #instagood #fun #gorgeous #warm #view #outdoor #unitedstates #today #happy #me #followme #follow #forever #love #light #flowers #naturelovers colors #beautiful","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936867332","owner":"158794660@N03","secret":"71c36485a1","server":"4449","farm":5,"title":"We prefer the man who follows the rule of law, not the man twice removed from office for failing to follow the rule\u2026 https://t.co/XXuckvG5qq","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936867922","owner":"132123672@N06","secret":"1cdd4670ea","server":"4514","farm":5,"title":"2017-GHS-FIELDHOCKEY-V-SWAMPSCOTT2-5758.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936868882","owner":"84267069@N08","secret":"ca226ca279","server":"4453","farm":5,"title":"Rock Dragon Trail Cairns","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936870442","owner":"113577107@N06","secret":"4de9a62de9","server":"4490","farm":5,"title":"Crib Goch, early this morning.","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936871282","owner":"153337969@N02","secret":"6a6b516d16","server":"4470","farm":5,"title":"","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936873102","owner":"136031761@N07","secret":"fd08559438","server":"4506","farm":5,"title":"Luna kitty","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936873222","owner":"148027030@N05","secret":"8257ec6838","server":"4470","farm":5,"title":"2017-10-27_03-53-00","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37936874272","owner":"79374494@N05","secret":"d735d58bd0","server":"4450","farm":5,"title":"","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967335241","owner":"147371156@N03","secret":"db34cd2916","server":"4488","farm":5,"title":"Choice is a function of awareness.    Raise your awareness through personal deve...","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967336661","owner":"99150495@N05","secret":"d38edbe69a","server":"4466","farm":5,"title":"1509115859497","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967336671","owner":"10553078@N00","secret":"bd315bf044","server":"4496","farm":5,"title":"42407 - P407 MLA","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967340841","owner":"113346784@N05","secret":"a6013bb757","server":"4493","farm":5,"title":"image","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967342461","owner":"45036157@N04","secret":"70ebbcd32a","server":"4502","farm":5,"title":"Skillsmatter","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967345781","owner":"97879966@N03","secret":"72e45c3a0f","server":"4452","farm":5,"title":"DSC_5849-Edit-Edit.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967345981","owner":"138375889@N04","secret":"e6eddc1ee9","server":"4469","farm":5,"title":"PARASYTES (Montreal, CA) live at Nightmare Arrived #3  Thursday, 26 October 2017 at Hellish Room. Malang, East Java","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967347011","owner":"99439991@N00","secret":"f248dfb362","server":"4494","farm":5,"title":"2017-10-26-18-19-04-3.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967348041","owner":"143510592@N02","secret":"483a8b7421","server":"4485","farm":5,"title":"Yu-Gi-Oh! Duel Links Hack Updates October 27, 2017 at 07:37PM","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967350771","owner":"143688085@N05","secret":"ba7918120c","server":"4464","farm":5,"title":"Long Jump Pit in Sealand | Specialists #Long #Jump #Sand #Pit...","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967351471","owner":"53572308@N04","secret":"8108242a56","server":"4483","farm":5,"title":"PSX_20171023_220228","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967352281","owner":"52049139@N00","secret":"3c9b8d2787","server":"4495","farm":5,"title":"Hint of Gold","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967354921","owner":"150252643@N06","secret":"64a3117a25","server":"4459","farm":5,"title":"IMG_3399.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967355381","owner":"142148102@N06","secret":"762d055818","server":"4484","farm":5,"title":"The Void (2017) แทรกร่างสยอง","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967359091","owner":"47826435@N04","secret":"d1efda1638","server":"4446","farm":5,"title":"","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967359561","owner":"42241132@N08","secret":"172dbb7123","server":"4454","farm":5,"title":"BO5A2758.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967362231","owner":"141277767@N08","secret":"800dd35921","server":"4462","farm":5,"title":"IMG-20170512-WA0036","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967362261","owner":"15304966@N06","secret":"47159b7c25","server":"4506","farm":5,"title":"20171010-102612-sw.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967362331","owner":"135534555@N07","secret":"6962452df0","server":"4499","farm":5,"title":"IOWMCC Frank Pragnell Cup 2017-9365.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967366191","owner":"49118647@N08","secret":"5dc58def8e","server":"4452","farm":5,"title":"CamGrab [LW.20171027155230.jpg]","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967366921","owner":"75569960@N02","secret":"3e7a27ec84","server":"4469","farm":5,"title":"_DSC0138.jpg","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967369081","owner":"154461975@N06","secret":"02079525f8","server":"4507","farm":5,"title":"","ispublic":1,"isfriend":0,"isfamily":0},{"id":"37967369341","owner":"77485673@N07","secret":"9e1de47c31","server":"4502","farm":5,"title":"Campagna Balocco - 27.10.2010 - commenti Facebook","ispublic":1,"isfriend":0,"isfamily":0}]
         */

        public int page;
        public int pages;
        public int perpage;
        public int total;
        public List<PhotoBean> photo;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPerpage() {
            return perpage;
        }

        public void setPerpage(int perpage) {
            this.perpage = perpage;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<PhotoBean> getPhoto() {
            return photo;
        }

        public void setPhoto(List<PhotoBean> photo) {
            this.photo = photo;
        }

        public  class PhotoBean {
            /**
             * id : 24116386528
             * owner : 156464463@N04
             * secret : a55f64eee5
             * server : 4449
             * farm : 5
             * title : IMG_0283
             * ispublic : 1
             * isfriend : 0
             * isfamily : 0
             */

            public String id;
            public String url_s;
            private String owner;
            private String secret;
            public String server;
            private int farm;
            public String title;
            private int ispublic;
            private int isfriend;
            private int isfamily;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOwner() {
                return owner;
            }

            public void setOwner(String owner) {
                this.owner = owner;
            }

            public String getSecret() {
                return secret;
            }

            public void setSecret(String secret) {
                this.secret = secret;
            }

            public String getServer() {
                return server;
            }

            public void setServer(String server) {
                this.server = server;
            }

            public int getFarm() {
                return farm;
            }

            public void setFarm(int farm) {
                this.farm = farm;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getIspublic() {
                return ispublic;
            }

            public void setIspublic(int ispublic) {
                this.ispublic = ispublic;
            }

            public int getIsfriend() {
                return isfriend;
            }

            public void setIsfriend(int isfriend) {
                this.isfriend = isfriend;
            }

            public int getIsfamily() {
                return isfamily;
            }

            public void setIsfamily(int isfamily) {
                this.isfamily = isfamily;
            }
        }
    }




}




