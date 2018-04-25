CREATE TABLE "public".torres_sotano
(
  layer TEXT
, ID_UTC TEXT
, ID_CENTRO TEXT
, TIPO_DE_US DOUBLE PRECISION
, Area_Geom DOUBLE PRECISION
)
;
SELECT AddGeometryColumn('public','torres_sotano','the_geom',25830,'GEOMETRY',2);


INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675820.0179584331 4616781.436793648, 675820.0195709639 4616781.2934355, 675820.6344897454 4616781.300028307, 675820.6328772146 4616781.443386455, 675827.4716691708 4616781.516708069, 675827.4732817016 4616781.373349921, 675828.0882094274 4616781.379942824, 675828.0865968966 4616781.523300972, 675834.9178990739 4616781.596542283, 675834.9195116047 4616781.453184135, 675835.5344393305 4616781.459777039, 675835.5328267997 4616781.603135186, 675842.3716187559 4616781.6764568, 675842.3732312866 4616781.533098652, 675842.9881511861 4616781.5396914715, 675842.9865386554 4616781.683049619, 675844.9990217714 4616781.704626311, 675844.9995672583 4616781.656131116, 675848.2734581545 4616781.691231901, 675848.317899013 4616777.740324931, 675846.5929891926 4616777.721831435, 675846.587992467 4616778.165953818, 675843.0265293933 4616778.127769849, 675843.0236268636 4616778.385812222, 675842.4087069641 4616778.379219403, 675842.4116094938 4616778.12117703, 675835.5728175376 4616778.047855416, 675835.5699150079 4616778.305897789, 675834.9549872822 4616778.299304886, 675834.9578898118 4616778.041262513, 675828.1265876346 4616777.968021202, 675828.1236851049 4616778.226063575, 675827.508757379 4616778.219470671, 675827.5116599087 4616777.961428299, 675820.6728679525 4616777.888106685, 675820.6699654228 4616778.146149058, 675820.0550466414 4616778.139556251, 675820.057949171 4616777.881513878, 675816.4964849793 4616777.843329897, 675816.5014805868 4616777.399207503, 675814.7765696484 4616777.380713996, 675814.7321287899 4616781.331620965, 675818.006019686 4616781.366721749, 675818.0054741991 4616781.415216944, 675820.0179584331 4616781.436793648)))',25830),'S1.030','S1.030','PASILLO',31,119.5);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675816.6095782914 4616777.729844364, 675820.0592391699 4616777.766829654, 675820.062141764 4616777.508781547, 675820.3136994982 4616777.511478605, 675820.3964840686 4616770.151716731, 675816.8629653944 4616770.113832366, 675816.8278951158 4616773.232366462, 675816.660187351 4616773.230568395, 675816.6095782914 4616777.729844364)))',25830),'S1.040','S1.040','CUARTO BOMBAS',34,27.6);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675820.455494779 4616774.84621459, 675820.4255016933 4616777.512677284, 675820.6770605454 4616777.515374354, 675820.6741579514 4616777.773422461, 675827.019062777 4616777.841448899, 675827.0519584569 4616774.916938098, 675823.8096277155 4616774.882175684, 675820.455494779 4616774.84621459)))',25830),'S1.050','S1.050','CS 31',27,19.2);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675820.4567847778 4616774.7315303655, 675827.0532484556 4616774.802253874, 675827.066148702 4616773.655388692, 675831.5347090773 4616773.703298039, 675831.5733103168 4616770.271548265, 675827.2165521366 4616770.224837597, 675820.5082862637 4616770.15291541, 675820.4567847778 4616774.7315303655)))',25830),'S1.080','S1.080','PASILLO',50,45.5);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675835.9561924719 4616777.937267688, 675835.9903781505 4616774.898072663, 675842.6986440235 4616774.96999485, 675842.7501455094 4616770.391379895, 675836.0418796364 4616770.319457707, 675831.6851214563 4616770.27274704, 675831.6465202168 4616773.704496814, 675833.323586685 4616773.722477361, 675833.27650076 4616777.908537568, 675834.9591798107 4616777.926578289, 675834.9620824048 4616777.668530182, 675835.5770101305 4616777.675123085, 675835.5741075365 4616777.933171192, 675835.9561924719 4616777.937267688)))',25830),'S1.100','S1.100','BAÑOS',7,56.7);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675836.1008903469 4616775.013955566, 675836.0679946671 4616777.938466367, 675842.4128994927 4616778.006492806, 675842.4158020867 4616777.748444699, 675842.667360939 4616777.751141769, 675842.6973540247 4616775.084679075, 675839.3432210882 4616775.048717981, 675836.1008903469 4616775.013955566)))',25830),'S1.110','S1.110','CS 31',2,19.2);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675842.8619477045 4616770.392578574, 675842.779163134 4616777.752340448, 675843.0307219862 4616777.755037518, 675843.0278193922 4616778.013085625, 675846.4774791527 4616778.050070902, 675846.5280882124 4616773.550794933, 675846.3603804475 4616773.548996867, 675846.3954585523 4616770.430462855, 675842.8619477045 4616770.392578574)))',25830),'S1.120','S1.120','ALMACEN MANTENIMIENTO',2,27.6);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675844.997731708 4616781.819316269, 675842.985248592 4616781.7977395775, 675842.9810559991 4616782.1704719085, 675842.84130046 4616782.16897353, 675842.7556419083 4616789.784239763, 675843.1469551815 4616789.7884352, 675843.1386768869 4616790.524396937, 675842.7473636137 4616790.5202015005, 675842.6653028762 4616797.81561277, 675843.0566161494 4616797.8198082065, 675843.0527350199 4616798.164850624, 675842.6614217467 4616798.160655187, 675842.5793610092 4616805.456066457, 675842.9706742824 4616805.460261893, 675842.96679314 4616805.805305458, 675842.4916298976 4616805.800211029, 675842.4078004459 4616813.252865543, 675842.8829636883 4616813.257959971, 675842.8790825589 4616813.603002389, 675842.4039193165 4616813.59790796, 675842.3221557103 4616820.866903484, 675842.5457612185 4616820.869300854, 675842.5415685868 4616821.242036626, 675844.5540517028 4616821.263613317, 675844.997731708 4616781.819316269)))',25830),'S1.150','S1.150','PASILLO',31,85.3);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675842.3286040042 4616797.92670552, 675842.4315797564 4616788.771895494, 675842.5058916386 4616782.165377468, 675842.3661360996 4616782.163879089, 675842.3677486303 4616782.020520941, 675839.6854089261 4616781.99176243, 675839.6879890527 4616781.762382513, 675837.6755148167 4616781.740811651, 675837.6729347545 4616781.970185834, 675837.3645003334 4616781.966878977, 675837.3386998407 4616784.26060934, 675839.6865928962 4616784.285782105, 675840.791736962 4616785.444634318, 675840.7545132883 4616788.753914948, 675838.6331225254 4616788.73117061, 675838.5301467732 4616797.885980635, 675842.3286040042 4616797.92670552)))',25830),'S1.160','S1.160','CS 5 PASILLO',31,55.1);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675835.202764526 4616788.579694219, 675840.6439921476 4616788.638031947, 675840.6793915073 4616785.490937552, 675839.6389856756 4616784.399969744, 675837.2256054106 4616784.374094862, 675837.2526959023 4616781.965680273, 675835.5289566742 4616781.947199328, 675835.5273441434 4616782.090557476, 675835.2757864093 4616782.087860418, 675835.202764526 4616788.579694219)))',25830),'S1.170','S1.170','CS 8 TUNA',30,27.2);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675831.2162718981 4616805.334237918, 675834.6504769668 4616805.371057499, 675834.6520894975 4616805.2276993515, 675835.2670172233 4616805.234292255, 675835.2654046925 4616805.3776504025, 675842.2439521877 4616805.452470395, 675842.3273139925 4616798.04139089, 675835.3487664973 4616797.966570898, 675835.3458639677 4616798.224613271, 675834.7309362419 4616798.218020367, 675834.7338387716 4616797.959977995, 675831.299633703 4616797.923158414, 675831.2162718981 4616805.334237918)))',25830),'S1.180','S1.180','CS 6',44,81.5);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675820.225710598 4616805.2154227225, 675827.2042470636 4616805.291223285, 675827.2058595944 4616805.147865137, 675827.4294651027 4616805.150262508, 675827.5083118471 4616798.140583524, 675827.2847063388 4616798.138186153, 675827.2876088684 4616797.88014378, 675820.3090613732 4616797.805323788, 675820.225710598 4616805.2154227225)))',25830),'S1.190','S1.190','CUARTO LIMPIEZA',27,53.3);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675820.3103513849 4616797.690638417, 675827.2888988801 4616797.76545841, 675827.2918014614 4616797.50741145, 675827.5154069697 4616797.509808821, 675827.5942537141 4616790.500129837, 675827.3706482057 4616790.497732466, 675827.3821404935 4616789.476038444, 675827.6336982276 4616789.478735502, 675827.7177442486 4616782.006827416, 675827.4661865145 4616782.004130358, 675827.4677990453 4616781.86077221, 675824.4981613635 4616781.828933454, 675824.5007414902 4616781.599553537, 675822.4882673185 4616781.577976941, 675822.4856871918 4616781.807356859, 675820.6290070891 4616781.787450597, 675820.6273945583 4616781.930808744, 675820.4876390193 4616781.929310366, 675820.4629637601 4616784.123004553, 675823.863599027 4616784.159464218, 675823.8109764048 4616788.837751087, 675820.4103411379 4616788.801291422, 675820.3103513849 4616797.690638417)))',25830),'S1.200','S1.200','CS 10',26,99);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675827.9919670491 4616789.93613854, 675834.8232692264 4616790.009379851, 675834.8283703966 4616789.555872658, 675835.0799381932 4616789.558569824, 675835.1639842142 4616782.086661738, 675834.9124164176 4616782.083964572, 675834.9140289484 4616781.940606425, 675828.0827267711 4616781.867365113, 675828.0811142403 4616782.010723261, 675827.8295475618 4616782.008026107, 675827.7455015408 4616789.479934193, 675827.9970682194 4616789.482631347, 675827.9919670491 4616789.93613854)))',25830),'S1.205','S1.205','CS 9',2,58.9);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675817.5605041306 4616820.974203951, 675819.5729883646 4616820.995780654, 675819.5771809963 4616820.623044883, 675819.8007853866 4616820.625442241, 675819.8825489928 4616813.356446718, 675819.4073857503 4616813.351352289, 675819.4112668798 4616813.006309872, 675819.8864301222 4616813.0114043, 675819.9702706035 4616805.557769217, 675819.4951073611 4616805.552674788, 675819.4989885035 4616805.207631224, 675819.8903028946 4616805.211826673, 675819.9723636709 4616797.916411963, 675819.5810492798 4616797.912216514, 675819.5849304092 4616797.567174097, 675819.9762448004 4616797.5713695455, 675820.0582944695 4616790.276942287, 675819.6669800783 4616790.272746838, 675819.6752583729 4616789.536785101, 675820.0665727641 4616789.5409805495, 675820.1522313158 4616781.925714316, 675820.0124757768 4616781.924215937, 675820.0166683698 4616781.551483606, 675818.0041841357 4616781.529906902, 675817.5605041306 4616820.974203951)))',25830),'S1.210','S1.210','PASILLO',31,85.3);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675820.2748308509 4616813.274631866, 675820.2722508531 4616813.5040003145, 675820.0486453449 4616813.501602944, 675820.0092995419 4616816.999546336, 675842.1952520998 4616817.237411422, 675842.2345979027 4616813.73946803, 675842.0109923944 4616813.737070659, 675842.0135723922 4616813.507702211, 675835.174780436 4616813.434380597, 675835.1722004382 4616813.663749046, 675834.5572727125 4616813.657156142, 675834.5598527102 4616813.427787694, 675827.728550533 4616813.354546383, 675827.7259705352 4616813.583914831, 675827.1110428093 4616813.577321928, 675827.1136228071 4616813.34795348, 675820.2748308509 4616813.274631866)))',25830),'S1.220','S1.220','CS 13',31,82.3);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675820.0557404159 4616812.870832829, 675820.2793459242 4616812.873230199, 675820.2767659136 4616813.102599795, 675827.1155578698 4616813.175921408, 675827.1181378803 4616812.946551813, 675827.3417433887 4616812.948949183, 675827.4223699284 4616805.781041797, 675827.1987644201 4616805.778644427, 675827.2003769509 4616805.635286279, 675820.1379794865 4616805.559567295, 675820.0557404159 4616812.870832829)))',25830),'S1.230','S1.230','CS 14',39,54.8);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675827.5094511536 4616812.95074725, 675827.7330656062 4616812.953144716, 675827.7304855956 4616813.182514312, 675834.5617877729 4616813.255755623, 675834.5643677835 4616813.026386027, 675834.7879822361 4616813.028783494, 675834.8686087759 4616805.860876108, 675834.6449943233 4616805.858478641, 675834.646606854 4616805.715120493, 675827.8153046768 4616805.641879182, 675827.813692146 4616805.78523733, 675827.5900776933 4616805.782839864, 675827.5094511536 4616812.95074725)))',25830),'S1.240','S1.240','CS 15',34,54.7);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675827.5094511536 4616812.95074725, 675827.7330656062 4616812.953144716, 675827.7304855956 4616813.182514312, 675834.5617877729 4616813.255755623, 675834.5643677835 4616813.026386027, 675834.7879822361 4616813.028783494, 675834.8686087759 4616805.860876108, 675834.6449943233 4616805.858478641, 675834.646606854 4616805.715120493, 675827.8153046768 4616805.641879182, 675827.813692146 4616805.78523733, 675827.5900776933 4616805.782839864, 675827.5094511536 4616812.95074725)))',25830),'S1.240','S1.240','CS 15',34,54.7);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675834.9556911191 4616813.030581572, 675835.1792955092 4616813.0329789305, 675835.1767154987 4616813.262348526, 675842.0155074549 4616813.33567014, 675842.0180874654 4616813.106300544, 675842.2416929738 4616813.1086979145, 675842.3239210147 4616805.798412951, 675835.2615345798 4616805.721713397, 675835.259922049 4616805.865071544, 675835.0363176588 4616805.862674186, 675834.9556911191 4616813.030581572)))',25830),'S1.250','S1.250','CS 16',37,54.8);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675819.9615095061 4616833.674330141, 675821.098268762 4616833.6865178235, 675821.1008487726 4616833.457148227, 675821.3244621071 4616833.45954568, 675821.3231721084 4616833.574229905, 675821.4349754215 4616833.575428597, 675821.4336854097 4616833.690113968, 675826.8003014622 4616833.747651754, 675826.801591474 4616833.632966382, 675826.9133936692 4616833.634165062, 675826.915328719 4616833.462134138, 675827.474350875 4616833.468127653, 675827.4711258134 4616833.754843948, 675833.1695684734 4616833.815939389, 675833.3137286749 4616820.999725571, 675834.4745415362 4616821.012171142, 675834.4771216371 4616820.782793518, 675835.0920493628 4616820.789386421, 675835.0894692619 4616821.018764045, 675841.9282612181 4616821.092085659, 675841.930841319 4616820.862708035, 675842.1544468274 4616820.865105405, 675842.1933170499 4616817.409442346, 675820.007364492 4616817.17157726, 675819.9684942695 4616820.62724032, 675820.1920997777 4616820.62963769, 675820.1850046036 4616821.260416981, 675820.067614423 4616821.259158391, 675819.9863428321 4616828.4844124755, 675820.0198830435 4616828.484772075, 675819.9615095061 4616833.674330141)))',25830),'S1.260','S1.260','SALA CALDERA',34,250.8);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675833.4795013771 4616821.173555709, 675833.3372762382 4616833.817737456, 675834.3583346786 4616833.828684661, 675834.3615597402 4616833.541968365, 675834.9205818962 4616833.54796188, 675834.9186468464 4616833.719992804, 675835.0304490415 4616833.721191484, 675835.0291590297 4616833.835876855, 675840.3957750822 4616833.893414641, 675840.397065094 4616833.778729269, 675840.5088684072 4616833.779927961, 675840.510158406 4616833.665243736, 675840.7337728586 4616833.667641201, 675840.7311928481 4616833.897010798, 675841.8679509859 4616833.909198469, 675841.9263245233 4616828.719640402, 675841.9598647346 4616828.720000001, 675842.0411363255 4616821.494745916, 675841.9237461449 4616821.4934873255, 675841.9263261554 4616821.26411773, 675835.0875341992 4616821.190796116, 675835.0849541887 4616821.420165712, 675834.4700264629 4616821.413572809, 675834.4726064735 4616821.184203213, 675833.4795013771 4616821.173555709)))',25830),'S1.270','S1.270','SALA CALDERA',35,107.7);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675815.7490651282 4616825.943757005, 675817.6134073727 4616825.963745415, 675817.647206057 4616822.958955199, 675817.8037322607 4616822.960633384, 675817.8008941936 4616823.212944871, 675819.6652274939 4616823.232933186, 675819.6874748847 4616821.255082753, 675819.5700858221 4616821.2538241735, 675819.5716983529 4616821.110466026, 675817.5592141189 4616821.088889322, 675817.5585746794 4616821.145737136, 675815.8032462274 4616821.126917508, 675815.7490651282 4616825.943757005)))',25830),'S1.280','S1.280','RELLANO',31,13.2);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675815.6535388296 4616834.436291382, 675817.4368183895 4616834.455410684, 675817.5038996706 4616828.49171174, 675819.572281648 4616828.513887748, 675819.5726630825 4616828.479977238, 675819.6062032938 4616828.4803368375, 675819.6652274939 4616823.232933186, 675817.8903388566 4616823.213903845, 675817.8008941936 4616823.212944871, 675817.7670955095 4616826.2177350875, 675817.6105693057 4616826.216056903, 675817.6134073727 4616825.963745415, 675815.7490651282 4616825.943757005, 675815.6535388296 4616834.436291382)))',25830),'S1.300','S1.300','PASILLO',31,25.6);
INSERT INTO "public".torres_sotano(the_geom, layer, ID_UTC, ID_CENTRO, TIPO_DE_US, Area_Geom) VALUES (ST_GeomFromText('MULTIPOLYGON (((675817.5486228206 4616834.456609388, 675819.505200367 4616834.477586692, 675819.5709916234 4616828.628574266, 675817.6144140771 4616828.607596962, 675817.5486228206 4616834.456609388)))',25830),'S1.310','S1.310','ALMACEN',31,11.4);
