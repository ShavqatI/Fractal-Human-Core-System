--
-- PostgreSQL database dump
--

-- Dumped from database version 17.0 (Debian 17.0-1.pgdg120+1)
-- Dumped by pg_dump version 17.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

ALTER TABLE IF EXISTS ONLY work_schedule_schema.work_schedule DROP CONSTRAINT IF EXISTS fkofddl68hnstvtu6mt59b3o21y;
ALTER TABLE IF EXISTS ONLY work_schedule_schema.work_schedule DROP CONSTRAINT IF EXISTS fkobkvrmvmt3b6y4g9thmilankm;
ALTER TABLE IF EXISTS ONLY work_schedule_schema.work_schedule DROP CONSTRAINT IF EXISTS fkgs7xosqe71roi8nmh14u7jh2k;
ALTER TABLE IF EXISTS ONLY work_schedule_schema.work_schedule DROP CONSTRAINT IF EXISTS fk9hbbg1ay81q4wvp9htnwk1sq7;
ALTER TABLE IF EXISTS ONLY user_schema."user" DROP CONSTRAINT IF EXISTS fkpm7nbf6vwm8j4iooot5u2l2im;
ALTER TABLE IF EXISTS ONLY user_schema.profile DROP CONSTRAINT IF EXISTS fkjqs063xycojkvoknskljcvpig;
ALTER TABLE IF EXISTS ONLY user_schema.profile DROP CONSTRAINT IF EXISTS fki5u47g47odeweeaug77ku10d;
ALTER TABLE IF EXISTS ONLY user_schema."user" DROP CONSTRAINT IF EXISTS fkhnncm3gx8plxt0kxg73vb9xdl;
ALTER TABLE IF EXISTS ONLY user_schema.profile DROP CONSTRAINT IF EXISTS fkdediqdt2rpmb5bicw7upyusjy;
ALTER TABLE IF EXISTS ONLY user_schema.profile DROP CONSTRAINT IF EXISTS fkawh070wpue34wqvytjqr4hj5e;
ALTER TABLE IF EXISTS ONLY user_schema.authentication DROP CONSTRAINT IF EXISTS fkaqx19vg6d80b0kfsds35mttui;
ALTER TABLE IF EXISTS ONLY user_schema.profile DROP CONSTRAINT IF EXISTS fkae2yd89np7xx5kfphsq4osgkn;
ALTER TABLE IF EXISTS ONLY user_schema.authentication DROP CONSTRAINT IF EXISTS fk9xt16jflwvobkox5d9j9uesp3;
ALTER TABLE IF EXISTS ONLY ui_schema.component_attributes DROP CONSTRAINT IF EXISTS fkp5339s8lqrrmusc0bqlna84t4;
ALTER TABLE IF EXISTS ONLY ui_schema.attribute DROP CONSTRAINT IF EXISTS fkn4964gqnapf8bvv0youyj7qf8;
ALTER TABLE IF EXISTS ONLY ui_schema.component_attributes DROP CONSTRAINT IF EXISTS fkmojp7mllnkkf91qiaq90dh33j;
ALTER TABLE IF EXISTS ONLY ui_schema.component_attributes DROP CONSTRAINT IF EXISTS fkmd5hwk9wc88fh0xnnttejbuv4;
ALTER TABLE IF EXISTS ONLY ui_schema.attribute DROP CONSTRAINT IF EXISTS fkl32wh5igf8c2tjtdqblkhk7hp;
ALTER TABLE IF EXISTS ONLY ui_schema.component_attributes DROP CONSTRAINT IF EXISTS fkghev9yiljhqvvg6umw7fcq2nv;
ALTER TABLE IF EXISTS ONLY ui_schema.component_attributes DROP CONSTRAINT IF EXISTS fkevomwpha5r897dh41g76k3tnn;
ALTER TABLE IF EXISTS ONLY ui_schema.component DROP CONSTRAINT IF EXISTS fkbvcb60qhl4mx348r3x82vcp71;
ALTER TABLE IF EXISTS ONLY ui_schema.component DROP CONSTRAINT IF EXISTS fk6m4oc31hgyt35vpyof218b547;
ALTER TABLE IF EXISTS ONLY testing_schema.test_session DROP CONSTRAINT IF EXISTS fkv1av0fyndo6j3vbce6itxm31;
ALTER TABLE IF EXISTS ONLY testing_schema.question_type DROP CONSTRAINT IF EXISTS fkqxecsv1enfdpkxaf1bqapf4so;
ALTER TABLE IF EXISTS ONLY testing_schema.test_session DROP CONSTRAINT IF EXISTS fkqgfs6dunmy1s4q65hxkgj1fmg;
ALTER TABLE IF EXISTS ONLY testing_schema.answer_submission DROP CONSTRAINT IF EXISTS fkpmsj79uodj5e1drncvrnpvmd7;
ALTER TABLE IF EXISTS ONLY testing_schema.test_session DROP CONSTRAINT IF EXISTS fkojxb34our7h79p4p5g9oy2w8v;
ALTER TABLE IF EXISTS ONLY testing_schema.question_type DROP CONSTRAINT IF EXISTS fko0hkdkvvyoll4tntb0g9587oe;
ALTER TABLE IF EXISTS ONLY testing_schema.test_session DROP CONSTRAINT IF EXISTS fkkl4i44nynqodqm7kwb7pe06dy;
ALTER TABLE IF EXISTS ONLY testing_schema.test_session DROP CONSTRAINT IF EXISTS fkkh1ht4vg34ydhaostpy3s521n;
ALTER TABLE IF EXISTS ONLY testing_schema.question DROP CONSTRAINT IF EXISTS fkjnivhuqvrqq9f1wlss478gcay;
ALTER TABLE IF EXISTS ONLY testing_schema.selected_answer DROP CONSTRAINT IF EXISTS fkgnuqu8ii6d63lp306s0s91yml;
ALTER TABLE IF EXISTS ONLY testing_schema.test DROP CONSTRAINT IF EXISTS fket9b55yu7wvongn1kcncwp9kp;
ALTER TABLE IF EXISTS ONLY testing_schema.answer_submission DROP CONSTRAINT IF EXISTS fkelbfxfjab82ywu83blabtjr8i;
ALTER TABLE IF EXISTS ONLY testing_schema.selected_answer DROP CONSTRAINT IF EXISTS fkekvxn39ai6od1i39vgtpko96j;
ALTER TABLE IF EXISTS ONLY testing_schema.test DROP CONSTRAINT IF EXISTS fkdy4veaakwulqxkm9ffbnivqa1;
ALTER TABLE IF EXISTS ONLY testing_schema.selectedAnswer DROP CONSTRAINT IF EXISTS fkdy3myy5le8pbhue6178c6swrn;
ALTER TABLE IF EXISTS ONLY testing_schema.test_session DROP CONSTRAINT IF EXISTS fkdrel5tjgjktri0qyo92bcb0s2;
ALTER TABLE IF EXISTS ONLY testing_schema.answer_submission DROP CONSTRAINT IF EXISTS fkd52kmu0cg4eeuxu1x3332m7bb;
ALTER TABLE IF EXISTS ONLY testing_schema.test DROP CONSTRAINT IF EXISTS fkcfsqecxjr6vitg231cl4guck8;
ALTER TABLE IF EXISTS ONLY testing_schema.selectedAnswer DROP CONSTRAINT IF EXISTS fkbbuf3p3qngi2qtqu5n9civqgf;
ALTER TABLE IF EXISTS ONLY testing_schema.question DROP CONSTRAINT IF EXISTS fk9ypfwi38va5u5u22d95lc6rw7;
ALTER TABLE IF EXISTS ONLY testing_schema.question DROP CONSTRAINT IF EXISTS fk8hejcpbbiq1qje11346akp3uj;
ALTER TABLE IF EXISTS ONLY testing_schema.selectedAnswer DROP CONSTRAINT IF EXISTS fk8frr4bcabmmeyyu60qt7iiblo;
ALTER TABLE IF EXISTS ONLY testing_schema.answer_submission DROP CONSTRAINT IF EXISTS fk873bn33h42yxrwbh95qeljv2o;
ALTER TABLE IF EXISTS ONLY testing_schema.question DROP CONSTRAINT IF EXISTS fk7svspov4rexjawqdvi2jni81u;
ALTER TABLE IF EXISTS ONLY testing_schema.test DROP CONSTRAINT IF EXISTS fk6n9a04fkvgp72bc01354sa8cn;
ALTER TABLE IF EXISTS ONLY testing_schema.question DROP CONSTRAINT IF EXISTS fk6e9te6j9nvngv9ndvrtt25kd;
ALTER TABLE IF EXISTS ONLY testing_schema.answer_submission DROP CONSTRAINT IF EXISTS fk5ryo4cllkcxwr664iv7r13dq0;
ALTER TABLE IF EXISTS ONLY testing_schema.answer_submission DROP CONSTRAINT IF EXISTS fk5drbo3r7nammrmj5xdynimfso;
ALTER TABLE IF EXISTS ONLY testing_schema.question DROP CONSTRAINT IF EXISTS fk5cike7u36rpj3o7melmsga9xo;
ALTER TABLE IF EXISTS ONLY testing_schema.test DROP CONSTRAINT IF EXISTS fk5bb7ma72lj1fhp7x0jbb0peim;
ALTER TABLE IF EXISTS ONLY testing_schema.answer_submission DROP CONSTRAINT IF EXISTS fk4rol0t47bkou4mrostdxldjel;
ALTER TABLE IF EXISTS ONLY testing_schema.test_session DROP CONSTRAINT IF EXISTS fk42kp884nu38qvylfkxa76evuj;
ALTER TABLE IF EXISTS ONLY testing_schema.selected_answer DROP CONSTRAINT IF EXISTS fk3mr8c6i6jnnds1y2i1dyv4jht;
ALTER TABLE IF EXISTS ONLY testing_schema.selected_answer DROP CONSTRAINT IF EXISTS fk2qc8o3pvb1q7b73j5x24yp8m0;
ALTER TABLE IF EXISTS ONLY testing_schema.selected_answer DROP CONSTRAINT IF EXISTS fk2cgt8o2m7fr4od0jfwu7p1qa0;
ALTER TABLE IF EXISTS ONLY testing_schema.selected_answer DROP CONSTRAINT IF EXISTS fk1b7y734nqi4srwm6uwwwml4dg;
ALTER TABLE IF EXISTS ONLY system_schema.service_provider DROP CONSTRAINT IF EXISTS fktru4vagqafrm2enw3ixkm49vx;
ALTER TABLE IF EXISTS ONLY system_schema.notification DROP CONSTRAINT IF EXISTS fkqe9350162wsyfwba7ypksptxy;
ALTER TABLE IF EXISTS ONLY system_schema.message DROP CONSTRAINT IF EXISTS fkq249ulieu4wad09sq6geyo5fi;
ALTER TABLE IF EXISTS ONLY system_schema.service_provider_type DROP CONSTRAINT IF EXISTS fkpy3awohqh1gu7gf2c6b9srqk6;
ALTER TABLE IF EXISTS ONLY system_schema.notification_type DROP CONSTRAINT IF EXISTS fkoq2jwj37yaf9sthv0qdc3vvvv;
ALTER TABLE IF EXISTS ONLY system_schema.environment_variable DROP CONSTRAINT IF EXISTS fkm99wh0rrl3qt72tdk4yk0elqm;
ALTER TABLE IF EXISTS ONLY system_schema.message_type DROP CONSTRAINT IF EXISTS fkl3h5bgih5onu4mkc0h163jep0;
ALTER TABLE IF EXISTS ONLY system_schema.service_provider DROP CONSTRAINT IF EXISTS fkjdp7sbilroobq0t9mo4gl932w;
ALTER TABLE IF EXISTS ONLY system_schema.service_provider DROP CONSTRAINT IF EXISTS fkhwogjfs1ng78am1yjqfgo5pmi;
ALTER TABLE IF EXISTS ONLY system_schema.environment_variable DROP CONSTRAINT IF EXISTS fkgchh78lg5j2k412j78435323h;
ALTER TABLE IF EXISTS ONLY system_schema.message DROP CONSTRAINT IF EXISTS fkfd439ioq6ug3lbeu6noxe2cl4;
ALTER TABLE IF EXISTS ONLY system_schema.message DROP CONSTRAINT IF EXISTS fkf2n7om2r7rytyj9cl1psd1fxu;
ALTER TABLE IF EXISTS ONLY system_schema.notification DROP CONSTRAINT IF EXISTS fkeemmsu5f01d28gdskoj0w2po0;
ALTER TABLE IF EXISTS ONLY system_schema.notification_type DROP CONSTRAINT IF EXISTS fkdlaywwgoe1cx6cwy48cmflw6c;
ALTER TABLE IF EXISTS ONLY system_schema.service_provider_type DROP CONSTRAINT IF EXISTS fkcytew89nxg4retf1dmyr6yci6;
ALTER TABLE IF EXISTS ONLY system_schema.message DROP CONSTRAINT IF EXISTS fkcxya4b4pfe7f6fcevjygj9usd;
ALTER TABLE IF EXISTS ONLY system_schema.service_provider DROP CONSTRAINT IF EXISTS fkbii4gvsfy4rbaqncor8eit6mf;
ALTER TABLE IF EXISTS ONLY system_schema.notification DROP CONSTRAINT IF EXISTS fk92legs77bpmt4090l2q1nrehl;
ALTER TABLE IF EXISTS ONLY system_schema.message_type DROP CONSTRAINT IF EXISTS fk6qtcciph5mb452eafe7xwhb2m;
ALTER TABLE IF EXISTS ONLY system_schema.notification DROP CONSTRAINT IF EXISTS fk5tak5s7d8v964omfb11iogqun;
ALTER TABLE IF EXISTS ONLY system_schema.notification DROP CONSTRAINT IF EXISTS fk3x921lcnkybqyh7pqeg9u2x7j;
ALTER TABLE IF EXISTS ONLY state_schema.entity_state DROP CONSTRAINT IF EXISTS fkontagti85jl7b02rkm5qek6do;
ALTER TABLE IF EXISTS ONLY state_schema.entity_state DROP CONSTRAINT IF EXISTS fkbb60rv5kt5cgr2dll7nepy61v;
ALTER TABLE IF EXISTS ONLY state_schema.entity_state DROP CONSTRAINT IF EXISTS fk5ajb4wry6c88nid6mxxj9424v;
ALTER TABLE IF EXISTS ONLY resource_schema.resource DROP CONSTRAINT IF EXISTS fkrl5vfjisd7ysacg4niry6m6w;
ALTER TABLE IF EXISTS ONLY resource_schema.resource DROP CONSTRAINT IF EXISTS fke59fj9nq6jexsy60tx6jbed4w;
ALTER TABLE IF EXISTS ONLY recruitment_schema.duty DROP CONSTRAINT IF EXISTS fkxl10d3c04vvfx62aw7xul31j;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_resource DROP CONSTRAINT IF EXISTS fksvbyfiraa0gvelhw5n7d0jblo;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview DROP CONSTRAINT IF EXISTS fksj1gb59aqdk26pj22mxql8c3l;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_resource_type DROP CONSTRAINT IF EXISTS fks4h14hx3lp6m6ig8nbtkianye;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_contact DROP CONSTRAINT IF EXISTS fkru03udupj8gl68n5igpkw7nkv;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_work_experience DROP CONSTRAINT IF EXISTS fkrnpw9gjtcg7fci9wgn00meifm;
ALTER TABLE IF EXISTS ONLY recruitment_schema.vacancy DROP CONSTRAINT IF EXISTS fkr9h5i5vkjj6mbdukayxcf1vr5;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_contact DROP CONSTRAINT IF EXISTS fkr1lhfj7k3u8a2ls2g1vnmbxq0;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_question DROP CONSTRAINT IF EXISTS fkqk81pfkix5om5h8kcift9ta07;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_question DROP CONSTRAINT IF EXISTS fkqdygprwrqqqu6r4ar1pdhil8x;
ALTER TABLE IF EXISTS ONLY recruitment_schema.experience DROP CONSTRAINT IF EXISTS fkq10t4hdjdqtan5am9l3bjpi2k;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_identification_document DROP CONSTRAINT IF EXISTS fkptff4vpcw1wdvjuhcwd68t7eh;
ALTER TABLE IF EXISTS ONLY recruitment_schema.vacancy DROP CONSTRAINT IF EXISTS fkpnjacakc5yi7nanlwm1qsce8w;
ALTER TABLE IF EXISTS ONLY recruitment_schema.skill DROP CONSTRAINT IF EXISTS fkpe98orxyaphvln2312o0uhqa5;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_citizenship DROP CONSTRAINT IF EXISTS fkovkfrsv3e4uc0f4yctmc99gyu;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interviewee DROP CONSTRAINT IF EXISTS fko9vt7v772vyke2j8k23v8bxke;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation DROP CONSTRAINT IF EXISTS fko48fe8da59op2pe6sxb13ip8o;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_military_service DROP CONSTRAINT IF EXISTS fko3cv6dlmp5pb6khlnmno0ed3b;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview DROP CONSTRAINT IF EXISTS fknvejb31tcs8k0yhvv4eskd04k;
ALTER TABLE IF EXISTS ONLY recruitment_schema.skill DROP CONSTRAINT IF EXISTS fkn2ryquo3yn7r6uifypqia221h;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_section DROP CONSTRAINT IF EXISTS fkmx31gcxx0ahoj5k1pt0e6okrw;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_address DROP CONSTRAINT IF EXISTS fkmk95ujrhbelgtvn22uk96e3hs;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_resource_type DROP CONSTRAINT IF EXISTS fklnxmra0uu5gcbxjboiytx8syj;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interviewer DROP CONSTRAINT IF EXISTS fklbc4n6qvobstvypfyig7kjlpu;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_resource DROP CONSTRAINT IF EXISTS fkl5kt6pdi79jwvxjtc62kb89ri;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate DROP CONSTRAINT IF EXISTS fkl3y9fhd8h6cy4c0y120c0j3hx;
ALTER TABLE IF EXISTS ONLY recruitment_schema.duty DROP CONSTRAINT IF EXISTS fkkqjjvhwqugp4l6xb4ohw0pyiv;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_question DROP CONSTRAINT IF EXISTS fkkgun5deh39jfehfdnamfo4vdd;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interviewee DROP CONSTRAINT IF EXISTS fkjxqkw7b2kpvoyw3mc59tqekrx;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_type DROP CONSTRAINT IF EXISTS fkjmamlwrg2tv8fi74ctn302xxs;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_resource DROP CONSTRAINT IF EXISTS fkjjtw4fegri7aac6s4ps8gc3j2;
ALTER TABLE IF EXISTS ONLY recruitment_schema.experience DROP CONSTRAINT IF EXISTS fkihcqf9h7ixwuv3qytcojqjban;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_education DROP CONSTRAINT IF EXISTS fkhw87pfd8o09yvwivyfe3r5vep;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interviewee DROP CONSTRAINT IF EXISTS fkgxgohftaafug2u9prpyaxmysw;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_citizenship DROP CONSTRAINT IF EXISTS fkgskf1mqa9868hnmg8vthw2ca0;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interviewer DROP CONSTRAINT IF EXISTS fkgquicn1pci524ikjdebudn58j;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interviewee DROP CONSTRAINT IF EXISTS fkgpj3flxur881wrgbv15faa7ey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.vacancy DROP CONSTRAINT IF EXISTS fkgfrfgpwn1pk36j3i1ik67lu8y;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_identification_document DROP CONSTRAINT IF EXISTS fkfr2xnc1hu773vy305aub7csxo;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation DROP CONSTRAINT IF EXISTS fkfbg77obj7u5o9cuc62nk0lqpb;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation DROP CONSTRAINT IF EXISTS fkfb4luj2r908uqxwarwk61p0x;
ALTER TABLE IF EXISTS ONLY recruitment_schema.vacancy DROP CONSTRAINT IF EXISTS fkf48sb61yr0bwkea2q5brcum23;
ALTER TABLE IF EXISTS ONLY recruitment_schema.skill DROP CONSTRAINT IF EXISTS fketvgi9xi8ywtau4ajqsafwjli;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interviewer DROP CONSTRAINT IF EXISTS fkej785e8f0yivx50xu8bgwpwgq;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interviewee DROP CONSTRAINT IF EXISTS fke3xkt5saq6gksju122e0tch7h;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_section DROP CONSTRAINT IF EXISTS fkdyw8aducvgms4wgcjpbd3n5hy;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_question DROP CONSTRAINT IF EXISTS fkcte1ucfbb9hpujgv6bs5m7bsv;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_section DROP CONSTRAINT IF EXISTS fkc6a0b2534gcr8j2j5wm2hoj16;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_address DROP CONSTRAINT IF EXISTS fkbnmt1ufxb0y726ump4ttfgsd6;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interviewer DROP CONSTRAINT IF EXISTS fkbla397qtjxlgbhpueta67osk0;
ALTER TABLE IF EXISTS ONLY recruitment_schema.duty DROP CONSTRAINT IF EXISTS fkbe7e8bq7oun80ojpgcgbm1863;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate DROP CONSTRAINT IF EXISTS fkb6fx7vwnkdjg8mb8cnr31f3y9;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate DROP CONSTRAINT IF EXISTS fka7tpd1o83s61ky0g0c8d3q5m7;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_section DROP CONSTRAINT IF EXISTS fk9ntil18gdwn0ootgkm064912x;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview DROP CONSTRAINT IF EXISTS fk9l043jrxwm2cw2nxbqxk1vulf;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interviewer DROP CONSTRAINT IF EXISTS fk9d43vav95k8labptb5f5e5e2c;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate DROP CONSTRAINT IF EXISTS fk9858c1xjs56ll9b4lsmivcm9c;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_work_experience DROP CONSTRAINT IF EXISTS fk93ais2r6nllbu2pk2idjyjrbh;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate DROP CONSTRAINT IF EXISTS fk8qq2abjbqj1dm9xp2cwsssj9n;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation DROP CONSTRAINT IF EXISTS fk83ut75dsjvq7yurmn0d59ew8p;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview DROP CONSTRAINT IF EXISTS fk7r8wldm1uh3yxtj6pinmv1cds;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_type DROP CONSTRAINT IF EXISTS fk7mfybmk038d20fmgj4cole72c;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate DROP CONSTRAINT IF EXISTS fk6n8vqigjcpdk7ewjbsk4u8jeg;
ALTER TABLE IF EXISTS ONLY recruitment_schema.experience DROP CONSTRAINT IF EXISTS fk6e77r5xga0xb11rh9s6mbrdmo;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate DROP CONSTRAINT IF EXISTS fk5y77gy4a4roeglaeh6t3nxw1n;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interviewer DROP CONSTRAINT IF EXISTS fk5vnf59nnkrosyk1g9kbopoqg9;
ALTER TABLE IF EXISTS ONLY recruitment_schema.vacancy DROP CONSTRAINT IF EXISTS fk57dh2fsk2okd4j3hvv7w4skgd;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_question DROP CONSTRAINT IF EXISTS fk4yddusgnifpaxim7xgk76q743;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate DROP CONSTRAINT IF EXISTS fk4sn940s55wnxxa7k1bmjjy00w;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_answer DROP CONSTRAINT IF EXISTS fk4lqfgorrql9ypd4h3jjtupni7;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation DROP CONSTRAINT IF EXISTS fk3kqkw8norrctqyst0wannpln2;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_answer DROP CONSTRAINT IF EXISTS fk3aw8vbgqu7n5fii8gk35kc7r9;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_military_service DROP CONSTRAINT IF EXISTS fk32md2gwm76pk7opcybuxyxtme;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_answer DROP CONSTRAINT IF EXISTS fk2ccsnew7gpthcix49g8brv5ab;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_education DROP CONSTRAINT IF EXISTS fk1eu32qpinp2dh1pjtno7ku8mn;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_answer DROP CONSTRAINT IF EXISTS fk19xy9g3bi078w0a57vwcwihq5;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_section DROP CONSTRAINT IF EXISTS fk138icxaoj7yi6l2ripuemsb7o;
ALTER TABLE IF EXISTS ONLY organization_schema.organization DROP CONSTRAINT IF EXISTS fkt4gf01gb3wep67ywcpfemqro3;
ALTER TABLE IF EXISTS ONLY organization_schema.organization DROP CONSTRAINT IF EXISTS fkstgsvhc6dn2t32td4knbssjky;
ALTER TABLE IF EXISTS ONLY organization_schema.reporting_line DROP CONSTRAINT IF EXISTS fksj9u0slv7itvaqaslj6rq28j4;
ALTER TABLE IF EXISTS ONLY organization_schema.separationReason DROP CONSTRAINT IF EXISTS fksj0beotu978kowumc6hklbl4c;
ALTER TABLE IF EXISTS ONLY organization_schema.organization_unit DROP CONSTRAINT IF EXISTS fks84y3cn9levaa67l9lkm6r05e;
ALTER TABLE IF EXISTS ONLY organization_schema.authority DROP CONSTRAINT IF EXISTS fkrxxda3cfyp3e4glgb5wx6r7je;
ALTER TABLE IF EXISTS ONLY organization_schema.organization_contact DROP CONSTRAINT IF EXISTS fkrxldtwyw0ewgd16nh1dbpk9on;
ALTER TABLE IF EXISTS ONLY organization_schema.reporting_line_type DROP CONSTRAINT IF EXISTS fkrpfhg91rakqg4p48mse920f7w;
ALTER TABLE IF EXISTS ONLY organization_schema.grade_step DROP CONSTRAINT IF EXISTS fkrd14k2gwjpwffpnpuy1puqdbv;
ALTER TABLE IF EXISTS ONLY organization_schema.separationReason DROP CONSTRAINT IF EXISTS fkovdg8bvkum4mh0ikrdr7q6rlm;
ALTER TABLE IF EXISTS ONLY organization_schema.key_performance_indicator DROP CONSTRAINT IF EXISTS fkodjy4q0ojg5u9tirx6hcjswss;
ALTER TABLE IF EXISTS ONLY organization_schema.grade_step DROP CONSTRAINT IF EXISTS fko0gt0b9re6s104ys5k8o1neno;
ALTER TABLE IF EXISTS ONLY organization_schema.reporting_line DROP CONSTRAINT IF EXISTS fknug7san1s41lpsmtbp9j4v2nl;
ALTER TABLE IF EXISTS ONLY organization_schema.separationReason DROP CONSTRAINT IF EXISTS fkmgsnnmudxrwqidn4f64q8rp4o;
ALTER TABLE IF EXISTS ONLY organization_schema.work_schedule DROP CONSTRAINT IF EXISTS fkm74jkkch72jh8o9x9owhjdh6v;
ALTER TABLE IF EXISTS ONLY organization_schema."position" DROP CONSTRAINT IF EXISTS fkm3sbyitwagg27v6n7kobokau5;
ALTER TABLE IF EXISTS ONLY organization_schema.work_schedule DROP CONSTRAINT IF EXISTS fklc197h6r7la0hehtvxj3nsfeb;
ALTER TABLE IF EXISTS ONLY organization_schema.responsibility DROP CONSTRAINT IF EXISTS fkl5yqbxpqrssttjy8khn1s0va0;
ALTER TABLE IF EXISTS ONLY organization_schema.job_description DROP CONSTRAINT IF EXISTS fkl5c84b66s1vutn7j1avntv8hn;
ALTER TABLE IF EXISTS ONLY organization_schema.organization DROP CONSTRAINT IF EXISTS fkl215pwk5km2p99pi6m2yk55qj;
ALTER TABLE IF EXISTS ONLY organization_schema.reporting_line_type DROP CONSTRAINT IF EXISTS fkk3vjtyxlyht52idypy7lnrx0x;
ALTER TABLE IF EXISTS ONLY organization_schema.required_experience DROP CONSTRAINT IF EXISTS fkjttwo7qqsqwcu8tqbhlk7wbbh;
ALTER TABLE IF EXISTS ONLY organization_schema.grade DROP CONSTRAINT IF EXISTS fkjsr2foca5vwxc0tcd6xm5hoy0;
ALTER TABLE IF EXISTS ONLY organization_schema.grade DROP CONSTRAINT IF EXISTS fkjcfgalg5dl5bomjjplgsogcym;
ALTER TABLE IF EXISTS ONLY organization_schema.grade DROP CONSTRAINT IF EXISTS fkj48n3kbwid0sjrngmyv7ukhm;
ALTER TABLE IF EXISTS ONLY organization_schema.job_description DROP CONSTRAINT IF EXISTS fkj1b1tcb2n50g5vu4imq10ro3s;
ALTER TABLE IF EXISTS ONLY organization_schema.organization_contact DROP CONSTRAINT IF EXISTS fkisl50plaa1n7i1nkkpbulmfmc;
ALTER TABLE IF EXISTS ONLY organization_schema.required_experience DROP CONSTRAINT IF EXISTS fkibbrxe6wnmbnyvy5yodlvt9wk;
ALTER TABLE IF EXISTS ONLY organization_schema.grade DROP CONSTRAINT IF EXISTS fkhkm4gynm673v44jgryiy9odh2;
ALTER TABLE IF EXISTS ONLY organization_schema.authority DROP CONSTRAINT IF EXISTS fkgm1gbyt6evane5dgvf4200jbs;
ALTER TABLE IF EXISTS ONLY organization_schema.responsibility DROP CONSTRAINT IF EXISTS fkg3vsmwqbvklt9127snmnvselc;
ALTER TABLE IF EXISTS ONLY organization_schema.separationReason DROP CONSTRAINT IF EXISTS fkfqtv5nnif1gd3tjiey0mvcsqv;
ALTER TABLE IF EXISTS ONLY organization_schema.grade_step DROP CONSTRAINT IF EXISTS fkfik8o7842uqxnu3y6w60m4av7;
ALTER TABLE IF EXISTS ONLY organization_schema.authority DROP CONSTRAINT IF EXISTS fkesexn44wmq0k58w2v6ayfbwlu;
ALTER TABLE IF EXISTS ONLY organization_schema.key_performance_indicator DROP CONSTRAINT IF EXISTS fkeibmd61goas4hpm9oul965tnb;
ALTER TABLE IF EXISTS ONLY organization_schema.organization_address DROP CONSTRAINT IF EXISTS fkefggcvbaya8057e0tk0dq8edr;
ALTER TABLE IF EXISTS ONLY organization_schema.reporting_line DROP CONSTRAINT IF EXISTS fke8qg8x5p67jgx5f6llx9yadie;
ALTER TABLE IF EXISTS ONLY organization_schema.grade_level DROP CONSTRAINT IF EXISTS fkdwpgrcf9yf68h68gom8a7u5u7;
ALTER TABLE IF EXISTS ONLY organization_schema."position" DROP CONSTRAINT IF EXISTS fkdw61fctruyml0gypg10jucjw9;
ALTER TABLE IF EXISTS ONLY organization_schema.grade DROP CONSTRAINT IF EXISTS fkdprna7hy65wr3ngm14ryynsvu;
ALTER TABLE IF EXISTS ONLY organization_schema.reporting_line DROP CONSTRAINT IF EXISTS fkdo6papx163yyjx746qbnbqlgq;
ALTER TABLE IF EXISTS ONLY organization_schema.reporting_line DROP CONSTRAINT IF EXISTS fkdmmo7w28s05d6605vpnmtx9bd;
ALTER TABLE IF EXISTS ONLY organization_schema.organization DROP CONSTRAINT IF EXISTS fkc30yedjwp9qw1f3nn2ytda7tj;
ALTER TABLE IF EXISTS ONLY organization_schema.organization_unit DROP CONSTRAINT IF EXISTS fkc0yjou4eipgitkl7qt8i4bw9u;
ALTER TABLE IF EXISTS ONLY organization_schema.qualification DROP CONSTRAINT IF EXISTS fkbxdu76uexo9vl2px2pik43ggj;
ALTER TABLE IF EXISTS ONLY organization_schema.reporting_line DROP CONSTRAINT IF EXISTS fkbqg9gyw4jrfwdqwajnxe3584o;
ALTER TABLE IF EXISTS ONLY organization_schema.job_description DROP CONSTRAINT IF EXISTS fka29xefaot60o1i9me3jdnrbt0;
ALTER TABLE IF EXISTS ONLY organization_schema.key_performance_indicator DROP CONSTRAINT IF EXISTS fka0jwlwqybkodsqgvxokeublyw;
ALTER TABLE IF EXISTS ONLY organization_schema.qualification DROP CONSTRAINT IF EXISTS fk9xgajp2u2mgu3x6f02wurskev;
ALTER TABLE IF EXISTS ONLY organization_schema.required_experience DROP CONSTRAINT IF EXISTS fk9fmh2wvfv466gjmxxtk2yxlgb;
ALTER TABLE IF EXISTS ONLY organization_schema."position" DROP CONSTRAINT IF EXISTS fk9ffk1rsmxqm40un5pmmyxu501;
ALTER TABLE IF EXISTS ONLY organization_schema.qualification DROP CONSTRAINT IF EXISTS fk98lf0r7eue8pd0vajnjeyvliw;
ALTER TABLE IF EXISTS ONLY organization_schema.grade DROP CONSTRAINT IF EXISTS fk7xrcuu7nqcnfch3k0xjx5tpav;
ALTER TABLE IF EXISTS ONLY organization_schema.accountability DROP CONSTRAINT IF EXISTS fk7xqcppjg3kworxvy4srmp01o3;
ALTER TABLE IF EXISTS ONLY organization_schema.responsibility DROP CONSTRAINT IF EXISTS fk7plhr1v02ns1cbc0avfrxa5q0;
ALTER TABLE IF EXISTS ONLY organization_schema.job_description DROP CONSTRAINT IF EXISTS fk6aggivxmolyw8miurbqfkp2n4;
ALTER TABLE IF EXISTS ONLY organization_schema.separationReason DROP CONSTRAINT IF EXISTS fk5ptf7l6on51fsf8aa2jx9rnlf;
ALTER TABLE IF EXISTS ONLY organization_schema."position" DROP CONSTRAINT IF EXISTS fk4m4tca2i2jjfx6vydbs3l0ul2;
ALTER TABLE IF EXISTS ONLY organization_schema.organization_address DROP CONSTRAINT IF EXISTS fk4bxk7tixquspybhj8mdi6vyhi;
ALTER TABLE IF EXISTS ONLY organization_schema.accountability DROP CONSTRAINT IF EXISTS fk3yhcetalvpxeyscd4i2gbisce;
ALTER TABLE IF EXISTS ONLY organization_schema.grade_level DROP CONSTRAINT IF EXISTS fk3bfio4yrisp4c4you6pbb1inv;
ALTER TABLE IF EXISTS ONLY organization_schema.grade_step DROP CONSTRAINT IF EXISTS fk3b1u7gcomwpjhdt6pcjpys3e7;
ALTER TABLE IF EXISTS ONLY organization_schema."position" DROP CONSTRAINT IF EXISTS fk2i1atjdpclcep7x7evw1akqwd;
ALTER TABLE IF EXISTS ONLY organization_schema.accountability DROP CONSTRAINT IF EXISTS fk1guihvi3fb7rxseuu84bck8vw;
ALTER TABLE IF EXISTS ONLY navigation_schema.form_component_attributes DROP CONSTRAINT IF EXISTS fks199ajsh4vi0r9ah9yhg7dbyr;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action_transition DROP CONSTRAINT IF EXISTS fkqpbr8enfrpaddt4q8tjjt06ak;
ALTER TABLE IF EXISTS ONLY navigation_schema.action_category DROP CONSTRAINT IF EXISTS fkqhfvfrt6s4lgr0dk2434al1ai;
ALTER TABLE IF EXISTS ONLY navigation_schema.form_component_attributes DROP CONSTRAINT IF EXISTS fkqhcsbra6phi8fateu7p3anin8;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_transition DROP CONSTRAINT IF EXISTS fkq0mhg153agoc4htt8uo5hmo3a;
ALTER TABLE IF EXISTS ONLY navigation_schema.action DROP CONSTRAINT IF EXISTS fkpyh2pe21oxej3ae0d9is85mpq;
ALTER TABLE IF EXISTS ONLY navigation_schema.navigation_unit DROP CONSTRAINT IF EXISTS fkpaxxibli3jom1o7p7wl4slcb3;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action_transition DROP CONSTRAINT IF EXISTS fkp5yicewv25gchxamqa9jr599a;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_transition DROP CONSTRAINT IF EXISTS fkojprs0jl3ieh3sxy5iugphir7;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action DROP CONSTRAINT IF EXISTS fkoga0v1knnlukn9a3abrivo0pv;
ALTER TABLE IF EXISTS ONLY navigation_schema.form_components DROP CONSTRAINT IF EXISTS fkocuvuqnac8dpqwlhawkgcw0uo;
ALTER TABLE IF EXISTS ONLY navigation_schema.form_components DROP CONSTRAINT IF EXISTS fko4wtvqjxhrt8aqtvryxks0vi6;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action_transition DROP CONSTRAINT IF EXISTS fknwg68jbi51n6r24ue8tiuq8ft;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action DROP CONSTRAINT IF EXISTS fknpsy07obtx150rs7rjejfm9y3;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_configuration DROP CONSTRAINT IF EXISTS fknijxka53lvc8x5oberk93nb30;
ALTER TABLE IF EXISTS ONLY navigation_schema.public_url DROP CONSTRAINT IF EXISTS fkmqcyrqxkqac7esmv7ewuj7w68;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_configuration DROP CONSTRAINT IF EXISTS fkmlg5tdf0yrjofctkmmn94ae81;
ALTER TABLE IF EXISTS ONLY navigation_schema.form_component_attributes DROP CONSTRAINT IF EXISTS fkmb2f61fuoj2rsc5bjvm77xh4o;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action DROP CONSTRAINT IF EXISTS fklks23fy4rnbk829v92e9tnl77;
ALTER TABLE IF EXISTS ONLY navigation_schema.action_type DROP CONSTRAINT IF EXISTS fkkgxo5a7fky15908pibdmouacw;
ALTER TABLE IF EXISTS ONLY navigation_schema.action_type DROP CONSTRAINT IF EXISTS fkk7dtr5waa6nud4shlq82id5e3;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_transition DROP CONSTRAINT IF EXISTS fkjhlhtau9y9s1i1s3frp7s79c;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_configuration DROP CONSTRAINT IF EXISTS fkifvwi920ejmjq15f696trx3rl;
ALTER TABLE IF EXISTS ONLY navigation_schema.form_component_attributes DROP CONSTRAINT IF EXISTS fki8wy0so3l282v9o27ewtt2v8;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action_form_component DROP CONSTRAINT IF EXISTS fkhpu8p92j7y7k7pktoijqcjiwy;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action_transition DROP CONSTRAINT IF EXISTS fkgnq5ucjp1oohaft7v9dskcauk;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu DROP CONSTRAINT IF EXISTS fkgeupubdqncc1lpgf2cn4fqwbc;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu DROP CONSTRAINT IF EXISTS fkekqy9sl4ik55cttsdj8qmg1y;
ALTER TABLE IF EXISTS ONLY navigation_schema.form_components DROP CONSTRAINT IF EXISTS fkdy5j2bidu30xddm6dp7o9wiwb;
ALTER TABLE IF EXISTS ONLY navigation_schema.action DROP CONSTRAINT IF EXISTS fkdvqlh9a1cst8hl7il6l2mkwjn;
ALTER TABLE IF EXISTS ONLY navigation_schema.public_url DROP CONSTRAINT IF EXISTS fkd1ihp2m6p74mn9e1qruo6648h;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu DROP CONSTRAINT IF EXISTS fkcnkpup7yejhub2kygm33p5b4h;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action_form_component DROP CONSTRAINT IF EXISTS fkc0srox7qykeg2k8br4qebixqh;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_configuration DROP CONSTRAINT IF EXISTS fkbiaekwf06al9qfamy8lwjtxg5;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action_form_component DROP CONSTRAINT IF EXISTS fkaiwvftsuv6mlssloswpgd9mdt;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action_form_component DROP CONSTRAINT IF EXISTS fka4021gyr6r3cj2v3ei6vavifd;
ALTER TABLE IF EXISTS ONLY navigation_schema.form_components DROP CONSTRAINT IF EXISTS fk992xbdp3e46h98jal5etaflc0;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action DROP CONSTRAINT IF EXISTS fk8otwg0y5xd1lphemm0keoks1;
ALTER TABLE IF EXISTS ONLY navigation_schema.configuration DROP CONSTRAINT IF EXISTS fk7ql49360vf19vhj13rh3hrk29;
ALTER TABLE IF EXISTS ONLY navigation_schema.navigation_unit DROP CONSTRAINT IF EXISTS fk7o8osgapkyuvcba896p6neu0i;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu DROP CONSTRAINT IF EXISTS fk7g5yjx6gptkwon18oo9rmrnl;
ALTER TABLE IF EXISTS ONLY navigation_schema.form_component_attributes DROP CONSTRAINT IF EXISTS fk7evhr508p9w32o48rhjffooes;
ALTER TABLE IF EXISTS ONLY navigation_schema.action DROP CONSTRAINT IF EXISTS fk7dauqaa033jldyrnyur8q87qw;
ALTER TABLE IF EXISTS ONLY navigation_schema.action_category DROP CONSTRAINT IF EXISTS fk71261v5k1uhkd2oow9ggsumfr;
ALTER TABLE IF EXISTS ONLY navigation_schema.form_components DROP CONSTRAINT IF EXISTS fk6aa91rjx7v1dnyu2vwqkjlqeq;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action_transition DROP CONSTRAINT IF EXISTS fk665kwdvf98bqgsl551pedmla2;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action DROP CONSTRAINT IF EXISTS fk5uvjvyklimqf3vsy4b7i8bpxy;
ALTER TABLE IF EXISTS ONLY navigation_schema.action DROP CONSTRAINT IF EXISTS fk5gb6d57cwh9sxqneo6i17xkj0;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_transition DROP CONSTRAINT IF EXISTS fk46ka2sm0om1v7i3o6yg4mamyb;
ALTER TABLE IF EXISTS ONLY navigation_schema.configuration DROP CONSTRAINT IF EXISTS fk3r24iehk8bjdnii35meps87l6;
ALTER TABLE IF EXISTS ONLY navigation_schema.public_url DROP CONSTRAINT IF EXISTS fk2rhceer2swq0918tdv8d8m8ot;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action_form_component DROP CONSTRAINT IF EXISTS fk2mmb3d3s5x1t6btnqio5em7qv;
ALTER TABLE IF EXISTS ONLY navigation_schema.action DROP CONSTRAINT IF EXISTS fk212uaoflbe9m6xh606d7anwv7;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_configuration DROP CONSTRAINT IF EXISTS fk1ofckfyl28omx70msjr8ft00n;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_transition DROP CONSTRAINT IF EXISTS fk1djnn92vc7tcspn9jgfxrpb2x;
ALTER TABLE IF EXISTS ONLY military_schema.military_service_resource DROP CONSTRAINT IF EXISTS fksbyprtgcd53vm548gbya4abm4;
ALTER TABLE IF EXISTS ONLY military_schema.military_service DROP CONSTRAINT IF EXISTS fkmlbujp7itssen83clu6nbfl4l;
ALTER TABLE IF EXISTS ONLY military_schema.military_service_resource DROP CONSTRAINT IF EXISTS fkcjiubvp9d0qqqsk6fbw5x58db;
ALTER TABLE IF EXISTS ONLY military_schema.military_service DROP CONSTRAINT IF EXISTS fk8af24bjreoi8k673a1kgxn0qd;
ALTER TABLE IF EXISTS ONLY location_schema.district DROP CONSTRAINT IF EXISTS fktpfvl4al4538wfe5ric9j3xum;
ALTER TABLE IF EXISTS ONLY location_schema.city DROP CONSTRAINT IF EXISTS fksi0dkm9kk6dyuedmc0j18t770;
ALTER TABLE IF EXISTS ONLY location_schema.district DROP CONSTRAINT IF EXISTS fksgx09prp6sk2f0we38bf2dtal;
ALTER TABLE IF EXISTS ONLY location_schema.address DROP CONSTRAINT IF EXISTS fkqbjwfi50pdenou8j14knnffrh;
ALTER TABLE IF EXISTS ONLY location_schema.address DROP CONSTRAINT IF EXISTS fkpo044ng5x4gynb291cv24vtea;
ALTER TABLE IF EXISTS ONLY location_schema.district DROP CONSTRAINT IF EXISTS fkpjyu66maoe0h5uqfhle85e5vo;
ALTER TABLE IF EXISTS ONLY location_schema.area_type DROP CONSTRAINT IF EXISTS fknkt26vcn1vps4cb95ygnmrkf2;
ALTER TABLE IF EXISTS ONLY location_schema.address DROP CONSTRAINT IF EXISTS fkm5kwvo986qy095784tqwutb45;
ALTER TABLE IF EXISTS ONLY location_schema.address DROP CONSTRAINT IF EXISTS fkkkjn52mg1vha4yjpm0douso7f;
ALTER TABLE IF EXISTS ONLY location_schema.district DROP CONSTRAINT IF EXISTS fkjtoeoh4xkl9qfrge7oi6y0hah;
ALTER TABLE IF EXISTS ONLY location_schema.region DROP CONSTRAINT IF EXISTS fkjlnmywhrkx37ldlpyrxobx2uq;
ALTER TABLE IF EXISTS ONLY location_schema.region DROP CONSTRAINT IF EXISTS fkj455xq4kwamwva7p9ov5erly7;
ALTER TABLE IF EXISTS ONLY location_schema.address_type DROP CONSTRAINT IF EXISTS fkhr5q6sm2c4dqvsakyy5et6dit;
ALTER TABLE IF EXISTS ONLY location_schema.address_type DROP CONSTRAINT IF EXISTS fkgorq7n67dsr2hk2i84ci4j2rp;
ALTER TABLE IF EXISTS ONLY location_schema.city DROP CONSTRAINT IF EXISTS fkgogf8vj1ups4k75fvtcpi6r3g;
ALTER TABLE IF EXISTS ONLY location_schema.country DROP CONSTRAINT IF EXISTS fkgbqdd9y404natt5pjhpor00q1;
ALTER TABLE IF EXISTS ONLY location_schema.address DROP CONSTRAINT IF EXISTS fke54x81nmccsk5569hsjg1a6ka;
ALTER TABLE IF EXISTS ONLY location_schema.address DROP CONSTRAINT IF EXISTS fk9pnfumec02sjj7d06781ng2na;
ALTER TABLE IF EXISTS ONLY location_schema.region DROP CONSTRAINT IF EXISTS fk7vb2cqcnkr9391hfn72louxkq;
ALTER TABLE IF EXISTS ONLY location_schema.address DROP CONSTRAINT IF EXISTS fk4ljdc68rnke4txup1jlf1il4l;
ALTER TABLE IF EXISTS ONLY location_schema.city DROP CONSTRAINT IF EXISTS fk47nc6w4ttxijd5684upkcanuh;
ALTER TABLE IF EXISTS ONLY location_schema.city DROP CONSTRAINT IF EXISTS fk2el58jr2ryiy4qico8h4fg7kl;
ALTER TABLE IF EXISTS ONLY location_schema.country DROP CONSTRAINT IF EXISTS fk29qebdxc7vct81f8l37f8rjux;
ALTER TABLE IF EXISTS ONLY location_schema.area_type DROP CONSTRAINT IF EXISTS fk1sre3vgjo29aqle423uxijp6c;
ALTER TABLE IF EXISTS ONLY location_schema.district DROP CONSTRAINT IF EXISTS fk1q08nqsgy69cs1rq6xgyg7w96;
ALTER TABLE IF EXISTS ONLY localization_schema.layout_label_detail DROP CONSTRAINT IF EXISTS fkjqq3apele5st97kahqigmdjil;
ALTER TABLE IF EXISTS ONLY localization_schema.layout_label_detail DROP CONSTRAINT IF EXISTS fkiimy8s3mrn62tm28vm5u9i8p6;
ALTER TABLE IF EXISTS ONLY localization_schema.layout_label DROP CONSTRAINT IF EXISTS fki6uo8wlcsjat59sntmo0bt3g9;
ALTER TABLE IF EXISTS ONLY localization_schema.layout_label_detail DROP CONSTRAINT IF EXISTS fkfjdvrebibvynp7q8avus7h3tf;
ALTER TABLE IF EXISTS ONLY localization_schema.layout_label DROP CONSTRAINT IF EXISTS fkb57jkw4jj0hf5es4bjow60rv1;
ALTER TABLE IF EXISTS ONLY localization_schema.language DROP CONSTRAINT IF EXISTS fk9609nf8jd35ssnh62g8w8j8ju;
ALTER TABLE IF EXISTS ONLY localization_schema.language DROP CONSTRAINT IF EXISTS fk4nuxj3b1xosqqnlfvmymnk93x;
ALTER TABLE IF EXISTS ONLY localization_schema.layout_label_detail DROP CONSTRAINT IF EXISTS fk371l7576vbee2p7flxhebf3d9;
ALTER TABLE IF EXISTS ONLY identification_schema.identification_document DROP CONSTRAINT IF EXISTS fkk33mn08bfsluu4b4udlwty3oe;
ALTER TABLE IF EXISTS ONLY identification_schema.identification_document_type DROP CONSTRAINT IF EXISTS fkjqgrau3xkgox0gvgax2dec0aw;
ALTER TABLE IF EXISTS ONLY identification_schema.identification_document DROP CONSTRAINT IF EXISTS fkicxgrtk7s9lhqqs7mbld5w9ie;
ALTER TABLE IF EXISTS ONLY identification_schema.identification_document DROP CONSTRAINT IF EXISTS fka09iqrithni1n9ngx9vwfhr81;
ALTER TABLE IF EXISTS ONLY identification_schema.identification_document DROP CONSTRAINT IF EXISTS fk9fhx2j37s5l15ccoj7mjl9afd;
ALTER TABLE IF EXISTS ONLY identification_schema.identification_document_type DROP CONSTRAINT IF EXISTS fk3wrrux5ijujd14bkefa1j8xhc;
ALTER TABLE IF EXISTS ONLY employment_schema.work_experience DROP CONSTRAINT IF EXISTS fkp6y99wr1rq35iatijh83te7y7;
ALTER TABLE IF EXISTS ONLY employment_schema.work_experience DROP CONSTRAINT IF EXISTS fkmoyuehlll0xvl2ea4hnd9wfm;
ALTER TABLE IF EXISTS ONLY employment_schema.work_experience DROP CONSTRAINT IF EXISTS fkjp8qgildg69x3vyoy2jtg1xlj;
ALTER TABLE IF EXISTS ONLY employment_schema.work_experience DROP CONSTRAINT IF EXISTS fkguruas5qmx56ws1u6np10pao1;
ALTER TABLE IF EXISTS ONLY employment_schema.work_experience DROP CONSTRAINT IF EXISTS fkdgrimu1wdrq6mwvq1pcis0tk4;
ALTER TABLE IF EXISTS ONLY employment_schema.employment_type DROP CONSTRAINT IF EXISTS fkch68osg8ok4gelsutxaa9hdbk;
ALTER TABLE IF EXISTS ONLY employment_schema.employment_type DROP CONSTRAINT IF EXISTS fk90po97a46ctgfsogwdwicsykx;
ALTER TABLE IF EXISTS ONLY employee_schema.absence DROP CONSTRAINT IF EXISTS fktqui27l7rrtdt6d01rg3hxd1p;
ALTER TABLE IF EXISTS ONLY employee_schema.relative_address DROP CONSTRAINT IF EXISTS fktcgpo1j7lqjinbvnfc78rn8g;
ALTER TABLE IF EXISTS ONLY employee_schema.improvement_area DROP CONSTRAINT IF EXISTS fkt5x9oc6sf6c2e1yywfc1odv68;
ALTER TABLE IF EXISTS ONLY employee_schema.relative DROP CONSTRAINT IF EXISTS fksfqj4j7u03tdufpj8runaihfc;
ALTER TABLE IF EXISTS ONLY employee_schema.improvement_area DROP CONSTRAINT IF EXISTS fksaug9hol96j1l6su4efmch5j7;
ALTER TABLE IF EXISTS ONLY employee_schema.absence DROP CONSTRAINT IF EXISTS fks69fc883x11wl5lkx9vjhf5ym;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation DROP CONSTRAINT IF EXISTS fkrnc387fqpngthsvkbdqijdhtw;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip DROP CONSTRAINT IF EXISTS fkrkc8arf37fve513pswgx90fbs;
ALTER TABLE IF EXISTS ONLY employee_schema.relative_contact DROP CONSTRAINT IF EXISTS fkraf65bt5n4pfvl8m0tl93yybp;
ALTER TABLE IF EXISTS ONLY employee_schema.attendance DROP CONSTRAINT IF EXISTS fkr7q0h8jfngkyybll6o9r3h9ua;
ALTER TABLE IF EXISTS ONLY employee_schema."order" DROP CONSTRAINT IF EXISTS fkr5f1ndp5f1p4uhf3auwtg8661;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_address DROP CONSTRAINT IF EXISTS fkr4kbfcxh6balyjk6rldqg6nxc;
ALTER TABLE IF EXISTS ONLY employee_schema.performance_goal DROP CONSTRAINT IF EXISTS fkr221pp58hhukybw4vpu1ptqey;
ALTER TABLE IF EXISTS ONLY employee_schema.employee DROP CONSTRAINT IF EXISTS fkqypxqtmngvkus1we3l8ae42ua;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation_category DROP CONSTRAINT IF EXISTS fkqq06p1cb4qbltmh9m4pdvs6jw;
ALTER TABLE IF EXISTS ONLY employee_schema.absence_type DROP CONSTRAINT IF EXISTS fkqprvpmhxvgda3pcrckm894w40;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_military_service DROP CONSTRAINT IF EXISTS fkqnxmgrkp99418rhmu57oegqbk;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_address DROP CONSTRAINT IF EXISTS fkq100ul0qo7nuxdcbn7adypnyo;
ALTER TABLE IF EXISTS ONLY employee_schema.employee DROP CONSTRAINT IF EXISTS fkq03a9kqm5viib1a6r8rrvvoro;
ALTER TABLE IF EXISTS ONLY employee_schema.military_service_resource DROP CONSTRAINT IF EXISTS fkpyb9svn2brm74lb2pk4lfuyv1;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_work_experience DROP CONSTRAINT IF EXISTS fkpxaxef3g2rf9usfo164jdu8a7;
ALTER TABLE IF EXISTS ONLY employee_schema.attendance DROP CONSTRAINT IF EXISTS fkpnkxqq4luu1ayfdc72oeln9n0;
ALTER TABLE IF EXISTS ONLY employee_schema.relation_type DROP CONSTRAINT IF EXISTS fkph1kv7nx564arww8ewtv4phyg;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip_resource DROP CONSTRAINT IF EXISTS fkoxyxgoyedwpyba0kkwv1im47w;
ALTER TABLE IF EXISTS ONLY employee_schema.degree_type DROP CONSTRAINT IF EXISTS fko83b04gpv0ncm0qn8by8g0sne;
ALTER TABLE IF EXISTS ONLY employee_schema.order_type DROP CONSTRAINT IF EXISTS fko231erfwetim3hygvwbn7p0nc;
ALTER TABLE IF EXISTS ONLY employee_schema.improvement_area DROP CONSTRAINT IF EXISTS fknj775t885aqjq6828k9bixafe;
ALTER TABLE IF EXISTS ONLY employee_schema.subordinate DROP CONSTRAINT IF EXISTS fknh3ry00hstxxyokog99setjy8;
ALTER TABLE IF EXISTS ONLY employee_schema.identification_document_resource DROP CONSTRAINT IF EXISTS fknege5cbi5n8p5hrl4cd4kqw9i;
ALTER TABLE IF EXISTS ONLY employee_schema.subordinate_type DROP CONSTRAINT IF EXISTS fknap7kqqqimw066gjfpotw3wil;
ALTER TABLE IF EXISTS ONLY employee_schema.employment_history DROP CONSTRAINT IF EXISTS fkn4feh5ao76dqek4igc8embfjq;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation_category DROP CONSTRAINT IF EXISTS fkmu4bcn9yk2ja1j6ojrxiwq5wf;
ALTER TABLE IF EXISTS ONLY employee_schema.subordinate DROP CONSTRAINT IF EXISTS fkmeqwlhltnv1awlfqp9wnou4q9;
ALTER TABLE IF EXISTS ONLY employee_schema.agreement_resource DROP CONSTRAINT IF EXISTS fkllw3a5ojo4tdx1fy9nyc6a9u2;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip_order DROP CONSTRAINT IF EXISTS fkli0rm77kwgrwtntmrcano18ac;
ALTER TABLE IF EXISTS ONLY employee_schema.employee DROP CONSTRAINT IF EXISTS fklbe0535e0glnmfvhnucoa0deo;
ALTER TABLE IF EXISTS ONLY employee_schema.performance_goal DROP CONSTRAINT IF EXISTS fkkxiqdb0rvrr4jnk6gykevlv46;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation DROP CONSTRAINT IF EXISTS fkktu32o290aypm00okdefy3dve;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation DROP CONSTRAINT IF EXISTS fkkoxdr5wib25f1wnu3s0ugbrgi;
ALTER TABLE IF EXISTS ONLY employee_schema.employment_history_order DROP CONSTRAINT IF EXISTS fkkmwklwj0peywxitgk3uacxiu7;
ALTER TABLE IF EXISTS ONLY employee_schema.relative DROP CONSTRAINT IF EXISTS fkke9n2cjsijuq4elpdq19syekl;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation DROP CONSTRAINT IF EXISTS fkkbc6gbjn8cvjljc7bqlb6s042;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip DROP CONSTRAINT IF EXISTS fkkb7gn0shpi8cr4k4hhdpgngbo;
ALTER TABLE IF EXISTS ONLY employee_schema.agreement DROP CONSTRAINT IF EXISTS fkkah6fs7sm3547pw8vsihgsr5o;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_resource DROP CONSTRAINT IF EXISTS fkjrythd5uaxcawronsqk1u8wql;
ALTER TABLE IF EXISTS ONLY employee_schema.subordinate DROP CONSTRAINT IF EXISTS fkiwl048p6d831ib9mu4s1tv3a6;
ALTER TABLE IF EXISTS ONLY employee_schema.employee DROP CONSTRAINT IF EXISTS fkivtkrlfso4toqek7i2rul2ggy;
ALTER TABLE IF EXISTS ONLY employee_schema.relative DROP CONSTRAINT IF EXISTS fkis2bmbjevbyykx3r3kwqennmo;
ALTER TABLE IF EXISTS ONLY employee_schema.employment_history_order DROP CONSTRAINT IF EXISTS fki2pddq135usjdi5uoql51wa5l;
ALTER TABLE IF EXISTS ONLY employee_schema.attendance DROP CONSTRAINT IF EXISTS fki2ayggb7whphts7lo9s5hiabw;
ALTER TABLE IF EXISTS ONLY employee_schema.absence DROP CONSTRAINT IF EXISTS fkhpf918yxqjiy72ss2wng04ysb;
ALTER TABLE IF EXISTS ONLY employee_schema.category DROP CONSTRAINT IF EXISTS fkhoptdt843qsievuv3m63nyoa3;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_identification_document DROP CONSTRAINT IF EXISTS fkhnj043913cxj3mso5bfktqvmn;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip DROP CONSTRAINT IF EXISTS fkhe5liylefhedjyumib1q1pw7v;
ALTER TABLE IF EXISTS ONLY employee_schema.citizenship DROP CONSTRAINT IF EXISTS fkgboenhn57icfrd8w0pvwqngr6;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_education DROP CONSTRAINT IF EXISTS fkfyb4ar5ff1h3j48qw18o11nn3;
ALTER TABLE IF EXISTS ONLY employee_schema.agreement DROP CONSTRAINT IF EXISTS fkfn0s7iuoe8tyvl9ds15sgeiwl;
ALTER TABLE IF EXISTS ONLY employee_schema.category DROP CONSTRAINT IF EXISTS fkfifh1ya961x6bkfm1jcbhhwov;
ALTER TABLE IF EXISTS ONLY employee_schema.order_resource DROP CONSTRAINT IF EXISTS fkfdlsao7pbf7x7302bi7tyni5c;
ALTER TABLE IF EXISTS ONLY employee_schema.employee DROP CONSTRAINT IF EXISTS fkf5rstedundygjfga5oke6vdy9;
ALTER TABLE IF EXISTS ONLY employee_schema.citizenship DROP CONSTRAINT IF EXISTS fkeqfwa7oobdr2jhxkxjp2bcexl;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation_type DROP CONSTRAINT IF EXISTS fkefeebk0f9pklbbmmgkiilh968;
ALTER TABLE IF EXISTS ONLY employee_schema.military_data DROP CONSTRAINT IF EXISTS fkeejbqg3i5qxc7sn0u91s9xk5b;
ALTER TABLE IF EXISTS ONLY employee_schema.employment_history DROP CONSTRAINT IF EXISTS fkeb8naot9e7psahmroikw8to9w;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_work_experience DROP CONSTRAINT IF EXISTS fke6lnhnup1ian68ra9lwmmvhsb;
ALTER TABLE IF EXISTS ONLY employee_schema.employee DROP CONSTRAINT IF EXISTS fke0w26qjedr99vwno4pqauw9i9;
ALTER TABLE IF EXISTS ONLY employee_schema.subordinate DROP CONSTRAINT IF EXISTS fke0hy3yc89oagsd6rb1m586luc;
ALTER TABLE IF EXISTS ONLY employee_schema."order" DROP CONSTRAINT IF EXISTS fkdm67dvre5lusgwkfemvmdmrr5;
ALTER TABLE IF EXISTS ONLY employee_schema.absence DROP CONSTRAINT IF EXISTS fkddc6udkd4p67vplctc4qu37aa;
ALTER TABLE IF EXISTS ONLY employee_schema.employee DROP CONSTRAINT IF EXISTS fkd4dvhrigl3oiod8nxp7hcdn3e;
ALTER TABLE IF EXISTS ONLY employee_schema.relative_contact DROP CONSTRAINT IF EXISTS fkd3264n659hs7f2s7907rgbtv6;
ALTER TABLE IF EXISTS ONLY employee_schema.relative DROP CONSTRAINT IF EXISTS fkd2pdicn1g3bax7goxg7k6uldy;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip DROP CONSTRAINT IF EXISTS fkcu3kttivfstkixbjv6jd85xh5;
ALTER TABLE IF EXISTS ONLY employee_schema.military_service_resource DROP CONSTRAINT IF EXISTS fkcjiubvp9d0qqqsk6fbw5x58db;
ALTER TABLE IF EXISTS ONLY employee_schema.subordinate DROP CONSTRAINT IF EXISTS fkc6qd0g5vf9p6lyyus3hw9yjc9;
ALTER TABLE IF EXISTS ONLY employee_schema.performance DROP CONSTRAINT IF EXISTS fkbxpydkcbdllta1uuowe3nq5iq;
ALTER TABLE IF EXISTS ONLY employee_schema.military_data DROP CONSTRAINT IF EXISTS fkbwt7r1y7wo8w0pp6bxdoroqly;
ALTER TABLE IF EXISTS ONLY employee_schema."order" DROP CONSTRAINT IF EXISTS fkbjsajhuskpaln1n6mneqkqdu6;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip_type DROP CONSTRAINT IF EXISTS fkbf5an2bf8o2vk0f15n478ldep;
ALTER TABLE IF EXISTS ONLY employee_schema.subordinate_type DROP CONSTRAINT IF EXISTS fkbdiwayhfo3i0jrm9mdw2i08nf;
ALTER TABLE IF EXISTS ONLY employee_schema.performance_goal DROP CONSTRAINT IF EXISTS fkb6t5f1vopjrquatvc59so1ksg;
ALTER TABLE IF EXISTS ONLY employee_schema.absence_type DROP CONSTRAINT IF EXISTS fkb2t7j25knuv2qrawawgt508u5;
ALTER TABLE IF EXISTS ONLY employee_schema.citizenship DROP CONSTRAINT IF EXISTS fkalap3rkkecpos5jlroxa9jdc5;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_resource DROP CONSTRAINT IF EXISTS fkaht6n9u5gar7haopj06i6flcv;
ALTER TABLE IF EXISTS ONLY employee_schema.performance_type DROP CONSTRAINT IF EXISTS fka5u1m88nu9yn6ma9siht9q2nk;
ALTER TABLE IF EXISTS ONLY employee_schema."order" DROP CONSTRAINT IF EXISTS fka4uqahqcjwjxsk4ucxcn9oy99;
ALTER TABLE IF EXISTS ONLY employee_schema.employment_history DROP CONSTRAINT IF EXISTS fk9yde3w9jegikaprc73mlxcp8b;
ALTER TABLE IF EXISTS ONLY employee_schema.subordinate DROP CONSTRAINT IF EXISTS fk9v5235xa0ydb8qu46775ajgw1;
ALTER TABLE IF EXISTS ONLY employee_schema.employment_history DROP CONSTRAINT IF EXISTS fk9t1s402yqjh2akjoyaeppj4cn;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation DROP CONSTRAINT IF EXISTS fk9qgqto1d9es54f009w5jo2qy;
ALTER TABLE IF EXISTS ONLY employee_schema.employment_history DROP CONSTRAINT IF EXISTS fk9k4h43a85ahbrlpsyy0g6fj3l;
ALTER TABLE IF EXISTS ONLY employee_schema.performance_type DROP CONSTRAINT IF EXISTS fk9k12kjjv31u786199080jycaq;
ALTER TABLE IF EXISTS ONLY employee_schema.performance DROP CONSTRAINT IF EXISTS fk8sam0gkv7e7nxo6xpnrcpjulc;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip_type DROP CONSTRAINT IF EXISTS fk8rm730p0l1men89bhjqis9b8l;
ALTER TABLE IF EXISTS ONLY employee_schema.degree_type DROP CONSTRAINT IF EXISTS fk8ifhh9tkb0hpqhn2y65uuxpav;
ALTER TABLE IF EXISTS ONLY employee_schema.military_data DROP CONSTRAINT IF EXISTS fk8734ijjopberd1bpac1fikxwm;
ALTER TABLE IF EXISTS ONLY employee_schema.employment_history DROP CONSTRAINT IF EXISTS fk82jjwu4lybe98hl25tea0xer2;
ALTER TABLE IF EXISTS ONLY employee_schema.performance DROP CONSTRAINT IF EXISTS fk80mkybbq6la2cys18jw7civ9v;
ALTER TABLE IF EXISTS ONLY employee_schema.employment_history DROP CONSTRAINT IF EXISTS fk7w85uihvou06y0cfh2tp7el6f;
ALTER TABLE IF EXISTS ONLY employee_schema.agreement DROP CONSTRAINT IF EXISTS fk7uujhe6vgm7ecsxfpfk4458et;
ALTER TABLE IF EXISTS ONLY employee_schema.agreement DROP CONSTRAINT IF EXISTS fk7t04a71205tk67nr8wle31yie;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip DROP CONSTRAINT IF EXISTS fk7q30ttgy35bri0luh16buap0x;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_military_service DROP CONSTRAINT IF EXISTS fk7d5xig2y407ro3rt2gyoaev71;
ALTER TABLE IF EXISTS ONLY employee_schema.order_resource DROP CONSTRAINT IF EXISTS fk73im11unqpmftex7i9xpjb5r5;
ALTER TABLE IF EXISTS ONLY employee_schema.relative_address DROP CONSTRAINT IF EXISTS fk6yh8u2v7vu7u121of3sl6wg7t;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation DROP CONSTRAINT IF EXISTS fk6qrwq18c5kq468gvsmwm43cgp;
ALTER TABLE IF EXISTS ONLY employee_schema.relative DROP CONSTRAINT IF EXISTS fk6pm6hmv15mp2i38xni03jjvdi;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_education DROP CONSTRAINT IF EXISTS fk6pm2cgawncfp6nw1ngw484wh4;
ALTER TABLE IF EXISTS ONLY employee_schema.performance DROP CONSTRAINT IF EXISTS fk6nbo3lsulmff7qvtartnl3ssy;
ALTER TABLE IF EXISTS ONLY employee_schema.attendance DROP CONSTRAINT IF EXISTS fk6l2b048vktg11ycytv7qyfpby;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation_type DROP CONSTRAINT IF EXISTS fk6h4avme6cpaqypjrpfxobl24y;
ALTER TABLE IF EXISTS ONLY employee_schema."order" DROP CONSTRAINT IF EXISTS fk642l9mxkwhc8pltov3k06y5au;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_contact DROP CONSTRAINT IF EXISTS fk5vnwbjaww7r4qftg55t0pnfa5;
ALTER TABLE IF EXISTS ONLY employee_schema.performance DROP CONSTRAINT IF EXISTS fk5at4q39xcv7b6tev61o9kcyut;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_citizenship DROP CONSTRAINT IF EXISTS fk5akmxr1o0nnuqtt169m7runrs;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_identification_document DROP CONSTRAINT IF EXISTS fk58xiaqqm5d9v8h75efregooaw;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip_resource DROP CONSTRAINT IF EXISTS fk4mnbrgl7u6cdksmh1c7cc5f6n;
ALTER TABLE IF EXISTS ONLY employee_schema.agreement_resource DROP CONSTRAINT IF EXISTS fk4jygosnp0b318rmclfieoq99x;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_citizenship DROP CONSTRAINT IF EXISTS fk4eoimi5t12nl2wlen7pe5u6jf;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip_order DROP CONSTRAINT IF EXISTS fk49qwfrux7u1wky6u1jjisyihb;
ALTER TABLE IF EXISTS ONLY employee_schema.relative DROP CONSTRAINT IF EXISTS fk47x6bpxatr3vgq25e8k8lvhrm;
ALTER TABLE IF EXISTS ONLY employee_schema.identification_document_resource DROP CONSTRAINT IF EXISTS fk3ly2q9a2n9xhwen9ncy517egr;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip DROP CONSTRAINT IF EXISTS fk3edawsglpqcg4mrfsafbkrr0c;
ALTER TABLE IF EXISTS ONLY employee_schema.employee DROP CONSTRAINT IF EXISTS fk2wajl4v68k4qkwn7jehv3pnkx;
ALTER TABLE IF EXISTS ONLY employee_schema.employment_history DROP CONSTRAINT IF EXISTS fk2tpohs3mesy01gs25knyn6pwc;
ALTER TABLE IF EXISTS ONLY employee_schema.order_type DROP CONSTRAINT IF EXISTS fk2kf472n7qg5sdab8db5bs1qgu;
ALTER TABLE IF EXISTS ONLY employee_schema.employment_history DROP CONSTRAINT IF EXISTS fk2jv1yu1f45j41s84odme64hdw;
ALTER TABLE IF EXISTS ONLY employee_schema.improvement_area DROP CONSTRAINT IF EXISTS fk2j8nqlxl83c3p3eksw6tv5r58;
ALTER TABLE IF EXISTS ONLY employee_schema.performance DROP CONSTRAINT IF EXISTS fk2e06qs6sbg17u12lqpf9o5ldv;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_contact DROP CONSTRAINT IF EXISTS fk2awbwh5itj2xs1bdr6oqt5kyl;
ALTER TABLE IF EXISTS ONLY employee_schema.employee DROP CONSTRAINT IF EXISTS fk299yew76o3gb0qx594rwi1rc8;
ALTER TABLE IF EXISTS ONLY employee_schema.relation_type DROP CONSTRAINT IF EXISTS fk27ug1n3sb8mr36rwx5btrtemv;
ALTER TABLE IF EXISTS ONLY employee_schema.relative DROP CONSTRAINT IF EXISTS fk1ud9mei70evlnh6s7cqfkuqgw;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation DROP CONSTRAINT IF EXISTS fk1phnxx2yrergmehyviq52iiqq;
ALTER TABLE IF EXISTS ONLY employee_schema.relative DROP CONSTRAINT IF EXISTS fk1i86k4h1124ajyihe83h20krc;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip DROP CONSTRAINT IF EXISTS fk13jgxiwa0x6a3gs90s2xeh5t3;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip DROP CONSTRAINT IF EXISTS fk123bn3famxxbqdrfm8to1eea4;
ALTER TABLE IF EXISTS ONLY education_schema.education DROP CONSTRAINT IF EXISTS fktohgygeab9v53147sbpg4cpdf;
ALTER TABLE IF EXISTS ONLY education_schema.degree_type DROP CONSTRAINT IF EXISTS fko83b04gpv0ncm0qn8by8g0sne;
ALTER TABLE IF EXISTS ONLY education_schema.education_document_type DROP CONSTRAINT IF EXISTS fko6r7h9nihgo3t0t1iccw0larx;
ALTER TABLE IF EXISTS ONLY education_schema.education_type DROP CONSTRAINT IF EXISTS fkktgwip7bg4ly8sbwpelhg2ld3;
ALTER TABLE IF EXISTS ONLY education_schema.education DROP CONSTRAINT IF EXISTS fkkhui07xo70funlw7srna0pph8;
ALTER TABLE IF EXISTS ONLY education_schema.education DROP CONSTRAINT IF EXISTS fkid3099i5vcjl46o5m8mtea452;
ALTER TABLE IF EXISTS ONLY education_schema.grade_point_average DROP CONSTRAINT IF EXISTS fkibb94svl1rnxnrk5ta2pb11tc;
ALTER TABLE IF EXISTS ONLY education_schema.education DROP CONSTRAINT IF EXISTS fkhkops45a1klf1mnpvg6rsdbxv;
ALTER TABLE IF EXISTS ONLY education_schema.education DROP CONSTRAINT IF EXISTS fkfkb4mxbsjpn17dykxmuoy1n9m;
ALTER TABLE IF EXISTS ONLY education_schema.education_document_type DROP CONSTRAINT IF EXISTS fkdqv0twdc3y2y68k8boarvdnn2;
ALTER TABLE IF EXISTS ONLY education_schema.education_resource DROP CONSTRAINT IF EXISTS fkc26yy5lxdhi5qmv777e2mpt6x;
ALTER TABLE IF EXISTS ONLY education_schema.accreditation_status DROP CONSTRAINT IF EXISTS fkbrwbgditk56ui01dh4p61h6kh;
ALTER TABLE IF EXISTS ONLY education_schema.grade_point_average DROP CONSTRAINT IF EXISTS fkb830fjxi2tf4antgy2r970pyy;
ALTER TABLE IF EXISTS ONLY education_schema.degree_type DROP CONSTRAINT IF EXISTS fk8ifhh9tkb0hpqhn2y65uuxpav;
ALTER TABLE IF EXISTS ONLY education_schema.education DROP CONSTRAINT IF EXISTS fk8dpbwqpg0jd8gnmr94is1gbsb;
ALTER TABLE IF EXISTS ONLY education_schema.accreditation_status DROP CONSTRAINT IF EXISTS fk53gqywq4nuwrnrcck11wv6b44;
ALTER TABLE IF EXISTS ONLY education_schema.education_resource DROP CONSTRAINT IF EXISTS fk3ioofgha55f9qsxf665fl76hv;
ALTER TABLE IF EXISTS ONLY education_schema.education DROP CONSTRAINT IF EXISTS fk2xt0s5mcujs2n7n7ipxo1ho07;
ALTER TABLE IF EXISTS ONLY education_schema.education DROP CONSTRAINT IF EXISTS fk23y37u75qregx6obc8y907b87;
ALTER TABLE IF EXISTS ONLY education_schema.education_type DROP CONSTRAINT IF EXISTS fk1i41pramnkarrbgnvju7v1tli;
ALTER TABLE IF EXISTS ONLY dictionary_schema.priority DROP CONSTRAINT IF EXISTS fkun6j2rgytvacmats39hieqwh;
ALTER TABLE IF EXISTS ONLY dictionary_schema.status_category DROP CONSTRAINT IF EXISTS fkt5mnpkn0rsetqfv1eke2n5780;
ALTER TABLE IF EXISTS ONLY dictionary_schema.color DROP CONSTRAINT IF EXISTS fkri4odaxpfogqs7e6gqxgdb84;
ALTER TABLE IF EXISTS ONLY dictionary_schema.status DROP CONSTRAINT IF EXISTS fkrcjlv19qxa2fv7d5gfhu56d74;
ALTER TABLE IF EXISTS ONLY dictionary_schema.color DROP CONSTRAINT IF EXISTS fkon8d69le0cfp0uc95pfihqokr;
ALTER TABLE IF EXISTS ONLY dictionary_schema.status_category DROP CONSTRAINT IF EXISTS fknrjn4nrgn32pyui38e7iv0e4b;
ALTER TABLE IF EXISTS ONLY dictionary_schema.entity_type DROP CONSTRAINT IF EXISTS fkn5e8fh3fmigodflmm3n67vwwd;
ALTER TABLE IF EXISTS ONLY dictionary_schema.profile_attribute DROP CONSTRAINT IF EXISTS fkm33393swpyo2ch5c0jdp278x1;
ALTER TABLE IF EXISTS ONLY dictionary_schema.nationality DROP CONSTRAINT IF EXISTS fkkkh3nipii8lshje7x9mtrvwos;
ALTER TABLE IF EXISTS ONLY dictionary_schema.entity_type DROP CONSTRAINT IF EXISTS fkjhrfynx5cv2xgpuhjwdqw2epa;
ALTER TABLE IF EXISTS ONLY dictionary_schema.profile_attribute DROP CONSTRAINT IF EXISTS fkjb1vvumo8kehaqu8wp1p7xkyq;
ALTER TABLE IF EXISTS ONLY dictionary_schema.gender DROP CONSTRAINT IF EXISTS fkfbabbrlhfpcge0qak10pvkn3k;
ALTER TABLE IF EXISTS ONLY dictionary_schema.status DROP CONSTRAINT IF EXISTS fkdfgxuugw1cosvegie2xvo9m80;
ALTER TABLE IF EXISTS ONLY dictionary_schema.week_day DROP CONSTRAINT IF EXISTS fkdert1h6nrmbc9w53ovre07qkr;
ALTER TABLE IF EXISTS ONLY dictionary_schema.notification_template DROP CONSTRAINT IF EXISTS fkdd8bgvdp58lrm9o9fg3umqtm;
ALTER TABLE IF EXISTS ONLY dictionary_schema.status DROP CONSTRAINT IF EXISTS fkd9qn37uaaw1ovkp6hqapathx4;
ALTER TABLE IF EXISTS ONLY dictionary_schema.nationality DROP CONSTRAINT IF EXISTS fkd62o8lro0tqmk3igphwcb9qe5;
ALTER TABLE IF EXISTS ONLY dictionary_schema.priority DROP CONSTRAINT IF EXISTS fkcw8i98r8l4dsndogbr48n8lt7;
ALTER TABLE IF EXISTS ONLY dictionary_schema.currency DROP CONSTRAINT IF EXISTS fka1xqilmjmlheudk4sayosgw35;
ALTER TABLE IF EXISTS ONLY dictionary_schema.boolean_type DROP CONSTRAINT IF EXISTS fk8kxc7gjq2al2161mi3j9vct1d;
ALTER TABLE IF EXISTS ONLY dictionary_schema.marital_status DROP CONSTRAINT IF EXISTS fk8gq2yeljves7bd5v1e1t0u1io;
ALTER TABLE IF EXISTS ONLY dictionary_schema.boolean_type DROP CONSTRAINT IF EXISTS fk85qmg5hqxtwohdvp0osq80tja;
ALTER TABLE IF EXISTS ONLY dictionary_schema.currency DROP CONSTRAINT IF EXISTS fk79etc6q9b2vootvpsqidchvpo;
ALTER TABLE IF EXISTS ONLY dictionary_schema.marital_status DROP CONSTRAINT IF EXISTS fk40f9yjfi56ggrpk0awkdcl2hv;
ALTER TABLE IF EXISTS ONLY dictionary_schema.week_day DROP CONSTRAINT IF EXISTS fk3qjdeyq3j3xq7240wf2wwe7eg;
ALTER TABLE IF EXISTS ONLY dictionary_schema.notification_template DROP CONSTRAINT IF EXISTS fk39qy1mf664q9dw7ggc3vd0mtf;
ALTER TABLE IF EXISTS ONLY dictionary_schema.gender DROP CONSTRAINT IF EXISTS fk1tq6qdh89422se45pax0grn09;
ALTER TABLE IF EXISTS ONLY dictionary_schema.currency DROP CONSTRAINT IF EXISTS fk17ygkjm2gdj1c9xwqc9ypqy00;
ALTER TABLE IF EXISTS ONLY contact_schema.contact_type DROP CONSTRAINT IF EXISTS fkr37miqa9wwlta390e7y1g11qg;
ALTER TABLE IF EXISTS ONLY contact_schema.contact DROP CONSTRAINT IF EXISTS fkq3txv43jn2phda1erhgna376;
ALTER TABLE IF EXISTS ONLY contact_schema.contact DROP CONSTRAINT IF EXISTS fkhle461hp79ep59427x8sy8mcv;
ALTER TABLE IF EXISTS ONLY contact_schema.phone DROP CONSTRAINT IF EXISTS fk7oeaickke8yowswp3jw0ttp1j;
ALTER TABLE IF EXISTS ONLY contact_schema.contact DROP CONSTRAINT IF EXISTS fk6dfda2c1owl8p09s48oeqsevo;
ALTER TABLE IF EXISTS ONLY contact_schema.email DROP CONSTRAINT IF EXISTS fk5ut3utbreyxhc26aj3dbqwo6o;
ALTER TABLE IF EXISTS ONLY contact_schema.phone DROP CONSTRAINT IF EXISTS fk5fonk3epkuq5y0lji2rxgoi46;
ALTER TABLE IF EXISTS ONLY contact_schema.email DROP CONSTRAINT IF EXISTS fk58a0ae7aoxo72yhmornr36rch;
ALTER TABLE IF EXISTS ONLY contact_schema.contact_type DROP CONSTRAINT IF EXISTS fk4y3njac1f77eq0e8pawvi187i;
ALTER TABLE IF EXISTS ONLY contact_schema.phone DROP CONSTRAINT IF EXISTS fk1lsao6buypghr60y1qr4hqccg;
ALTER TABLE IF EXISTS ONLY citizenship_schema.citizenship DROP CONSTRAINT IF EXISTS fkgboenhn57icfrd8w0pvwqngr6;
ALTER TABLE IF EXISTS ONLY citizenship_schema.citizenship DROP CONSTRAINT IF EXISTS fkeqfwa7oobdr2jhxkxjp2bcexl;
ALTER TABLE IF EXISTS ONLY citizenship_schema.citizenship DROP CONSTRAINT IF EXISTS fkalap3rkkecpos5jlroxa9jdc5;
ALTER TABLE IF EXISTS ONLY authorization_schema.role_menu DROP CONSTRAINT IF EXISTS fksqvftvysmktcjrny8eime8ieg;
ALTER TABLE IF EXISTS ONLY authorization_schema.user_role DROP CONSTRAINT IF EXISTS fks4g23geu7g5v07nnvrnq67ona;
ALTER TABLE IF EXISTS ONLY authorization_schema.permission DROP CONSTRAINT IF EXISTS fkrvhjnns4bvlh4m1n97vb7vbar;
ALTER TABLE IF EXISTS ONLY authorization_schema.role_menu DROP CONSTRAINT IF EXISTS fkqyvxw2gg2qk0wld3bqfcb58vq;
ALTER TABLE IF EXISTS ONLY authorization_schema."user" DROP CONSTRAINT IF EXISTS fkpm7nbf6vwm8j4iooot5u2l2im;
ALTER TABLE IF EXISTS ONLY authorization_schema.role_menu DROP CONSTRAINT IF EXISTS fkoyyb9fbrw8m2bg394b17thutk;
ALTER TABLE IF EXISTS ONLY authorization_schema.role DROP CONSTRAINT IF EXISTS fkll733e2s14htp59p4u1xu6igt;
ALTER TABLE IF EXISTS ONLY authorization_schema.role DROP CONSTRAINT IF EXISTS fkl0e5mr26wklg19k284s3hl97x;
ALTER TABLE IF EXISTS ONLY authorization_schema.user_role DROP CONSTRAINT IF EXISTS fki9a4o2ub6hnix7u6v954kq13e;
ALTER TABLE IF EXISTS ONLY authorization_schema."user" DROP CONSTRAINT IF EXISTS fkhnncm3gx8plxt0kxg73vb9xdl;
ALTER TABLE IF EXISTS ONLY authorization_schema.permission DROP CONSTRAINT IF EXISTS fkgxp3gb1gugx0m59afu94q4vsk;
ALTER TABLE IF EXISTS ONLY authorization_schema.role_menu DROP CONSTRAINT IF EXISTS fkfg4e2mb2318tph615gh44ll3;
ALTER TABLE IF EXISTS ONLY authorization_schema.user_role DROP CONSTRAINT IF EXISTS fkeaal3twvgbxugcnyu3s80muwa;
ALTER TABLE IF EXISTS ONLY authorization_schema.role_menu DROP CONSTRAINT IF EXISTS fke89oo3eui9vm09ykl0hrp3m7x;
ALTER TABLE IF EXISTS ONLY authorization_schema.user_role DROP CONSTRAINT IF EXISTS fka68196081fvovjhkek5m97n3y;
ALTER TABLE IF EXISTS ONLY authorization_schema.permission DROP CONSTRAINT IF EXISTS fk8tesfd2mgbbhptupsmypnd0f0;
ALTER TABLE IF EXISTS ONLY authorization_schema.user_role DROP CONSTRAINT IF EXISTS fk859n2jvi8ivhui0rl0esws6o;
ALTER TABLE IF EXISTS ONLY authorization_schema.permission DROP CONSTRAINT IF EXISTS fk78dqnhvwivyqqvxk94cm9jknn;
ALTER TABLE IF EXISTS ONLY authorization_schema.permission DROP CONSTRAINT IF EXISTS fk5ibv5hxbhsssd0wf5i0ivfcel;
ALTER TABLE IF EXISTS ONLY authorization_schema.permission DROP CONSTRAINT IF EXISTS fk1vuuuiyorxgvlph2maf3slffu;
ALTER TABLE IF EXISTS ONLY authorization_schema.role_menu DROP CONSTRAINT IF EXISTS fk1qnjbh7xgyidgxp4y91j54kfu;
ALTER TABLE IF EXISTS ONLY work_schedule_schema.work_schedule DROP CONSTRAINT IF EXISTS work_schedule_pkey;
ALTER TABLE IF EXISTS ONLY user_schema."user" DROP CONSTRAINT IF EXISTS user_pkey;
ALTER TABLE IF EXISTS ONLY user_schema.profile DROP CONSTRAINT IF EXISTS profile_pkey;
ALTER TABLE IF EXISTS ONLY user_schema.authentication DROP CONSTRAINT IF EXISTS authentication_pkey;
ALTER TABLE IF EXISTS ONLY ui_schema.component DROP CONSTRAINT IF EXISTS uk24wq1y3l3mfjohvgtsewd3vo;
ALTER TABLE IF EXISTS ONLY ui_schema.attribute DROP CONSTRAINT IF EXISTS uk1774shfid1uaopl9tu8am19fq;
ALTER TABLE IF EXISTS ONLY ui_schema.component DROP CONSTRAINT IF EXISTS component_pkey;
ALTER TABLE IF EXISTS ONLY ui_schema.component_attributes DROP CONSTRAINT IF EXISTS component_attributes_pkey;
ALTER TABLE IF EXISTS ONLY ui_schema.attribute DROP CONSTRAINT IF EXISTS attribute_pkey;
ALTER TABLE IF EXISTS ONLY testing_schema.question_type DROP CONSTRAINT IF EXISTS uk3oe9r9iajofacvmw5n198nb66;
ALTER TABLE IF EXISTS ONLY testing_schema.test_session DROP CONSTRAINT IF EXISTS test_session_pkey;
ALTER TABLE IF EXISTS ONLY testing_schema.test DROP CONSTRAINT IF EXISTS test_pkey;
ALTER TABLE IF EXISTS ONLY testing_schema.selected_answer DROP CONSTRAINT IF EXISTS selected_answer_pkey;
ALTER TABLE IF EXISTS ONLY testing_schema.question_type DROP CONSTRAINT IF EXISTS question_type_pkey;
ALTER TABLE IF EXISTS ONLY testing_schema.question DROP CONSTRAINT IF EXISTS question_pkey;
ALTER TABLE IF EXISTS ONLY testing_schema.answer_submission DROP CONSTRAINT IF EXISTS answer_submission_pkey;
ALTER TABLE IF EXISTS ONLY testing_schema.selectedAnswer DROP CONSTRAINT IF EXISTS answer_pkey;
ALTER TABLE IF EXISTS ONLY system_schema.service_provider_type DROP CONSTRAINT IF EXISTS ukm91w434gce8g8e532nb0sqbj5;
ALTER TABLE IF EXISTS ONLY system_schema.message_type DROP CONSTRAINT IF EXISTS uklkdrmpmq8pwcat2q77n97ul9e;
ALTER TABLE IF EXISTS ONLY system_schema.message DROP CONSTRAINT IF EXISTS ukf01yqjmocyfddiquvwskkaqh4;
ALTER TABLE IF EXISTS ONLY system_schema.notification_type DROP CONSTRAINT IF EXISTS uk7xy7aqj808cq628lqotsynoyx;
ALTER TABLE IF EXISTS ONLY system_schema.service_provider_type DROP CONSTRAINT IF EXISTS service_provider_type_pkey;
ALTER TABLE IF EXISTS ONLY system_schema.service_provider DROP CONSTRAINT IF EXISTS service_provider_pkey;
ALTER TABLE IF EXISTS ONLY system_schema.notification_type DROP CONSTRAINT IF EXISTS notification_type_pkey;
ALTER TABLE IF EXISTS ONLY system_schema.notification DROP CONSTRAINT IF EXISTS notification_pkey;
ALTER TABLE IF EXISTS ONLY system_schema.message_type DROP CONSTRAINT IF EXISTS message_type_pkey;
ALTER TABLE IF EXISTS ONLY system_schema.message DROP CONSTRAINT IF EXISTS message_pkey;
ALTER TABLE IF EXISTS ONLY system_schema.environment_variable DROP CONSTRAINT IF EXISTS environment_variable_pkey;
ALTER TABLE IF EXISTS ONLY state_schema.entity_state DROP CONSTRAINT IF EXISTS entity_state_pkey;
ALTER TABLE IF EXISTS ONLY resource_schema.resource DROP CONSTRAINT IF EXISTS resource_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.vacancy DROP CONSTRAINT IF EXISTS vacancy_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_type DROP CONSTRAINT IF EXISTS ukth0vxw19f48biow3p3iikvt5r;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_resource_type DROP CONSTRAINT IF EXISTS uked3on7pgjke7dg5y0or7njivt;
ALTER TABLE IF EXISTS ONLY recruitment_schema.skill DROP CONSTRAINT IF EXISTS skill_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interviewer DROP CONSTRAINT IF EXISTS interviewer_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interviewee DROP CONSTRAINT IF EXISTS interviewee_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_type DROP CONSTRAINT IF EXISTS interview_type_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview DROP CONSTRAINT IF EXISTS interview_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_section DROP CONSTRAINT IF EXISTS interview_evaluation_section_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_question DROP CONSTRAINT IF EXISTS interview_evaluation_question_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation DROP CONSTRAINT IF EXISTS interview_evaluation_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.interview_evaluation_answer DROP CONSTRAINT IF EXISTS interview_evaluation_answer_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.experience DROP CONSTRAINT IF EXISTS experience_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.duty DROP CONSTRAINT IF EXISTS duty_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_work_experience DROP CONSTRAINT IF EXISTS candidate_work_experience_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_resource_type DROP CONSTRAINT IF EXISTS candidate_resource_type_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_resource DROP CONSTRAINT IF EXISTS candidate_resource_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate DROP CONSTRAINT IF EXISTS candidate_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_military_service DROP CONSTRAINT IF EXISTS candidate_military_service_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_identification_document DROP CONSTRAINT IF EXISTS candidate_identification_document_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_education DROP CONSTRAINT IF EXISTS candidate_education_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_contact DROP CONSTRAINT IF EXISTS candidate_contact_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_citizenship DROP CONSTRAINT IF EXISTS candidate_citizenship_pkey;
ALTER TABLE IF EXISTS ONLY recruitment_schema.candidate_address DROP CONSTRAINT IF EXISTS candidate_address_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.work_schedule DROP CONSTRAINT IF EXISTS work_schedule_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.reporting_line_type DROP CONSTRAINT IF EXISTS ukrs8vcxrd9geshgoit5p4u7i0h;
ALTER TABLE IF EXISTS ONLY organization_schema.separationReason DROP CONSTRAINT IF EXISTS ukq8ymhgj6pt1msox0o3bg51uvo;
ALTER TABLE IF EXISTS ONLY organization_schema.grade DROP CONSTRAINT IF EXISTS ukmfpeq9u7tfkalk2vbwwibtf4f;
ALTER TABLE IF EXISTS ONLY organization_schema.grade_level DROP CONSTRAINT IF EXISTS ukbjrlvdyf754q4tuy7y3d6yv0x;
ALTER TABLE IF EXISTS ONLY organization_schema."position" DROP CONSTRAINT IF EXISTS ukaqoegu9tj6s7t7f31abslcng;
ALTER TABLE IF EXISTS ONLY organization_schema.organization_unit DROP CONSTRAINT IF EXISTS uka3pc00agj2tlg6eoo1kvvvkoy;
ALTER TABLE IF EXISTS ONLY organization_schema.organization DROP CONSTRAINT IF EXISTS uk27tbqbmjb9kf4al49ojliavjt;
ALTER TABLE IF EXISTS ONLY organization_schema.responsibility DROP CONSTRAINT IF EXISTS responsibility_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.required_experience DROP CONSTRAINT IF EXISTS required_experience_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.reporting_line_type DROP CONSTRAINT IF EXISTS reporting_line_type_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.reporting_line DROP CONSTRAINT IF EXISTS reporting_line_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.qualification DROP CONSTRAINT IF EXISTS qualification_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema."position" DROP CONSTRAINT IF EXISTS position_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.organization_unit DROP CONSTRAINT IF EXISTS organization_unit_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.organization DROP CONSTRAINT IF EXISTS organization_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.organization_contact DROP CONSTRAINT IF EXISTS organization_contact_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.organization_address DROP CONSTRAINT IF EXISTS organization_address_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.key_performance_indicator DROP CONSTRAINT IF EXISTS key_performance_indicator_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.job_description DROP CONSTRAINT IF EXISTS job_description_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.grade_step DROP CONSTRAINT IF EXISTS grade_step_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.grade DROP CONSTRAINT IF EXISTS grade_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.grade_level DROP CONSTRAINT IF EXISTS grade_level_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.separationReason DROP CONSTRAINT IF EXISTS department_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.authority DROP CONSTRAINT IF EXISTS authority_pkey;
ALTER TABLE IF EXISTS ONLY organization_schema.accountability DROP CONSTRAINT IF EXISTS accountability_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.action_category DROP CONSTRAINT IF EXISTS uks7ch6269v14wjpa05sp193rhn;
ALTER TABLE IF EXISTS ONLY navigation_schema.action_type DROP CONSTRAINT IF EXISTS uk3face27420q5tai4u7senj6id;
ALTER TABLE IF EXISTS ONLY navigation_schema.public_url DROP CONSTRAINT IF EXISTS public_url_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.navigation_unit DROP CONSTRAINT IF EXISTS navigation_unit_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_transition DROP CONSTRAINT IF EXISTS menu_transition_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu DROP CONSTRAINT IF EXISTS menu_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_configuration DROP CONSTRAINT IF EXISTS menu_configuration_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action_transition DROP CONSTRAINT IF EXISTS menu_action_transition_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action DROP CONSTRAINT IF EXISTS menu_action_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.menu_action_form_component DROP CONSTRAINT IF EXISTS menu_action_form_component_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.form_components DROP CONSTRAINT IF EXISTS form_components_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.form_component_attributes DROP CONSTRAINT IF EXISTS form_component_attributes_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.configuration DROP CONSTRAINT IF EXISTS configuration_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.action_type DROP CONSTRAINT IF EXISTS action_type_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.action DROP CONSTRAINT IF EXISTS action_pkey;
ALTER TABLE IF EXISTS ONLY navigation_schema.action_category DROP CONSTRAINT IF EXISTS action_category_pkey;
ALTER TABLE IF EXISTS ONLY military_schema.military_service_resource DROP CONSTRAINT IF EXISTS military_service_resource_pkey;
ALTER TABLE IF EXISTS ONLY military_schema.military_service DROP CONSTRAINT IF EXISTS military_service_pkey;
ALTER TABLE IF EXISTS ONLY location_schema.city DROP CONSTRAINT IF EXISTS ukp738egrkomomgourst3hqfipb;
ALTER TABLE IF EXISTS ONLY location_schema.region DROP CONSTRAINT IF EXISTS ukkntnlvx8xwbfrg1flw2mnwa9v;
ALTER TABLE IF EXISTS ONLY location_schema.country DROP CONSTRAINT IF EXISTS ukik5yv6a3ayb6i3fl69nuv2cbg;
ALTER TABLE IF EXISTS ONLY location_schema.address_type DROP CONSTRAINT IF EXISTS uk855fb2napr2cby4c0dyx62fof;
ALTER TABLE IF EXISTS ONLY location_schema.area_type DROP CONSTRAINT IF EXISTS uk83ptek778l1bcp5tw5gd7v2hv;
ALTER TABLE IF EXISTS ONLY location_schema.country DROP CONSTRAINT IF EXISTS uk7x9edox99l6q9s85eh60h7qx3;
ALTER TABLE IF EXISTS ONLY location_schema.district DROP CONSTRAINT IF EXISTS uk7ava2vvsdlafw7ca6y5j2a6q8;
ALTER TABLE IF EXISTS ONLY location_schema.country DROP CONSTRAINT IF EXISTS uk5s4ptnuqtd24d4p9au2rv53qm;
ALTER TABLE IF EXISTS ONLY location_schema.region DROP CONSTRAINT IF EXISTS region_pkey;
ALTER TABLE IF EXISTS ONLY location_schema.district DROP CONSTRAINT IF EXISTS district_pkey;
ALTER TABLE IF EXISTS ONLY location_schema.country DROP CONSTRAINT IF EXISTS country_pkey;
ALTER TABLE IF EXISTS ONLY location_schema.city DROP CONSTRAINT IF EXISTS city_pkey;
ALTER TABLE IF EXISTS ONLY location_schema.area_type DROP CONSTRAINT IF EXISTS area_type_pkey;
ALTER TABLE IF EXISTS ONLY location_schema.address_type DROP CONSTRAINT IF EXISTS address_type_pkey;
ALTER TABLE IF EXISTS ONLY location_schema.address DROP CONSTRAINT IF EXISTS address_pkey;
ALTER TABLE IF EXISTS ONLY localization_schema.layout_label DROP CONSTRAINT IF EXISTS layout_label_pkey;
ALTER TABLE IF EXISTS ONLY localization_schema.layout_label_detail DROP CONSTRAINT IF EXISTS layout_label_detail_pkey;
ALTER TABLE IF EXISTS ONLY localization_schema.language DROP CONSTRAINT IF EXISTS language_pkey;
ALTER TABLE IF EXISTS ONLY identification_schema.identification_document_type DROP CONSTRAINT IF EXISTS uk2dxiha4nh0a2kcxd2o4o3tshf;
ALTER TABLE IF EXISTS ONLY identification_schema.identification_document_type DROP CONSTRAINT IF EXISTS identification_document_type_pkey;
ALTER TABLE IF EXISTS ONLY identification_schema.identification_document DROP CONSTRAINT IF EXISTS identification_document_pkey;
ALTER TABLE IF EXISTS ONLY employment_schema.work_experience DROP CONSTRAINT IF EXISTS work_experience_pkey;
ALTER TABLE IF EXISTS ONLY employment_schema.employment_type DROP CONSTRAINT IF EXISTS uk71pmomvgrujwpl0dg2shtvlut;
ALTER TABLE IF EXISTS ONLY employment_schema.employment_type DROP CONSTRAINT IF EXISTS employment_type_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation_type DROP CONSTRAINT IF EXISTS vacation_type_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation DROP CONSTRAINT IF EXISTS vacation_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation_category DROP CONSTRAINT IF EXISTS vacation_category_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation_type DROP CONSTRAINT IF EXISTS ukx7o5137x8hwqhuh1wml1n32r;
ALTER TABLE IF EXISTS ONLY employee_schema.vacation_category DROP CONSTRAINT IF EXISTS ukrp87nf5taxt1ugg3b5h21q3lo;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip_type DROP CONSTRAINT IF EXISTS uko1ggbkyajjiptmcomhi0ffagm;
ALTER TABLE IF EXISTS ONLY employee_schema.relation_type DROP CONSTRAINT IF EXISTS ukifjynaw0ofk2slpcyf6453ele;
ALTER TABLE IF EXISTS ONLY employee_schema.degree_type DROP CONSTRAINT IF EXISTS ukf8slwa45wba6217cj0pm28i4a;
ALTER TABLE IF EXISTS ONLY employee_schema.performance_type DROP CONSTRAINT IF EXISTS ukbxm6l0cvge4qtuc250wsx321b;
ALTER TABLE IF EXISTS ONLY employee_schema.category DROP CONSTRAINT IF EXISTS ukacatplu22q5d1andql2jbvjy7;
ALTER TABLE IF EXISTS ONLY employee_schema.absence_type DROP CONSTRAINT IF EXISTS uk9v9g4p72tax6fkuo4id7943jt;
ALTER TABLE IF EXISTS ONLY employee_schema.subordinate_type DROP CONSTRAINT IF EXISTS uk4lblubv0wriq6p2wnl202v8cp;
ALTER TABLE IF EXISTS ONLY employee_schema.order_type DROP CONSTRAINT IF EXISTS uk4guluy495shiio5qhhmb79tp6;
ALTER TABLE IF EXISTS ONLY employee_schema.subordinate_type DROP CONSTRAINT IF EXISTS subordinate_type_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.subordinate DROP CONSTRAINT IF EXISTS subordinate_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.relative DROP CONSTRAINT IF EXISTS relative_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.relative_contact DROP CONSTRAINT IF EXISTS relative_contact_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.relative_address DROP CONSTRAINT IF EXISTS relative_address_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.relation_type DROP CONSTRAINT IF EXISTS relation_type_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.performance_type DROP CONSTRAINT IF EXISTS performance_type_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.performance DROP CONSTRAINT IF EXISTS performance_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.performance_goal DROP CONSTRAINT IF EXISTS performance_goal_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.order_type DROP CONSTRAINT IF EXISTS order_type_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.order_resource DROP CONSTRAINT IF EXISTS order_resource_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema."order" DROP CONSTRAINT IF EXISTS oder_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.military_service_resource DROP CONSTRAINT IF EXISTS military_service_resource_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.military_data DROP CONSTRAINT IF EXISTS military_data_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.improvement_area DROP CONSTRAINT IF EXISTS improvement_area_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.identification_document_resource DROP CONSTRAINT IF EXISTS identification_document_resource_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.employment_history DROP CONSTRAINT IF EXISTS employment_history_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.employment_history_order DROP CONSTRAINT IF EXISTS employment_history_order_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_work_experience DROP CONSTRAINT IF EXISTS employee_work_experience_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_resource DROP CONSTRAINT IF EXISTS employee_resource_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.employee DROP CONSTRAINT IF EXISTS employee_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_military_service DROP CONSTRAINT IF EXISTS employee_military_service_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_identification_document DROP CONSTRAINT IF EXISTS employee_identification_document_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_education DROP CONSTRAINT IF EXISTS employee_education_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_contact DROP CONSTRAINT IF EXISTS employee_contact_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_citizenship DROP CONSTRAINT IF EXISTS employee_citizenship_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.employee_address DROP CONSTRAINT IF EXISTS employee_address_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.degree_type DROP CONSTRAINT IF EXISTS degree_type_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.citizenship DROP CONSTRAINT IF EXISTS citizenship_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.category DROP CONSTRAINT IF EXISTS category_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip_type DROP CONSTRAINT IF EXISTS business_trip_type_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip_resource DROP CONSTRAINT IF EXISTS business_trip_resource_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip DROP CONSTRAINT IF EXISTS business_trip_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.business_trip_order DROP CONSTRAINT IF EXISTS business_trip_order_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.attendance DROP CONSTRAINT IF EXISTS attendance_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.agreement_resource DROP CONSTRAINT IF EXISTS agreement_resource_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.agreement DROP CONSTRAINT IF EXISTS agreement_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.absence_type DROP CONSTRAINT IF EXISTS absence_type_pkey;
ALTER TABLE IF EXISTS ONLY employee_schema.absence DROP CONSTRAINT IF EXISTS absence_pkey;
ALTER TABLE IF EXISTS ONLY education_schema.education_document_type DROP CONSTRAINT IF EXISTS uksf750v55q844hxbs563cjn5m6;
ALTER TABLE IF EXISTS ONLY education_schema.accreditation_status DROP CONSTRAINT IF EXISTS uklpn2bhq1jq2wwib5drvl636eq;
ALTER TABLE IF EXISTS ONLY education_schema.degree_type DROP CONSTRAINT IF EXISTS ukf8slwa45wba6217cj0pm28i4a;
ALTER TABLE IF EXISTS ONLY education_schema.education_type DROP CONSTRAINT IF EXISTS ukbs1eww46yx7tfr1mmj1992mwo;
ALTER TABLE IF EXISTS ONLY education_schema.grade_point_average DROP CONSTRAINT IF EXISTS grade_point_average_pkey;
ALTER TABLE IF EXISTS ONLY education_schema.education_type DROP CONSTRAINT IF EXISTS education_type_pkey;
ALTER TABLE IF EXISTS ONLY education_schema.education_resource DROP CONSTRAINT IF EXISTS education_resource_pkey;
ALTER TABLE IF EXISTS ONLY education_schema.education DROP CONSTRAINT IF EXISTS education_pkey;
ALTER TABLE IF EXISTS ONLY education_schema.education_document_type DROP CONSTRAINT IF EXISTS education_document_type_pkey;
ALTER TABLE IF EXISTS ONLY education_schema.degree_type DROP CONSTRAINT IF EXISTS degree_type_pkey;
ALTER TABLE IF EXISTS ONLY education_schema.accreditation_status DROP CONSTRAINT IF EXISTS accreditation_status_pkey;
ALTER TABLE IF EXISTS ONLY dictionary_schema.week_day DROP CONSTRAINT IF EXISTS week_day_pkey;
ALTER TABLE IF EXISTS ONLY dictionary_schema.gender DROP CONSTRAINT IF EXISTS ukmxvfcsf1euhi5hsw1uecvke7b;
ALTER TABLE IF EXISTS ONLY dictionary_schema.boolean_type DROP CONSTRAINT IF EXISTS ukkfut4g2l7kkee3l47xjsmn3w3;
ALTER TABLE IF EXISTS ONLY dictionary_schema.week_day DROP CONSTRAINT IF EXISTS ukhq6bi56xgu0lkj3a8x55ibm08;
ALTER TABLE IF EXISTS ONLY dictionary_schema.currency DROP CONSTRAINT IF EXISTS ukh84pd2rtr12isnifnj655rkra;
ALTER TABLE IF EXISTS ONLY dictionary_schema.nationality DROP CONSTRAINT IF EXISTS ukfhrdubfm3may69kh6fx05ndk;
ALTER TABLE IF EXISTS ONLY dictionary_schema.status_category DROP CONSTRAINT IF EXISTS ukdldakj77yydalqni2sj0u6inw;
ALTER TABLE IF EXISTS ONLY dictionary_schema.color DROP CONSTRAINT IF EXISTS ukcbnc5ktj6whhh690w32k8cyh8;
ALTER TABLE IF EXISTS ONLY dictionary_schema.status DROP CONSTRAINT IF EXISTS uk90n0sv25slo1kmu0tcakhjjed;
ALTER TABLE IF EXISTS ONLY dictionary_schema.entity_type DROP CONSTRAINT IF EXISTS uk8ykg7p8p3n0hjnpwl9gft36g3;
ALTER TABLE IF EXISTS ONLY dictionary_schema.notification_template DROP CONSTRAINT IF EXISTS uk78ljxu1rtyj29qj8a3bao9bfx;
ALTER TABLE IF EXISTS ONLY dictionary_schema.priority DROP CONSTRAINT IF EXISTS uk639erqxmw75u6kt3lfksougmb;
ALTER TABLE IF EXISTS ONLY dictionary_schema.marital_status DROP CONSTRAINT IF EXISTS uk2pst8q940ve55w5fcb8rals9t;
ALTER TABLE IF EXISTS ONLY dictionary_schema.profile_attribute DROP CONSTRAINT IF EXISTS uk15s1544boy61ldqmww1udf0wm;
ALTER TABLE IF EXISTS ONLY dictionary_schema.status DROP CONSTRAINT IF EXISTS status_pkey;
ALTER TABLE IF EXISTS ONLY dictionary_schema.status_category DROP CONSTRAINT IF EXISTS status_category_pkey;
ALTER TABLE IF EXISTS ONLY dictionary_schema.profile_attribute DROP CONSTRAINT IF EXISTS profile_attribute_pkey;
ALTER TABLE IF EXISTS ONLY dictionary_schema.priority DROP CONSTRAINT IF EXISTS priority_pkey;
ALTER TABLE IF EXISTS ONLY dictionary_schema.notification_template DROP CONSTRAINT IF EXISTS notification_template_pkey;
ALTER TABLE IF EXISTS ONLY dictionary_schema.nationality DROP CONSTRAINT IF EXISTS nationality_pkey;
ALTER TABLE IF EXISTS ONLY dictionary_schema.marital_status DROP CONSTRAINT IF EXISTS marital_status_pkey;
ALTER TABLE IF EXISTS ONLY dictionary_schema.gender DROP CONSTRAINT IF EXISTS gender_pkey;
ALTER TABLE IF EXISTS ONLY dictionary_schema.entity_type DROP CONSTRAINT IF EXISTS entity_type_pkey;
ALTER TABLE IF EXISTS ONLY dictionary_schema.currency DROP CONSTRAINT IF EXISTS currency_pkey;
ALTER TABLE IF EXISTS ONLY dictionary_schema.color DROP CONSTRAINT IF EXISTS color_pkey;
ALTER TABLE IF EXISTS ONLY dictionary_schema.boolean_type DROP CONSTRAINT IF EXISTS boolean_type_pkey;
ALTER TABLE IF EXISTS ONLY contact_schema.contact_type DROP CONSTRAINT IF EXISTS uk6xkkjn2v20dl07mev8umc1ism;
ALTER TABLE IF EXISTS ONLY contact_schema.phone DROP CONSTRAINT IF EXISTS phone_pkey;
ALTER TABLE IF EXISTS ONLY contact_schema.email DROP CONSTRAINT IF EXISTS email_pkey;
ALTER TABLE IF EXISTS ONLY contact_schema.contact_type DROP CONSTRAINT IF EXISTS contact_type_pkey;
ALTER TABLE IF EXISTS ONLY contact_schema.contact DROP CONSTRAINT IF EXISTS contact_pkey;
ALTER TABLE IF EXISTS ONLY citizenship_schema.citizenship DROP CONSTRAINT IF EXISTS citizenship_pkey;
ALTER TABLE IF EXISTS ONLY authorization_schema.user_role DROP CONSTRAINT IF EXISTS user_role_pkey;
ALTER TABLE IF EXISTS ONLY authorization_schema."user" DROP CONSTRAINT IF EXISTS user_pkey;
ALTER TABLE IF EXISTS ONLY authorization_schema.role DROP CONSTRAINT IF EXISTS role_pkey;
ALTER TABLE IF EXISTS ONLY authorization_schema.role_menu DROP CONSTRAINT IF EXISTS role_menu_pkey;
ALTER TABLE IF EXISTS ONLY authorization_schema.permission DROP CONSTRAINT IF EXISTS permission_pkey;
DROP TABLE IF EXISTS work_schedule_schema.work_schedule;
DROP TABLE IF EXISTS user_schema."user";
DROP TABLE IF EXISTS user_schema.profile;
DROP TABLE IF EXISTS user_schema.authentication;
DROP TABLE IF EXISTS ui_schema.component_attributes;
DROP TABLE IF EXISTS ui_schema.component;
DROP TABLE IF EXISTS ui_schema.attribute;
DROP TABLE IF EXISTS testing_schema.test_session;
DROP TABLE IF EXISTS testing_schema.test;
DROP TABLE IF EXISTS testing_schema.selected_answer;
DROP TABLE IF EXISTS testing_schema.question_type;
DROP TABLE IF EXISTS testing_schema.question;
DROP TABLE IF EXISTS testing_schema.answer_submission;
DROP TABLE IF EXISTS testing_schema.selectedAnswer;
DROP TABLE IF EXISTS system_schema.service_provider_type;
DROP TABLE IF EXISTS system_schema.service_provider;
DROP TABLE IF EXISTS system_schema.notification_type;
DROP TABLE IF EXISTS system_schema.notification;
DROP TABLE IF EXISTS system_schema.message_type;
DROP TABLE IF EXISTS system_schema.message;
DROP TABLE IF EXISTS system_schema.environment_variable;
DROP TABLE IF EXISTS state_schema.entity_state;
DROP TABLE IF EXISTS resource_schema.resource;
DROP TABLE IF EXISTS recruitment_schema.vacancy;
DROP TABLE IF EXISTS recruitment_schema.skill;
DROP TABLE IF EXISTS recruitment_schema.interviewer;
DROP TABLE IF EXISTS recruitment_schema.interviewee;
DROP TABLE IF EXISTS recruitment_schema.interview_type;
DROP TABLE IF EXISTS recruitment_schema.interview_evaluation_section;
DROP TABLE IF EXISTS recruitment_schema.interview_evaluation_question;
DROP TABLE IF EXISTS recruitment_schema.interview_evaluation_answer;
DROP TABLE IF EXISTS recruitment_schema.interview_evaluation;
DROP TABLE IF EXISTS recruitment_schema.interview;
DROP TABLE IF EXISTS recruitment_schema.experience;
DROP TABLE IF EXISTS recruitment_schema.duty;
DROP TABLE IF EXISTS recruitment_schema.candidate_work_experience;
DROP TABLE IF EXISTS recruitment_schema.candidate_resource_type;
DROP TABLE IF EXISTS recruitment_schema.candidate_resource;
DROP TABLE IF EXISTS recruitment_schema.candidate_military_service;
DROP TABLE IF EXISTS recruitment_schema.candidate_identification_document;
DROP TABLE IF EXISTS recruitment_schema.candidate_education;
DROP TABLE IF EXISTS recruitment_schema.candidate_contact;
DROP TABLE IF EXISTS recruitment_schema.candidate_citizenship;
DROP TABLE IF EXISTS recruitment_schema.candidate_address;
DROP TABLE IF EXISTS recruitment_schema.candidate;
DROP SEQUENCE IF EXISTS public.resource_seq;
DROP SEQUENCE IF EXISTS public.order_seq;
DROP SEQUENCE IF EXISTS public.oder_seq;
DROP SEQUENCE IF EXISTS public.contact_seq;
DROP SEQUENCE IF EXISTS public.address_seq;
DROP TABLE IF EXISTS organization_schema.work_schedule;
DROP TABLE IF EXISTS organization_schema.responsibility;
DROP TABLE IF EXISTS organization_schema.required_experience;
DROP TABLE IF EXISTS organization_schema.reporting_line_type;
DROP TABLE IF EXISTS organization_schema.reporting_line;
DROP TABLE IF EXISTS organization_schema.qualification;
DROP TABLE IF EXISTS organization_schema."position";
DROP TABLE IF EXISTS organization_schema.organization_unit;
DROP TABLE IF EXISTS organization_schema.organization_contact;
DROP TABLE IF EXISTS organization_schema.organization_address;
DROP TABLE IF EXISTS organization_schema.organization;
DROP TABLE IF EXISTS organization_schema.key_performance_indicator;
DROP TABLE IF EXISTS organization_schema.job_description;
DROP TABLE IF EXISTS organization_schema.grade_step;
DROP TABLE IF EXISTS organization_schema.grade_level;
DROP TABLE IF EXISTS organization_schema.grade;
DROP TABLE IF EXISTS organization_schema.separationReason;
DROP TABLE IF EXISTS organization_schema.authority;
DROP TABLE IF EXISTS organization_schema.accountability;
DROP TABLE IF EXISTS navigation_schema.public_url;
DROP TABLE IF EXISTS navigation_schema.navigation_unit;
DROP TABLE IF EXISTS navigation_schema.menu_transition;
DROP TABLE IF EXISTS navigation_schema.menu_configuration;
DROP TABLE IF EXISTS navigation_schema.menu_action_transition;
DROP TABLE IF EXISTS navigation_schema.menu_action_form_component;
DROP TABLE IF EXISTS navigation_schema.menu_action;
DROP TABLE IF EXISTS navigation_schema.menu;
DROP TABLE IF EXISTS navigation_schema.form_components;
DROP TABLE IF EXISTS navigation_schema.form_component_attributes;
DROP TABLE IF EXISTS navigation_schema.configuration;
DROP TABLE IF EXISTS navigation_schema.action_type;
DROP TABLE IF EXISTS navigation_schema.action_category;
DROP TABLE IF EXISTS navigation_schema.action;
DROP TABLE IF EXISTS military_schema.military_service_resource;
DROP TABLE IF EXISTS military_schema.military_service;
DROP TABLE IF EXISTS location_schema.region;
DROP TABLE IF EXISTS location_schema.district;
DROP TABLE IF EXISTS location_schema.country;
DROP TABLE IF EXISTS location_schema.city;
DROP TABLE IF EXISTS location_schema.area_type;
DROP TABLE IF EXISTS location_schema.address_type;
DROP TABLE IF EXISTS location_schema.address;
DROP TABLE IF EXISTS localization_schema.layout_label_detail;
DROP TABLE IF EXISTS localization_schema.layout_label;
DROP TABLE IF EXISTS localization_schema.language;
DROP TABLE IF EXISTS identification_schema.identification_document_type;
DROP TABLE IF EXISTS identification_schema.identification_document;
DROP TABLE IF EXISTS employment_schema.work_experience;
DROP TABLE IF EXISTS employment_schema.employment_type;
DROP TABLE IF EXISTS employee_schema.vacation_type;
DROP TABLE IF EXISTS employee_schema.vacation_category;
DROP TABLE IF EXISTS employee_schema.vacation;
DROP TABLE IF EXISTS employee_schema.subordinate_type;
DROP TABLE IF EXISTS employee_schema.subordinate;
DROP TABLE IF EXISTS employee_schema.relative_contact;
DROP TABLE IF EXISTS employee_schema.relative_address;
DROP TABLE IF EXISTS employee_schema.relative;
DROP TABLE IF EXISTS employee_schema.relation_type;
DROP TABLE IF EXISTS employee_schema.performance_type;
DROP TABLE IF EXISTS employee_schema.performance_goal;
DROP TABLE IF EXISTS employee_schema.performance;
DROP TABLE IF EXISTS employee_schema.order_type;
DROP TABLE IF EXISTS employee_schema.order_resource;
DROP TABLE IF EXISTS employee_schema."order";
DROP TABLE IF EXISTS employee_schema.military_service_resource;
DROP TABLE IF EXISTS employee_schema.military_data;
DROP TABLE IF EXISTS employee_schema.improvement_area;
DROP TABLE IF EXISTS employee_schema.identification_document_resource;
DROP TABLE IF EXISTS employee_schema.employment_history_order;
DROP TABLE IF EXISTS employee_schema.employment_history;
DROP TABLE IF EXISTS employee_schema.employee_work_experience;
DROP TABLE IF EXISTS employee_schema.employee_resource;
DROP TABLE IF EXISTS employee_schema.employee_military_service;
DROP TABLE IF EXISTS employee_schema.employee_identification_document;
DROP TABLE IF EXISTS employee_schema.employee_education;
DROP TABLE IF EXISTS employee_schema.employee_contact;
DROP TABLE IF EXISTS employee_schema.employee_citizenship;
DROP TABLE IF EXISTS employee_schema.employee_address;
DROP TABLE IF EXISTS employee_schema.employee;
DROP TABLE IF EXISTS employee_schema.degree_type;
DROP TABLE IF EXISTS employee_schema.citizenship;
DROP TABLE IF EXISTS employee_schema.category;
DROP TABLE IF EXISTS employee_schema.business_trip_type;
DROP TABLE IF EXISTS employee_schema.business_trip_resource;
DROP TABLE IF EXISTS employee_schema.business_trip_order;
DROP TABLE IF EXISTS employee_schema.business_trip;
DROP TABLE IF EXISTS employee_schema.attendance;
DROP TABLE IF EXISTS employee_schema.agreement_resource;
DROP TABLE IF EXISTS employee_schema.agreement;
DROP TABLE IF EXISTS employee_schema.absence_type;
DROP TABLE IF EXISTS employee_schema.absence;
DROP TABLE IF EXISTS education_schema.grade_point_average;
DROP TABLE IF EXISTS education_schema.education_type;
DROP TABLE IF EXISTS education_schema.education_resource;
DROP TABLE IF EXISTS education_schema.education_document_type;
DROP TABLE IF EXISTS education_schema.education;
DROP TABLE IF EXISTS education_schema.degree_type;
DROP TABLE IF EXISTS education_schema.accreditation_status;
DROP TABLE IF EXISTS dictionary_schema.week_day;
DROP TABLE IF EXISTS dictionary_schema.status_category;
DROP TABLE IF EXISTS dictionary_schema.status;
DROP TABLE IF EXISTS dictionary_schema.profile_attribute;
DROP TABLE IF EXISTS dictionary_schema.priority;
DROP TABLE IF EXISTS dictionary_schema.notification_template;
DROP TABLE IF EXISTS dictionary_schema.nationality;
DROP TABLE IF EXISTS dictionary_schema.marital_status;
DROP TABLE IF EXISTS dictionary_schema.gender;
DROP TABLE IF EXISTS dictionary_schema.entity_type;
DROP TABLE IF EXISTS dictionary_schema.currency;
DROP TABLE IF EXISTS dictionary_schema.color;
DROP TABLE IF EXISTS dictionary_schema.boolean_type;
DROP TABLE IF EXISTS contact_schema.phone;
DROP TABLE IF EXISTS contact_schema.email;
DROP TABLE IF EXISTS contact_schema.contact_type;
DROP TABLE IF EXISTS contact_schema.contact;
DROP TABLE IF EXISTS citizenship_schema.citizenship;
DROP TABLE IF EXISTS authorization_schema.user_role;
DROP TABLE IF EXISTS authorization_schema."user";
DROP TABLE IF EXISTS authorization_schema.role_menu;
DROP TABLE IF EXISTS authorization_schema.role;
DROP TABLE IF EXISTS authorization_schema.permission;
DROP SCHEMA IF EXISTS work_schedule_schema;
DROP SCHEMA IF EXISTS user_schema;
DROP SCHEMA IF EXISTS ui_schema;
DROP SCHEMA IF EXISTS testing_schema;
DROP SCHEMA IF EXISTS system_schema;
DROP SCHEMA IF EXISTS state_schema;
DROP SCHEMA IF EXISTS resource_schema;
DROP SCHEMA IF EXISTS recruitment_schema;
DROP SCHEMA IF EXISTS organization_schema;
DROP SCHEMA IF EXISTS navigation_schema;
DROP SCHEMA IF EXISTS military_schema;
DROP SCHEMA IF EXISTS location_schema;
DROP SCHEMA IF EXISTS localization_schema;
DROP SCHEMA IF EXISTS identification_schema;
DROP SCHEMA IF EXISTS employment_schema;
DROP SCHEMA IF EXISTS employee_schema;
DROP SCHEMA IF EXISTS education_schema;
DROP SCHEMA IF EXISTS dictionary_schema;
DROP SCHEMA IF EXISTS contact_schema;
DROP SCHEMA IF EXISTS citizenship_schema;
DROP SCHEMA IF EXISTS authorization_schema;
--
-- Name: authorization_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA authorization_schema;


ALTER SCHEMA authorization_schema OWNER TO fractal;

--
-- Name: citizenship_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA citizenship_schema;


ALTER SCHEMA citizenship_schema OWNER TO fractal;

--
-- Name: contact_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA contact_schema;


ALTER SCHEMA contact_schema OWNER TO fractal;

--
-- Name: dictionary_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA dictionary_schema;


ALTER SCHEMA dictionary_schema OWNER TO fractal;

--
-- Name: education_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA education_schema;


ALTER SCHEMA education_schema OWNER TO fractal;

--
-- Name: employee_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA employee_schema;


ALTER SCHEMA employee_schema OWNER TO fractal;

--
-- Name: employment_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA employment_schema;


ALTER SCHEMA employment_schema OWNER TO fractal;

--
-- Name: identification_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA identification_schema;


ALTER SCHEMA identification_schema OWNER TO fractal;

--
-- Name: localization_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA localization_schema;


ALTER SCHEMA localization_schema OWNER TO fractal;

--
-- Name: location_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA location_schema;


ALTER SCHEMA location_schema OWNER TO fractal;

--
-- Name: military_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA military_schema;


ALTER SCHEMA military_schema OWNER TO fractal;

--
-- Name: navigation_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA navigation_schema;


ALTER SCHEMA navigation_schema OWNER TO fractal;

--
-- Name: organization_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA organization_schema;


ALTER SCHEMA organization_schema OWNER TO fractal;

--
-- Name: recruitment_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA recruitment_schema;


ALTER SCHEMA recruitment_schema OWNER TO fractal;

--
-- Name: resource_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA resource_schema;


ALTER SCHEMA resource_schema OWNER TO fractal;

--
-- Name: state_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA state_schema;


ALTER SCHEMA state_schema OWNER TO fractal;

--
-- Name: system_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA system_schema;


ALTER SCHEMA system_schema OWNER TO fractal;

--
-- Name: testing_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA testing_schema;


ALTER SCHEMA testing_schema OWNER TO fractal;

--
-- Name: ui_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA ui_schema;


ALTER SCHEMA ui_schema OWNER TO fractal;

--
-- Name: user_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA user_schema;


ALTER SCHEMA user_schema OWNER TO fractal;

--
-- Name: work_schedule_schema; Type: SCHEMA; Schema: -; Owner: fractal
--

CREATE SCHEMA work_schedule_schema;


ALTER SCHEMA work_schedule_schema OWNER TO fractal;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: permission; Type: TABLE; Schema: authorization_schema; Owner: fractal
--

CREATE TABLE authorization_schema.permission (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    confirmed_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    confirmed_user_id bigint,
    menu_action_id bigint,
    role_id bigint NOT NULL,
    status_id bigint
);


ALTER TABLE authorization_schema.permission OWNER TO fractal;

--
-- Name: permission_id_seq; Type: SEQUENCE; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE authorization_schema.permission ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME authorization_schema.permission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: role; Type: TABLE; Schema: authorization_schema; Owner: fractal
--

CREATE TABLE authorization_schema.role (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(50),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE authorization_schema.role OWNER TO fractal;

--
-- Name: role_id_seq; Type: SEQUENCE; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE authorization_schema.role ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME authorization_schema.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: role_menu; Type: TABLE; Schema: authorization_schema; Owner: fractal
--

CREATE TABLE authorization_schema.role_menu (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    confirmed_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    confirmed_user_id bigint,
    menu_id bigint,
    role_id bigint,
    status_id bigint
);


ALTER TABLE authorization_schema.role_menu OWNER TO fractal;

--
-- Name: role_menu_id_seq; Type: SEQUENCE; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE authorization_schema.role_menu ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME authorization_schema.role_menu_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: user; Type: TABLE; Schema: authorization_schema; Owner: fractal
--

CREATE TABLE authorization_schema."user" (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    account_non_expired boolean NOT NULL,
    account_non_locked boolean NOT NULL,
    credentials_non_expired boolean NOT NULL,
    enabled boolean NOT NULL,
    password character varying(255),
    username character varying(50),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE authorization_schema."user" OWNER TO fractal;

--
-- Name: user_id_seq; Type: SEQUENCE; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE authorization_schema."user" ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME authorization_schema.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: user_role; Type: TABLE; Schema: authorization_schema; Owner: fractal
--

CREATE TABLE authorization_schema.user_role (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    role_id bigint,
    user_id bigint,
    status_id bigint
);


ALTER TABLE authorization_schema.user_role OWNER TO fractal;

--
-- Name: user_role_id_seq; Type: SEQUENCE; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE authorization_schema.user_role ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME authorization_schema.user_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: citizenship; Type: TABLE; Schema: citizenship_schema; Owner: fractal
--

CREATE TABLE citizenship_schema.citizenship (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    country_id bigint
);


ALTER TABLE citizenship_schema.citizenship OWNER TO fractal;

--
-- Name: citizenship_id_seq; Type: SEQUENCE; Schema: citizenship_schema; Owner: fractal
--

ALTER TABLE citizenship_schema.citizenship ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME citizenship_schema.citizenship_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: contact; Type: TABLE; Schema: contact_schema; Owner: fractal
--

CREATE TABLE contact_schema.contact (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    value character varying(255),
    contact_type_id bigint
);


ALTER TABLE contact_schema.contact OWNER TO fractal;

--
-- Name: contact_type; Type: TABLE; Schema: contact_schema; Owner: fractal
--

CREATE TABLE contact_schema.contact_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE contact_schema.contact_type OWNER TO fractal;

--
-- Name: contact_type_id_seq; Type: SEQUENCE; Schema: contact_schema; Owner: fractal
--

ALTER TABLE contact_schema.contact_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME contact_schema.contact_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: email; Type: TABLE; Schema: contact_schema; Owner: fractal
--

CREATE TABLE contact_schema.email (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    address character varying(255)
);


ALTER TABLE contact_schema.email OWNER TO fractal;

--
-- Name: phone; Type: TABLE; Schema: contact_schema; Owner: fractal
--

CREATE TABLE contact_schema.phone (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    number character varying(255),
    country_id bigint
);


ALTER TABLE contact_schema.phone OWNER TO fractal;

--
-- Name: boolean_type; Type: TABLE; Schema: dictionary_schema; Owner: fractal
--

CREATE TABLE dictionary_schema.boolean_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    value integer,
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE dictionary_schema.boolean_type OWNER TO fractal;

--
-- Name: boolean_type_id_seq; Type: SEQUENCE; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE dictionary_schema.boolean_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME dictionary_schema.boolean_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: color; Type: TABLE; Schema: dictionary_schema; Owner: fractal
--

CREATE TABLE dictionary_schema.color (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE dictionary_schema.color OWNER TO fractal;

--
-- Name: color_id_seq; Type: SEQUENCE; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE dictionary_schema.color ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME dictionary_schema.color_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: currency; Type: TABLE; Schema: dictionary_schema; Owner: fractal
--

CREATE TABLE dictionary_schema.currency (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    numeric_code integer,
    created_user_id bigint,
    updated_user_id bigint,
    country_id bigint
);


ALTER TABLE dictionary_schema.currency OWNER TO fractal;

--
-- Name: currency_id_seq; Type: SEQUENCE; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE dictionary_schema.currency ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME dictionary_schema.currency_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: entity_type; Type: TABLE; Schema: dictionary_schema; Owner: fractal
--

CREATE TABLE dictionary_schema.entity_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    source character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE dictionary_schema.entity_type OWNER TO fractal;

--
-- Name: entity_type_id_seq; Type: SEQUENCE; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE dictionary_schema.entity_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME dictionary_schema.entity_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: gender; Type: TABLE; Schema: dictionary_schema; Owner: fractal
--

CREATE TABLE dictionary_schema.gender (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE dictionary_schema.gender OWNER TO fractal;

--
-- Name: gender_id_seq; Type: SEQUENCE; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE dictionary_schema.gender ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME dictionary_schema.gender_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: marital_status; Type: TABLE; Schema: dictionary_schema; Owner: fractal
--

CREATE TABLE dictionary_schema.marital_status (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE dictionary_schema.marital_status OWNER TO fractal;

--
-- Name: marital_status_id_seq; Type: SEQUENCE; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE dictionary_schema.marital_status ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME dictionary_schema.marital_status_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: nationality; Type: TABLE; Schema: dictionary_schema; Owner: fractal
--

CREATE TABLE dictionary_schema.nationality (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE dictionary_schema.nationality OWNER TO fractal;

--
-- Name: nationality_id_seq; Type: SEQUENCE; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE dictionary_schema.nationality ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME dictionary_schema.nationality_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: notification_template; Type: TABLE; Schema: dictionary_schema; Owner: fractal
--

CREATE TABLE dictionary_schema.notification_template (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    description character varying(255),
    key_words character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE dictionary_schema.notification_template OWNER TO fractal;

--
-- Name: notification_template_id_seq; Type: SEQUENCE; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE dictionary_schema.notification_template ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME dictionary_schema.notification_template_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: priority; Type: TABLE; Schema: dictionary_schema; Owner: fractal
--

CREATE TABLE dictionary_schema.priority (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE dictionary_schema.priority OWNER TO fractal;

--
-- Name: priority_id_seq; Type: SEQUENCE; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE dictionary_schema.priority ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME dictionary_schema.priority_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: profile_attribute; Type: TABLE; Schema: dictionary_schema; Owner: fractal
--

CREATE TABLE dictionary_schema.profile_attribute (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE dictionary_schema.profile_attribute OWNER TO fractal;

--
-- Name: profile_attribute_id_seq; Type: SEQUENCE; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE dictionary_schema.profile_attribute ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME dictionary_schema.profile_attribute_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: status; Type: TABLE; Schema: dictionary_schema; Owner: fractal
--

CREATE TABLE dictionary_schema.status (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    description character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    status_category_id bigint
);


ALTER TABLE dictionary_schema.status OWNER TO fractal;

--
-- Name: status_category; Type: TABLE; Schema: dictionary_schema; Owner: fractal
--

CREATE TABLE dictionary_schema.status_category (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE dictionary_schema.status_category OWNER TO fractal;

--
-- Name: status_category_id_seq; Type: SEQUENCE; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE dictionary_schema.status_category ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME dictionary_schema.status_category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: status_id_seq; Type: SEQUENCE; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE dictionary_schema.status ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME dictionary_schema.status_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: week_day; Type: TABLE; Schema: dictionary_schema; Owner: fractal
--

CREATE TABLE dictionary_schema.week_day (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    index bigint,
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE dictionary_schema.week_day OWNER TO fractal;

--
-- Name: week_day_id_seq; Type: SEQUENCE; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE dictionary_schema.week_day ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME dictionary_schema.week_day_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: accreditation_status; Type: TABLE; Schema: education_schema; Owner: fractal
--

CREATE TABLE education_schema.accreditation_status (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE education_schema.accreditation_status OWNER TO fractal;

--
-- Name: accreditation_status_id_seq; Type: SEQUENCE; Schema: education_schema; Owner: fractal
--

ALTER TABLE education_schema.accreditation_status ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME education_schema.accreditation_status_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: degree_type; Type: TABLE; Schema: education_schema; Owner: fractal
--

CREATE TABLE education_schema.degree_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE education_schema.degree_type OWNER TO fractal;

--
-- Name: degree_type_id_seq; Type: SEQUENCE; Schema: education_schema; Owner: fractal
--

ALTER TABLE education_schema.degree_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME education_schema.degree_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: education; Type: TABLE; Schema: education_schema; Owner: fractal
--

CREATE TABLE education_schema.education (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    begin_date date,
    document_verified boolean,
    end_date date,
    institution_address character varying(255),
    institution_name character varying(255),
    is_foreign_institution boolean,
    specialization character varying(255),
    verification_notes character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    accreditation_status_id bigint,
    degree_type_id bigint,
    education_document_type_id bigint,
    education_type_id bigint,
    grade_point_average_id bigint,
    status_id bigint
);


ALTER TABLE education_schema.education OWNER TO fractal;

--
-- Name: education_document_type; Type: TABLE; Schema: education_schema; Owner: fractal
--

CREATE TABLE education_schema.education_document_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE education_schema.education_document_type OWNER TO fractal;

--
-- Name: education_document_type_id_seq; Type: SEQUENCE; Schema: education_schema; Owner: fractal
--

ALTER TABLE education_schema.education_document_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME education_schema.education_document_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: education_id_seq; Type: SEQUENCE; Schema: education_schema; Owner: fractal
--

ALTER TABLE education_schema.education ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME education_schema.education_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: education_resource; Type: TABLE; Schema: education_schema; Owner: fractal
--

CREATE TABLE education_schema.education_resource (
    id bigint NOT NULL,
    education_id bigint
);


ALTER TABLE education_schema.education_resource OWNER TO fractal;

--
-- Name: education_type; Type: TABLE; Schema: education_schema; Owner: fractal
--

CREATE TABLE education_schema.education_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE education_schema.education_type OWNER TO fractal;

--
-- Name: education_type_id_seq; Type: SEQUENCE; Schema: education_schema; Owner: fractal
--

ALTER TABLE education_schema.education_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME education_schema.education_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: grade_point_average; Type: TABLE; Schema: education_schema; Owner: fractal
--

CREATE TABLE education_schema.grade_point_average (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    scale double precision,
    value character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE education_schema.grade_point_average OWNER TO fractal;

--
-- Name: grade_point_average_id_seq; Type: SEQUENCE; Schema: education_schema; Owner: fractal
--

ALTER TABLE education_schema.grade_point_average ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME education_schema.grade_point_average_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: absence; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.absence (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    duration integer,
    end_date date,
    reason character varying(255),
    remarks character varying(255),
    start_date date,
    created_user_id bigint,
    updated_user_id bigint,
    absence_type_id bigint,
    employee_id bigint
);


ALTER TABLE employee_schema.absence OWNER TO fractal;

--
-- Name: absence_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.absence ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.absence_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: absence_type; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.absence_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE employee_schema.absence_type OWNER TO fractal;

--
-- Name: absence_type_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.absence_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.absence_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: agreement; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.agreement (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    end_date date,
    number character varying(255),
    start_date date,
    created_user_id bigint,
    updated_user_id bigint,
    employment_history_id bigint,
    status_id bigint
);


ALTER TABLE employee_schema.agreement OWNER TO fractal;

--
-- Name: agreement_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.agreement ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.agreement_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: agreement_resource; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.agreement_resource (
    id bigint NOT NULL,
    agreement_id bigint
);


ALTER TABLE employee_schema.agreement_resource OWNER TO fractal;

--
-- Name: attendance; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.attendance (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    date date,
    end_time time(6) without time zone,
    hours_worked integer,
    overtime_hours integer,
    remarks character varying(255),
    start_time time(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    employee_id bigint,
    status_id bigint
);


ALTER TABLE employee_schema.attendance OWNER TO fractal;

--
-- Name: attendance_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.attendance ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.attendance_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: business_trip; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.business_trip (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    description character varying(1000),
    end_date date,
    order_date date,
    order_number character varying(255),
    start_date date,
    created_user_id bigint,
    updated_user_id bigint,
    employee_id bigint,
    organization_id bigint,
    status_id bigint,
    approved_date timestamp(6) without time zone,
    reviewed_date timestamp(6) without time zone,
    days integer,
    location character varying(1000),
    purpose character varying(5000),
    approved_user_id bigint,
    reviewed_user_id bigint,
    business_trip_type_id bigint
);


ALTER TABLE employee_schema.business_trip OWNER TO fractal;

--
-- Name: business_trip_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.business_trip ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.business_trip_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: business_trip_order; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.business_trip_order (
    number bigint,
    id bigint NOT NULL,
    business_trip_id bigint
);


ALTER TABLE employee_schema.business_trip_order OWNER TO fractal;

--
-- Name: business_trip_resource; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.business_trip_resource (
    id bigint NOT NULL,
    business_trip_id bigint
);


ALTER TABLE employee_schema.business_trip_resource OWNER TO fractal;

--
-- Name: business_trip_type; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.business_trip_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    description character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE employee_schema.business_trip_type OWNER TO fractal;

--
-- Name: business_trip_type_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.business_trip_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.business_trip_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: category; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.category (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    index bigint
);


ALTER TABLE employee_schema.category OWNER TO fractal;

--
-- Name: category_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.category ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: citizenship; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.citizenship (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    country_id bigint
);


ALTER TABLE employee_schema.citizenship OWNER TO fractal;

--
-- Name: citizenship_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.citizenship ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.citizenship_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: degree_type; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.degree_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE employee_schema.degree_type OWNER TO fractal;

--
-- Name: degree_type_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.degree_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.degree_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: employee; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.employee (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    birth_date date,
    first_name character varying(255),
    last_name character varying(255),
    patronymic_name character varying(255),
    ssn character varying(255),
    tin character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    country_id bigint,
    employee_id bigint,
    gender_id bigint,
    marital_status_id bigint,
    nationality_id bigint,
    status_id bigint
);


ALTER TABLE employee_schema.employee OWNER TO fractal;

--
-- Name: employee_address; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.employee_address (
    id bigint NOT NULL,
    employee_id bigint
);


ALTER TABLE employee_schema.employee_address OWNER TO fractal;

--
-- Name: employee_citizenship; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.employee_citizenship (
    id bigint NOT NULL,
    employee_id bigint
);


ALTER TABLE employee_schema.employee_citizenship OWNER TO fractal;

--
-- Name: employee_contact; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.employee_contact (
    id bigint NOT NULL,
    employee_id bigint
);


ALTER TABLE employee_schema.employee_contact OWNER TO fractal;

--
-- Name: employee_education; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.employee_education (
    id bigint NOT NULL,
    employee_id bigint
);


ALTER TABLE employee_schema.employee_education OWNER TO fractal;

--
-- Name: employee_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.employee ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: employee_identification_document; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.employee_identification_document (
    id bigint NOT NULL,
    employee_id bigint
);


ALTER TABLE employee_schema.employee_identification_document OWNER TO fractal;

--
-- Name: employee_military_service; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.employee_military_service (
    id bigint NOT NULL,
    employee_id bigint
);


ALTER TABLE employee_schema.employee_military_service OWNER TO fractal;

--
-- Name: employee_resource; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.employee_resource (
    id bigint NOT NULL,
    employee_id bigint
);


ALTER TABLE employee_schema.employee_resource OWNER TO fractal;

--
-- Name: employee_work_experience; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.employee_work_experience (
    id bigint NOT NULL,
    employee_id bigint
);


ALTER TABLE employee_schema.employee_work_experience OWNER TO fractal;

--
-- Name: employment_history; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.employment_history (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    end_date date,
    order_date date,
    order_number character varying(255),
    serial integer,
    start_date date,
    created_user_id bigint,
    updated_user_id bigint,
    department_id bigint,
    employee_id bigint,
    employment_type_id bigint,
    organization_id bigint,
    position_id bigint,
    status_id bigint
);


ALTER TABLE employee_schema.employment_history OWNER TO fractal;

--
-- Name: employment_history_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.employment_history ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.employment_history_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: employment_history_order; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.employment_history_order (
    number bigint,
    id bigint NOT NULL,
    employment_history_id bigint
);


ALTER TABLE employee_schema.employment_history_order OWNER TO fractal;

--
-- Name: identification_document_resource; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.identification_document_resource (
    id bigint NOT NULL,
    identification_document_id bigint
);


ALTER TABLE employee_schema.identification_document_resource OWNER TO fractal;

--
-- Name: improvement_area; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.improvement_area (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    action_plan character varying(255),
    area_name character varying(255) NOT NULL,
    description character varying(255),
    target_date date,
    created_user_id bigint,
    updated_user_id bigint,
    performance_id bigint,
    status_id bigint
);


ALTER TABLE employee_schema.improvement_area OWNER TO fractal;

--
-- Name: improvement_area_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.improvement_area ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.improvement_area_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: military_data; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.military_data (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    account_number character varying(255),
    address character varying(255),
    begin_date date,
    category_fund character varying(255),
    end_date date,
    image character varying(255),
    title character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    employee_id bigint
);


ALTER TABLE employee_schema.military_data OWNER TO fractal;

--
-- Name: military_data_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.military_data ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.military_data_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: military_service_resource; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.military_service_resource (
    id bigint NOT NULL,
    military_service_id bigint
);


ALTER TABLE employee_schema.military_service_resource OWNER TO fractal;

--
-- Name: order; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema."order" (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    approved_date timestamp(6) without time zone,
    reviewed_date timestamp(6) without time zone,
    date date,
    created_user_id bigint,
    updated_user_id bigint,
    approved_user_id bigint,
    reviewed_user_id bigint,
    order_type_id bigint
);


ALTER TABLE employee_schema."order" OWNER TO fractal;

--
-- Name: order_resource; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.order_resource (
    id bigint NOT NULL,
    order_id bigint
);


ALTER TABLE employee_schema.order_resource OWNER TO fractal;

--
-- Name: order_type; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.order_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    description character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE employee_schema.order_type OWNER TO fractal;

--
-- Name: order_type_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.order_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.order_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: performance; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.performance (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    comments character varying(2000),
    date date NOT NULL,
    rating integer NOT NULL,
    review_period_end date NOT NULL,
    review_period_start date NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    employee_id bigint,
    performance_type_id bigint,
    reviewer_employee_id bigint,
    status_id bigint
);


ALTER TABLE employee_schema.performance OWNER TO fractal;

--
-- Name: performance_goal; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.performance_goal (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    goal_achieved boolean,
    achievement_date date,
    description character varying(255) NOT NULL,
    remarks character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    performance_id bigint
);


ALTER TABLE employee_schema.performance_goal OWNER TO fractal;

--
-- Name: performance_goal_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.performance_goal ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.performance_goal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: performance_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.performance ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.performance_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: performance_type; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.performance_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE employee_schema.performance_type OWNER TO fractal;

--
-- Name: performance_type_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.performance_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.performance_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: relation_type; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.relation_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE employee_schema.relation_type OWNER TO fractal;

--
-- Name: relation_type_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.relation_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.relation_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: relative; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.relative (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    birth_date date,
    first_name character varying(255),
    last_name character varying(255),
    patronymic_name character varying(255),
    ssn character varying(255),
    tin character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    gender_id bigint,
    marital_status_id bigint,
    nationality_id bigint,
    employee_id bigint,
    relation_type_id bigint
);


ALTER TABLE employee_schema.relative OWNER TO fractal;

--
-- Name: relative_address; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.relative_address (
    id bigint NOT NULL,
    relative_id bigint
);


ALTER TABLE employee_schema.relative_address OWNER TO fractal;

--
-- Name: relative_contact; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.relative_contact (
    id bigint NOT NULL,
    relative_id bigint
);


ALTER TABLE employee_schema.relative_contact OWNER TO fractal;

--
-- Name: relative_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.relative ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.relative_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: subordinate; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.subordinate (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    end_date date,
    start_date date,
    created_user_id bigint,
    updated_user_id bigint,
    employee_id bigint,
    status_id bigint,
    subordinate_employee_id bigint,
    subordinate_type_id bigint
);


ALTER TABLE employee_schema.subordinate OWNER TO fractal;

--
-- Name: subordinate_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.subordinate ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.subordinate_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: subordinate_type; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.subordinate_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE employee_schema.subordinate_type OWNER TO fractal;

--
-- Name: subordinate_type_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.subordinate_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.subordinate_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: vacation; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.vacation (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    description character varying(255),
    end_date date,
    order_date date,
    order_number character varying(255),
    start_date date,
    created_user_id bigint,
    updated_user_id bigint,
    employee_id bigint,
    status_id bigint,
    successor_employee_id bigint,
    vacation_category_id bigint,
    vacation_type_id bigint,
    days integer
);


ALTER TABLE employee_schema.vacation OWNER TO fractal;

--
-- Name: vacation_category; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.vacation_category (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    description character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE employee_schema.vacation_category OWNER TO fractal;

--
-- Name: vacation_category_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.vacation_category ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.vacation_category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: vacation_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.vacation ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.vacation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: vacation_type; Type: TABLE; Schema: employee_schema; Owner: fractal
--

CREATE TABLE employee_schema.vacation_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    description character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE employee_schema.vacation_type OWNER TO fractal;

--
-- Name: vacation_type_id_seq; Type: SEQUENCE; Schema: employee_schema; Owner: fractal
--

ALTER TABLE employee_schema.vacation_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employee_schema.vacation_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: employment_type; Type: TABLE; Schema: employment_schema; Owner: fractal
--

CREATE TABLE employment_schema.employment_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE employment_schema.employment_type OWNER TO fractal;

--
-- Name: employment_type_id_seq; Type: SEQUENCE; Schema: employment_schema; Owner: fractal
--

ALTER TABLE employment_schema.employment_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employment_schema.employment_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: work_experience; Type: TABLE; Schema: employment_schema; Owner: fractal
--

CREATE TABLE employment_schema.work_experience (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    end_date date,
    start_date date,
    achievements text,
    separationReason character varying(255),
    division character varying(255),
    leave_reason text,
    location character varying(255),
    organization character varying(255),
    "position" character varying(255),
    responsibilities text,
    created_user_id bigint,
    updated_user_id bigint,
    employment_type_id bigint,
    country_id bigint,
    status_id bigint
);


ALTER TABLE employment_schema.work_experience OWNER TO fractal;

--
-- Name: work_experience_id_seq; Type: SEQUENCE; Schema: employment_schema; Owner: fractal
--

ALTER TABLE employment_schema.work_experience ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME employment_schema.work_experience_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: identification_document; Type: TABLE; Schema: identification_schema; Owner: fractal
--

CREATE TABLE identification_schema.identification_document (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    expiry_date date,
    issue_date date,
    issue_organization character varying(255),
    issue_organization_address character varying(255),
    number integer,
    series character varying(255),
    term_in_years integer,
    created_user_id bigint,
    updated_user_id bigint,
    identification_type_id bigint,
    status_id bigint
);


ALTER TABLE identification_schema.identification_document OWNER TO fractal;

--
-- Name: identification_document_id_seq; Type: SEQUENCE; Schema: identification_schema; Owner: fractal
--

ALTER TABLE identification_schema.identification_document ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME identification_schema.identification_document_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: identification_document_type; Type: TABLE; Schema: identification_schema; Owner: fractal
--

CREATE TABLE identification_schema.identification_document_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE identification_schema.identification_document_type OWNER TO fractal;

--
-- Name: identification_document_type_id_seq; Type: SEQUENCE; Schema: identification_schema; Owner: fractal
--

ALTER TABLE identification_schema.identification_document_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME identification_schema.identification_document_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: language; Type: TABLE; Schema: localization_schema; Owner: fractal
--

CREATE TABLE localization_schema.language (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE localization_schema.language OWNER TO fractal;

--
-- Name: language_id_seq; Type: SEQUENCE; Schema: localization_schema; Owner: fractal
--

ALTER TABLE localization_schema.language ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME localization_schema.language_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: layout_label; Type: TABLE; Schema: localization_schema; Owner: fractal
--

CREATE TABLE localization_schema.layout_label (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE localization_schema.layout_label OWNER TO fractal;

--
-- Name: layout_label_detail; Type: TABLE; Schema: localization_schema; Owner: fractal
--

CREATE TABLE localization_schema.layout_label_detail (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    description character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    language_id bigint,
    layout_label_id bigint
);


ALTER TABLE localization_schema.layout_label_detail OWNER TO fractal;

--
-- Name: layout_label_detail_id_seq; Type: SEQUENCE; Schema: localization_schema; Owner: fractal
--

ALTER TABLE localization_schema.layout_label_detail ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME localization_schema.layout_label_detail_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: layout_label_id_seq; Type: SEQUENCE; Schema: localization_schema; Owner: fractal
--

ALTER TABLE localization_schema.layout_label ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME localization_schema.layout_label_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: address; Type: TABLE; Schema: location_schema; Owner: fractal
--

CREATE TABLE location_schema.address (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    apartment character varying(255),
    building_number character varying(255),
    end_date date,
    floor_number character varying(255),
    house character varying(255),
    latitude double precision,
    longitude double precision,
    postal_code character varying(255),
    start_date date,
    street character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    address_type_id bigint,
    city_id bigint,
    country_id bigint,
    district_id bigint,
    region_id bigint
);


ALTER TABLE location_schema.address OWNER TO fractal;

--
-- Name: address_type; Type: TABLE; Schema: location_schema; Owner: fractal
--

CREATE TABLE location_schema.address_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE location_schema.address_type OWNER TO fractal;

--
-- Name: address_type_id_seq; Type: SEQUENCE; Schema: location_schema; Owner: fractal
--

ALTER TABLE location_schema.address_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME location_schema.address_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: area_type; Type: TABLE; Schema: location_schema; Owner: fractal
--

CREATE TABLE location_schema.area_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE location_schema.area_type OWNER TO fractal;

--
-- Name: area_type_id_seq; Type: SEQUENCE; Schema: location_schema; Owner: fractal
--

ALTER TABLE location_schema.area_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME location_schema.area_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: city; Type: TABLE; Schema: location_schema; Owner: fractal
--

CREATE TABLE location_schema.city (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    region_id bigint,
    area_type_id bigint
);


ALTER TABLE location_schema.city OWNER TO fractal;

--
-- Name: city_id_seq; Type: SEQUENCE; Schema: location_schema; Owner: fractal
--

ALTER TABLE location_schema.city ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME location_schema.city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: country; Type: TABLE; Schema: location_schema; Owner: fractal
--

CREATE TABLE location_schema.country (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    iso3_code character varying(3),
    numeric_code integer,
    phone_prefix character varying(255) NOT NULL,
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE location_schema.country OWNER TO fractal;

--
-- Name: country_id_seq; Type: SEQUENCE; Schema: location_schema; Owner: fractal
--

ALTER TABLE location_schema.country ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME location_schema.country_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: district; Type: TABLE; Schema: location_schema; Owner: fractal
--

CREATE TABLE location_schema.district (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    city_id bigint,
    region_id bigint,
    area_type_id bigint
);


ALTER TABLE location_schema.district OWNER TO fractal;

--
-- Name: district_id_seq; Type: SEQUENCE; Schema: location_schema; Owner: fractal
--

ALTER TABLE location_schema.district ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME location_schema.district_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: region; Type: TABLE; Schema: location_schema; Owner: fractal
--

CREATE TABLE location_schema.region (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    country_id bigint
);


ALTER TABLE location_schema.region OWNER TO fractal;

--
-- Name: region_id_seq; Type: SEQUENCE; Schema: location_schema; Owner: fractal
--

ALTER TABLE location_schema.region ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME location_schema.region_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: military_service; Type: TABLE; Schema: military_schema; Owner: fractal
--

CREATE TABLE military_schema.military_service (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    account_number character varying(255),
    address character varying(255),
    begin_date date,
    category_fund character varying(255),
    end_date date,
    title character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE military_schema.military_service OWNER TO fractal;

--
-- Name: military_service_id_seq; Type: SEQUENCE; Schema: military_schema; Owner: fractal
--

ALTER TABLE military_schema.military_service ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME military_schema.military_service_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: military_service_resource; Type: TABLE; Schema: military_schema; Owner: fractal
--

CREATE TABLE military_schema.military_service_resource (
    id bigint NOT NULL,
    military_service_id bigint
);


ALTER TABLE military_schema.military_service_resource OWNER TO fractal;

--
-- Name: action; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.action (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    icon character varying(255),
    name character varying(255),
    url character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    action_category_id bigint,
    action_type_id bigint,
    layout_label_id bigint
);


ALTER TABLE navigation_schema.action OWNER TO fractal;

--
-- Name: action_category; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.action_category (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE navigation_schema.action_category OWNER TO fractal;

--
-- Name: action_category_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.action_category ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.action_category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: action_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.action ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.action_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: action_type; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.action_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE navigation_schema.action_type OWNER TO fractal;

--
-- Name: action_type_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.action_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.action_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: configuration; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.configuration (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE navigation_schema.configuration OWNER TO fractal;

--
-- Name: configuration_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.configuration ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.configuration_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: form_component_attributes; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.form_component_attributes (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    value character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    component_attribute_id bigint,
    form_component_id bigint,
    status_id bigint
);


ALTER TABLE navigation_schema.form_component_attributes OWNER TO fractal;

--
-- Name: form_component_attributes_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.form_component_attributes ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.form_component_attributes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: form_components; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.form_components (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    section character varying(255),
    sequence integer,
    source character varying(255),
    value character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    component_id bigint,
    layout_label_id bigint,
    status_id bigint
);


ALTER TABLE navigation_schema.form_components OWNER TO fractal;

--
-- Name: form_components_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.form_components ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.form_components_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: menu; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.menu (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    class_name character varying(255),
    icon character varying(255),
    level integer,
    name character varying(255),
    sequence integer,
    url character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    layout_label_id bigint,
    parent_id bigint
);


ALTER TABLE navigation_schema.menu OWNER TO fractal;

--
-- Name: menu_action; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.menu_action (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    is_active boolean,
    created_user_id bigint,
    updated_user_id bigint,
    action_id bigint,
    menu_id bigint,
    status_id bigint
);


ALTER TABLE navigation_schema.menu_action OWNER TO fractal;

--
-- Name: menu_action_form_component; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.menu_action_form_component (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    sequence integer,
    created_user_id bigint,
    updated_user_id bigint,
    form_component_id bigint,
    menu_action_id bigint,
    status_id bigint
);


ALTER TABLE navigation_schema.menu_action_form_component OWNER TO fractal;

--
-- Name: menu_action_form_component_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.menu_action_form_component ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.menu_action_form_component_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: menu_action_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.menu_action ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.menu_action_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: menu_action_transition; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.menu_action_transition (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    entity_id integer,
    sequence integer,
    created_user_id bigint,
    updated_user_id bigint,
    menu_action_id bigint,
    menu_transition_id bigint,
    status_id bigint
);


ALTER TABLE navigation_schema.menu_action_transition OWNER TO fractal;

--
-- Name: menu_action_transition_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.menu_action_transition ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.menu_action_transition_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: menu_configuration; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.menu_configuration (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    value character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    configuration_id bigint,
    menu_id bigint,
    status_id bigint
);


ALTER TABLE navigation_schema.menu_configuration OWNER TO fractal;

--
-- Name: menu_configuration_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.menu_configuration ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.menu_configuration_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: menu_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.menu ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.menu_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: menu_transition; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.menu_transition (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    entity_type_id bigint,
    menu_id bigint,
    status_id bigint
);


ALTER TABLE navigation_schema.menu_transition OWNER TO fractal;

--
-- Name: menu_transition_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.menu_transition ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.menu_transition_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: navigation_unit; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.navigation_unit (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE navigation_schema.navigation_unit OWNER TO fractal;

--
-- Name: navigation_unit_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.navigation_unit ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.navigation_unit_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: public_url; Type: TABLE; Schema: navigation_schema; Owner: fractal
--

CREATE TABLE navigation_schema.public_url (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    name character varying(255),
    url character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    status_id bigint
);


ALTER TABLE navigation_schema.public_url OWNER TO fractal;

--
-- Name: public_url_id_seq; Type: SEQUENCE; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE navigation_schema.public_url ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME navigation_schema.public_url_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: accountability; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.accountability (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    description text NOT NULL,
    performance_measure text NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    job_description_id bigint
);


ALTER TABLE organization_schema.accountability OWNER TO fractal;

--
-- Name: accountability_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.accountability ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.accountability_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: authority; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.authority (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    description text NOT NULL,
    scope text NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    job_description_id bigint
);


ALTER TABLE organization_schema.authority OWNER TO fractal;

--
-- Name: authority_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.authority ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.authority_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: separationReason; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.separationReason (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    level integer,
    level_map character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    organization_unit_id bigint,
    parent_id bigint,
    status_id bigint,
    close_date date,
    close_reason character varying(255),
    open_date date,
    open_reason character varying(255)
);


ALTER TABLE organization_schema.separationReason OWNER TO fractal;

--
-- Name: department_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.separationReason ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.department_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: grade; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.grade (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    end_date date,
    max_salary numeric(38,2),
    min_salary numeric(38,2),
    notes text,
    start_date date,
    created_user_id bigint,
    updated_user_id bigint,
    currency_id bigint,
    status_id bigint,
    parent_id bigint,
    grade_level_id bigint
);


ALTER TABLE organization_schema.grade OWNER TO fractal;

--
-- Name: grade_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.grade ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.grade_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: grade_level; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.grade_level (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE organization_schema.grade_level OWNER TO fractal;

--
-- Name: grade_level_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.grade_level ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.grade_level_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: grade_step; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.grade_step (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    max_salary numeric(38,2),
    min_salary numeric(38,2),
    created_user_id bigint,
    updated_user_id bigint,
    grade_id bigint,
    status_id bigint
);


ALTER TABLE organization_schema.grade_step OWNER TO fractal;

--
-- Name: grade_step_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.grade_step ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.grade_step_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: job_description; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.job_description (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    effective_date date,
    summary text,
    title character varying(255) NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    position_id bigint,
    status_id bigint
);


ALTER TABLE organization_schema.job_description OWNER TO fractal;

--
-- Name: job_description_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.job_description ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.job_description_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: key_performance_indicator; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.key_performance_indicator (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    description text NOT NULL,
    frequency character varying(255),
    measure_unit character varying(255),
    name character varying(255),
    target_value double precision,
    created_user_id bigint,
    updated_user_id bigint,
    job_description_id bigint
);


ALTER TABLE organization_schema.key_performance_indicator OWNER TO fractal;

--
-- Name: key_performance_indicator_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.key_performance_indicator ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.key_performance_indicator_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: organization; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.organization (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    close_date date,
    code character varying(255),
    full_name character varying(255),
    level integer,
    level_map character varying(255),
    name character varying(255),
    open_date date,
    tin_number character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    organization_unit_id bigint,
    parent_id bigint,
    close_reason character varying(255),
    open_reason character varying(255)
);


ALTER TABLE organization_schema.organization OWNER TO fractal;

--
-- Name: organization_address; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.organization_address (
    id bigint NOT NULL,
    organization_id bigint
);


ALTER TABLE organization_schema.organization_address OWNER TO fractal;

--
-- Name: organization_contact; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.organization_contact (
    id bigint NOT NULL,
    organization_id bigint
);


ALTER TABLE organization_schema.organization_contact OWNER TO fractal;

--
-- Name: organization_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.organization ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.organization_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: organization_unit; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.organization_unit (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    description character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE organization_schema.organization_unit OWNER TO fractal;

--
-- Name: organization_unit_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.organization_unit ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.organization_unit_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: position; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema."position" (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    description character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    department_id bigint,
    grade_id bigint,
    status_id bigint,
    close_date date,
    close_reason character varying(255),
    open_date date,
    open_reason character varying(255)
);


ALTER TABLE organization_schema."position" OWNER TO fractal;

--
-- Name: position_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema."position" ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.position_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: qualification; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.qualification (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    description text NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    job_description_id bigint
);


ALTER TABLE organization_schema.qualification OWNER TO fractal;

--
-- Name: qualification_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.qualification ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.qualification_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: reporting_line; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.reporting_line (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    job_description_id bigint,
    position_id bigint,
    reporting_line_type_id bigint,
    status_id bigint
);


ALTER TABLE organization_schema.reporting_line OWNER TO fractal;

--
-- Name: reporting_line_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.reporting_line ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.reporting_line_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: reporting_line_type; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.reporting_line_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE organization_schema.reporting_line_type OWNER TO fractal;

--
-- Name: reporting_line_type_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.reporting_line_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.reporting_line_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: required_experience; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.required_experience (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    description text NOT NULL,
    domain character varying(255),
    end_date date,
    level character varying(255),
    mandatory boolean,
    notes text,
    required_years integer,
    start_date date,
    created_user_id bigint,
    updated_user_id bigint,
    job_description_id bigint
);


ALTER TABLE organization_schema.required_experience OWNER TO fractal;

--
-- Name: required_experience_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.required_experience ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.required_experience_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: responsibility; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.responsibility (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    description text NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    job_description_id bigint
);


ALTER TABLE organization_schema.responsibility OWNER TO fractal;

--
-- Name: responsibility_id_seq; Type: SEQUENCE; Schema: organization_schema; Owner: fractal
--

ALTER TABLE organization_schema.responsibility ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME organization_schema.responsibility_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: work_schedule; Type: TABLE; Schema: organization_schema; Owner: fractal
--

CREATE TABLE organization_schema.work_schedule (
    id bigint NOT NULL,
    organization_id bigint
);


ALTER TABLE organization_schema.work_schedule OWNER TO fractal;

--
-- Name: address_seq; Type: SEQUENCE; Schema: public; Owner: fractal
--

CREATE SEQUENCE public.address_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.address_seq OWNER TO fractal;

--
-- Name: contact_seq; Type: SEQUENCE; Schema: public; Owner: fractal
--

CREATE SEQUENCE public.contact_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.contact_seq OWNER TO fractal;

--
-- Name: oder_seq; Type: SEQUENCE; Schema: public; Owner: fractal
--

CREATE SEQUENCE public.oder_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.oder_seq OWNER TO fractal;

--
-- Name: order_seq; Type: SEQUENCE; Schema: public; Owner: fractal
--

CREATE SEQUENCE public.order_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.order_seq OWNER TO fractal;

--
-- Name: resource_seq; Type: SEQUENCE; Schema: public; Owner: fractal
--

CREATE SEQUENCE public.resource_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.resource_seq OWNER TO fractal;

--
-- Name: candidate; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.candidate (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    birth_date date,
    first_name character varying(255),
    last_name character varying(255),
    patronymic_name character varying(255),
    ssn character varying(255),
    tin character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    gender_id bigint,
    marital_status_id bigint,
    nationality_id bigint,
    status_id bigint,
    vacancy_id bigint
);


ALTER TABLE recruitment_schema.candidate OWNER TO fractal;

--
-- Name: candidate_address; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.candidate_address (
    id bigint NOT NULL,
    candidate_id bigint
);


ALTER TABLE recruitment_schema.candidate_address OWNER TO fractal;

--
-- Name: candidate_citizenship; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.candidate_citizenship (
    id bigint NOT NULL,
    candidate_id bigint
);


ALTER TABLE recruitment_schema.candidate_citizenship OWNER TO fractal;

--
-- Name: candidate_contact; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.candidate_contact (
    id bigint NOT NULL,
    candidate_id bigint
);


ALTER TABLE recruitment_schema.candidate_contact OWNER TO fractal;

--
-- Name: candidate_education; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.candidate_education (
    id bigint NOT NULL,
    candidate_id bigint
);


ALTER TABLE recruitment_schema.candidate_education OWNER TO fractal;

--
-- Name: candidate_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.candidate ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.candidate_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: candidate_identification_document; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.candidate_identification_document (
    id bigint NOT NULL,
    candidate_id bigint
);


ALTER TABLE recruitment_schema.candidate_identification_document OWNER TO fractal;

--
-- Name: candidate_military_service; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.candidate_military_service (
    id bigint NOT NULL,
    candidate_id bigint
);


ALTER TABLE recruitment_schema.candidate_military_service OWNER TO fractal;

--
-- Name: candidate_resource; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.candidate_resource (
    id bigint NOT NULL,
    candidate_id bigint,
    candidate_resource_type_id bigint
);


ALTER TABLE recruitment_schema.candidate_resource OWNER TO fractal;

--
-- Name: candidate_resource_type; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.candidate_resource_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE recruitment_schema.candidate_resource_type OWNER TO fractal;

--
-- Name: candidate_resource_type_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.candidate_resource_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.candidate_resource_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: candidate_work_experience; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.candidate_work_experience (
    id bigint NOT NULL,
    candidate_id bigint
);


ALTER TABLE recruitment_schema.candidate_work_experience OWNER TO fractal;

--
-- Name: duty; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.duty (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    description text NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    vacancy_id bigint
);


ALTER TABLE recruitment_schema.duty OWNER TO fractal;

--
-- Name: duty_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.duty ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.duty_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: experience; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.experience (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    description text NOT NULL,
    domain character varying(255),
    level character varying(255),
    mandatory boolean,
    notes text,
    required_years integer,
    created_user_id bigint,
    updated_user_id bigint,
    vacancy_id bigint
);


ALTER TABLE recruitment_schema.experience OWNER TO fractal;

--
-- Name: experience_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.experience ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.experience_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: interview; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.interview (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    description character varying(255),
    details character varying(255),
    duration_minutes integer,
    notes character varying(255),
    scheduled_time timestamp(6) without time zone NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    interview_type_id bigint,
    status_id bigint
);


ALTER TABLE recruitment_schema.interview OWNER TO fractal;

--
-- Name: interview_evaluation; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.interview_evaluation (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    approved_date timestamp(6) without time zone,
    reviewed_date timestamp(6) without time zone,
    approved_user_id bigint,
    reviewed_user_id bigint,
    status_id bigint
);


ALTER TABLE recruitment_schema.interview_evaluation OWNER TO fractal;

--
-- Name: interview_evaluation_answer; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.interview_evaluation_answer (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    text character varying(255) NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    interview_evaluation_question_id bigint,
    status_id bigint
);


ALTER TABLE recruitment_schema.interview_evaluation_answer OWNER TO fractal;

--
-- Name: interview_evaluation_answer_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.interview_evaluation_answer ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.interview_evaluation_answer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: interview_evaluation_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.interview_evaluation ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.interview_evaluation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: interview_evaluation_question; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.interview_evaluation_question (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    max_selectable_options integer,
    text text NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    interview_evaluation_section_id bigint,
    question_type_id bigint,
    status_id bigint
);


ALTER TABLE recruitment_schema.interview_evaluation_question OWNER TO fractal;

--
-- Name: interview_evaluation_question_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.interview_evaluation_question ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.interview_evaluation_question_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: interview_evaluation_section; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.interview_evaluation_section (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    interview_evaluation_id bigint,
    parent_id bigint,
    status_id bigint
);


ALTER TABLE recruitment_schema.interview_evaluation_section OWNER TO fractal;

--
-- Name: interview_evaluation_section_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.interview_evaluation_section ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.interview_evaluation_section_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: interview_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.interview ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.interview_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: interview_type; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.interview_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE recruitment_schema.interview_type OWNER TO fractal;

--
-- Name: interview_type_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.interview_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.interview_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: interviewee; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.interviewee (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    duration_minutes integer,
    scheduled_time timestamp(6) without time zone NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    candidate_id bigint,
    interview_id bigint,
    status_id bigint
);


ALTER TABLE recruitment_schema.interviewee OWNER TO fractal;

--
-- Name: interviewee_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.interviewee ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.interviewee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: interviewer; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.interviewer (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    employee_id bigint,
    interview_id bigint,
    status_id bigint,
    duration_minutes integer,
    scheduled_time timestamp(6) without time zone NOT NULL,
    interview_evaluation_id bigint
);


ALTER TABLE recruitment_schema.interviewer OWNER TO fractal;

--
-- Name: interviewer_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.interviewer ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.interviewer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: skill; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.skill (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    description text NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    vacancy_id bigint
);


ALTER TABLE recruitment_schema.skill OWNER TO fractal;

--
-- Name: skill_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.skill ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.skill_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: vacancy; Type: TABLE; Schema: recruitment_schema; Owner: fractal
--

CREATE TABLE recruitment_schema.vacancy (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    close_date date,
    description character varying(255),
    open_date date,
    salary double precision,
    created_user_id bigint,
    updated_user_id bigint,
    organization_id bigint,
    position_id bigint,
    status_id bigint
);


ALTER TABLE recruitment_schema.vacancy OWNER TO fractal;

--
-- Name: vacancy_id_seq; Type: SEQUENCE; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE recruitment_schema.vacancy ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME recruitment_schema.vacancy_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: resource; Type: TABLE; Schema: resource_schema; Owner: fractal
--

CREATE TABLE resource_schema.resource (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    content_type character varying(255),
    file_name character varying(255),
    size_in_bytes bigint,
    url character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE resource_schema.resource OWNER TO fractal;

--
-- Name: entity_state; Type: TABLE; Schema: state_schema; Owner: fractal
--

CREATE TABLE state_schema.entity_state (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    status_id bigint
);


ALTER TABLE state_schema.entity_state OWNER TO fractal;

--
-- Name: entity_state_id_seq; Type: SEQUENCE; Schema: state_schema; Owner: fractal
--

ALTER TABLE state_schema.entity_state ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME state_schema.entity_state_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: environment_variable; Type: TABLE; Schema: system_schema; Owner: fractal
--

CREATE TABLE system_schema.environment_variable (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    value character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE system_schema.environment_variable OWNER TO fractal;

--
-- Name: environment_variable_id_seq; Type: SEQUENCE; Schema: system_schema; Owner: fractal
--

ALTER TABLE system_schema.environment_variable ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME system_schema.environment_variable_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: message; Type: TABLE; Schema: system_schema; Owner: fractal
--

CREATE TABLE system_schema.message (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    description character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    language_id bigint,
    message_type_id bigint
);


ALTER TABLE system_schema.message OWNER TO fractal;

--
-- Name: message_id_seq; Type: SEQUENCE; Schema: system_schema; Owner: fractal
--

ALTER TABLE system_schema.message ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME system_schema.message_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: message_type; Type: TABLE; Schema: system_schema; Owner: fractal
--

CREATE TABLE system_schema.message_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    description character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE system_schema.message_type OWNER TO fractal;

--
-- Name: message_type_id_seq; Type: SEQUENCE; Schema: system_schema; Owner: fractal
--

ALTER TABLE system_schema.message_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME system_schema.message_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: notification; Type: TABLE; Schema: system_schema; Owner: fractal
--

CREATE TABLE system_schema.notification (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    message character varying(255),
    receiver character varying(255),
    sender character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    notification_type_id bigint,
    service_provider_id bigint,
    status_id bigint
);


ALTER TABLE system_schema.notification OWNER TO fractal;

--
-- Name: notification_id_seq; Type: SEQUENCE; Schema: system_schema; Owner: fractal
--

ALTER TABLE system_schema.notification ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME system_schema.notification_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: notification_type; Type: TABLE; Schema: system_schema; Owner: fractal
--

CREATE TABLE system_schema.notification_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    description character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE system_schema.notification_type OWNER TO fractal;

--
-- Name: notification_type_id_seq; Type: SEQUENCE; Schema: system_schema; Owner: fractal
--

ALTER TABLE system_schema.notification_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME system_schema.notification_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: service_provider; Type: TABLE; Schema: system_schema; Owner: fractal
--

CREATE TABLE system_schema.service_provider (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    host character varying(255),
    name character varying(255),
    password character varying(255),
    port integer,
    protocol character varying(255),
    username character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    service_provider_id bigint,
    status_id bigint
);


ALTER TABLE system_schema.service_provider OWNER TO fractal;

--
-- Name: service_provider_id_seq; Type: SEQUENCE; Schema: system_schema; Owner: fractal
--

ALTER TABLE system_schema.service_provider ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME system_schema.service_provider_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: service_provider_type; Type: TABLE; Schema: system_schema; Owner: fractal
--

CREATE TABLE system_schema.service_provider_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    description character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE system_schema.service_provider_type OWNER TO fractal;

--
-- Name: service_provider_type_id_seq; Type: SEQUENCE; Schema: system_schema; Owner: fractal
--

ALTER TABLE system_schema.service_provider_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME system_schema.service_provider_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: selectedAnswer; Type: TABLE; Schema: testing_schema; Owner: fractal
--

CREATE TABLE testing_schema.selectedAnswer (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    is_correct boolean,
    text character varying(255) NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    question_id bigint
);


ALTER TABLE testing_schema.selectedAnswer OWNER TO fractal;

--
-- Name: answer_id_seq; Type: SEQUENCE; Schema: testing_schema; Owner: fractal
--

ALTER TABLE testing_schema.selectedAnswer ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME testing_schema.answer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: answer_submission; Type: TABLE; Schema: testing_schema; Owner: fractal
--

CREATE TABLE testing_schema.answer_submission (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    approved_date timestamp(6) without time zone,
    reviewed_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    approved_user_id bigint,
    reviewed_user_id bigint,
    question_id bigint NOT NULL,
    status_id bigint,
    test_session_id bigint NOT NULL
);


ALTER TABLE testing_schema.answer_submission OWNER TO fractal;

--
-- Name: answer_submission_id_seq; Type: SEQUENCE; Schema: testing_schema; Owner: fractal
--

ALTER TABLE testing_schema.answer_submission ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME testing_schema.answer_submission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: question; Type: TABLE; Schema: testing_schema; Owner: fractal
--

CREATE TABLE testing_schema.question (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    text text NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    question_type_id bigint,
    max_selectable_options integer,
    status_id bigint,
    test_id bigint
);


ALTER TABLE testing_schema.question OWNER TO fractal;

--
-- Name: question_id_seq; Type: SEQUENCE; Schema: testing_schema; Owner: fractal
--

ALTER TABLE testing_schema.question ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME testing_schema.question_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: question_type; Type: TABLE; Schema: testing_schema; Owner: fractal
--

CREATE TABLE testing_schema.question_type (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE testing_schema.question_type OWNER TO fractal;

--
-- Name: question_type_id_seq; Type: SEQUENCE; Schema: testing_schema; Owner: fractal
--

ALTER TABLE testing_schema.question_type ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME testing_schema.question_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: selected_answer; Type: TABLE; Schema: testing_schema; Owner: fractal
--

CREATE TABLE testing_schema.selected_answer (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    approved_date timestamp(6) without time zone,
    reviewed_date timestamp(6) without time zone,
    selected_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    approved_user_id bigint,
    reviewed_user_id bigint,
    answer_id bigint NOT NULL,
    answer_submission_id bigint NOT NULL
);


ALTER TABLE testing_schema.selected_answer OWNER TO fractal;

--
-- Name: selected_answer_id_seq; Type: SEQUENCE; Schema: testing_schema; Owner: fractal
--

ALTER TABLE testing_schema.selected_answer ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME testing_schema.selected_answer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: test; Type: TABLE; Schema: testing_schema; Owner: fractal
--

CREATE TABLE testing_schema.test (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    approved_date timestamp(6) without time zone,
    reviewed_date timestamp(6) without time zone,
    description text,
    duration_minutes integer,
    title character varying(255) NOT NULL,
    created_user_id bigint,
    updated_user_id bigint,
    approved_user_id bigint,
    reviewed_user_id bigint,
    status_id bigint
);


ALTER TABLE testing_schema.test OWNER TO fractal;

--
-- Name: test_id_seq; Type: SEQUENCE; Schema: testing_schema; Owner: fractal
--

ALTER TABLE testing_schema.test ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME testing_schema.test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: test_session; Type: TABLE; Schema: testing_schema; Owner: fractal
--

CREATE TABLE testing_schema.test_session (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    approved_date timestamp(6) without time zone,
    reviewed_date timestamp(6) without time zone,
    end_date timestamp(6) without time zone,
    score double precision,
    start_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    approved_user_id bigint,
    reviewed_user_id bigint,
    status_id bigint,
    test_id bigint,
    user_id bigint NOT NULL
);


ALTER TABLE testing_schema.test_session OWNER TO fractal;

--
-- Name: test_session_id_seq; Type: SEQUENCE; Schema: testing_schema; Owner: fractal
--

ALTER TABLE testing_schema.test_session ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME testing_schema.test_session_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: attribute; Type: TABLE; Schema: ui_schema; Owner: fractal
--

CREATE TABLE ui_schema.attribute (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE ui_schema.attribute OWNER TO fractal;

--
-- Name: attribute_id_seq; Type: SEQUENCE; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ui_schema.attribute ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME ui_schema.attribute_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: component; Type: TABLE; Schema: ui_schema; Owner: fractal
--

CREATE TABLE ui_schema.component (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    code character varying(255),
    name character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE ui_schema.component OWNER TO fractal;

--
-- Name: component_attributes; Type: TABLE; Schema: ui_schema; Owner: fractal
--

CREATE TABLE ui_schema.component_attributes (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    attribute_id bigint,
    component_id bigint,
    status_id bigint
);


ALTER TABLE ui_schema.component_attributes OWNER TO fractal;

--
-- Name: component_attributes_id_seq; Type: SEQUENCE; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ui_schema.component_attributes ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME ui_schema.component_attributes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: component_id_seq; Type: SEQUENCE; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ui_schema.component ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME ui_schema.component_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: authentication; Type: TABLE; Schema: user_schema; Owner: fractal
--

CREATE TABLE user_schema.authentication (
    id integer NOT NULL,
    language character varying(255),
    sign_in_date timestamp(6) without time zone,
    sign_out_date timestamp(6) without time zone,
    token character varying(255),
    status_id bigint,
    user_id bigint
);


ALTER TABLE user_schema.authentication OWNER TO fractal;

--
-- Name: authentication_id_seq; Type: SEQUENCE; Schema: user_schema; Owner: fractal
--

ALTER TABLE user_schema.authentication ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME user_schema.authentication_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: profile; Type: TABLE; Schema: user_schema; Owner: fractal
--

CREATE TABLE user_schema.profile (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    value character varying(255),
    created_user_id bigint,
    updated_user_id bigint,
    profile_attribute_id bigint,
    status_id bigint,
    user_id bigint
);


ALTER TABLE user_schema.profile OWNER TO fractal;

--
-- Name: profile_id_seq; Type: SEQUENCE; Schema: user_schema; Owner: fractal
--

ALTER TABLE user_schema.profile ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME user_schema.profile_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: user; Type: TABLE; Schema: user_schema; Owner: fractal
--

CREATE TABLE user_schema."user" (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    employee_id integer,
    is_account_expired boolean,
    is_active boolean,
    is_credentials_expired boolean,
    is_lock boolean,
    password character varying(255),
    username character varying(255),
    created_user_id bigint,
    updated_user_id bigint
);


ALTER TABLE user_schema."user" OWNER TO fractal;

--
-- Name: user_id_seq; Type: SEQUENCE; Schema: user_schema; Owner: fractal
--

ALTER TABLE user_schema."user" ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME user_schema.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: work_schedule; Type: TABLE; Schema: work_schedule_schema; Owner: fractal
--

CREATE TABLE work_schedule_schema.work_schedule (
    id bigint NOT NULL,
    created_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_date timestamp(6) without time zone,
    end_time time(6) without time zone,
    start_time time(6) without time zone,
    created_user_id bigint,
    updated_user_id bigint,
    status_id bigint,
    week_day_id bigint
);


ALTER TABLE work_schedule_schema.work_schedule OWNER TO fractal;

--
-- Name: work_schedule_id_seq; Type: SEQUENCE; Schema: work_schedule_schema; Owner: fractal
--

ALTER TABLE work_schedule_schema.work_schedule ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME work_schedule_schema.work_schedule_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: permission; Type: TABLE DATA; Schema: authorization_schema; Owner: fractal
--

COPY authorization_schema.permission (id, created_date, updated_date, confirmed_date, created_user_id, updated_user_id, confirmed_user_id, menu_action_id, role_id, status_id) FROM stdin;
1	2025-07-23 13:12:33.635428	\N	\N	\N	\N	\N	8	1	5
2	2025-07-23 13:12:48.039837	\N	\N	\N	\N	\N	9	1	5
3	2025-07-23 13:12:53.924838	\N	\N	\N	\N	\N	10	1	5
4	2025-07-24 13:37:13.933555	\N	\N	\N	\N	\N	18	1	5
5	2025-07-24 13:37:13.933555	\N	\N	\N	\N	\N	19	1	5
6	2025-07-24 13:37:13.933555	\N	\N	\N	\N	\N	20	1	5
7	2025-07-26 10:16:14.186566	\N	\N	\N	\N	\N	24	1	5
8	2025-07-26 10:16:14.186566	\N	\N	\N	\N	\N	25	1	5
9	2025-07-26 10:16:14.186566	\N	\N	\N	\N	\N	26	1	5
10	2025-07-26 12:42:54.817112	\N	\N	\N	\N	\N	28	1	5
11	2025-07-26 12:42:54.817112	\N	\N	\N	\N	\N	29	1	5
12	2025-07-26 12:42:54.817112	\N	\N	\N	\N	\N	30	1	5
13	2025-07-26 12:42:54.817112	\N	\N	\N	\N	\N	31	1	5
14	2025-07-26 12:42:54.817112	\N	\N	\N	\N	\N	32	1	5
15	2025-07-26 12:42:54.817112	\N	\N	\N	\N	\N	33	1	5
16	2025-07-27 08:17:49.74115	\N	\N	\N	\N	\N	15	1	5
17	2025-07-27 08:17:49.74115	\N	\N	\N	\N	\N	16	1	5
18	2025-07-27 08:17:49.74115	\N	\N	\N	\N	\N	17	1	5
19	2025-07-27 08:46:33.228408	\N	\N	\N	\N	\N	34	1	5
20	2025-07-27 08:46:33.228408	\N	\N	\N	\N	\N	35	1	5
21	2025-07-27 08:46:33.228408	\N	\N	\N	\N	\N	36	1	5
94	2025-08-06 13:51:17.450684	\N	\N	\N	\N	\N	103	1	5
95	2025-08-06 13:51:30.89362	\N	\N	\N	\N	\N	104	1	5
96	2025-08-09 07:44:21.202123	\N	\N	\N	\N	\N	105	1	5
97	2025-08-09 07:44:40.797893	\N	\N	\N	\N	\N	106	1	5
25	2025-07-27 12:00:35.380853	\N	\N	\N	\N	\N	46	1	5
26	2025-07-27 12:00:54.619421	\N	\N	\N	\N	\N	47	1	5
27	2025-07-27 12:01:18.78162	\N	\N	\N	\N	\N	48	1	5
28	2025-07-27 12:01:42.737928	\N	\N	\N	\N	\N	43	1	5
29	2025-07-27 12:02:04.581476	\N	\N	\N	\N	\N	45	1	5
30	2025-07-27 12:02:29.958773	\N	\N	\N	\N	\N	44	1	5
31	2025-07-27 12:03:41.34588	\N	\N	\N	\N	\N	40	1	5
32	2025-07-27 12:04:02.67588	\N	\N	\N	\N	\N	41	1	5
33	2025-07-27 12:04:24.531822	\N	\N	\N	\N	\N	42	1	5
34	2025-07-28 11:48:14.574656	\N	\N	\N	\N	\N	49	1	5
35	2025-07-28 11:48:30.504348	\N	\N	\N	\N	\N	50	1	5
36	2025-07-28 11:48:44.294634	\N	\N	\N	\N	\N	51	1	5
37	2025-07-28 12:08:26.086824	\N	\N	\N	\N	\N	52	1	5
38	2025-07-28 12:08:42.080028	\N	\N	\N	\N	\N	53	1	5
39	2025-07-28 12:09:39.594364	\N	\N	\N	\N	\N	54	1	5
40	2025-07-28 12:22:37.473676	\N	\N	\N	\N	\N	55	1	5
41	2025-07-28 12:22:57.585298	\N	\N	\N	\N	\N	56	1	5
42	2025-07-28 12:23:14.051873	\N	\N	\N	\N	\N	57	1	5
46	2025-07-28 13:57:13.642143	\N	\N	\N	\N	\N	58	1	5
47	2025-07-28 13:57:33.1935	\N	\N	\N	\N	\N	59	1	5
48	2025-07-28 13:57:53.058938	\N	\N	\N	\N	\N	60	1	5
49	2025-07-28 14:19:19.283518	\N	\N	\N	\N	\N	61	1	5
50	2025-07-28 14:19:38.995718	\N	\N	\N	\N	\N	62	1	5
51	2025-07-28 14:20:00.990951	\N	\N	\N	\N	\N	63	1	5
52	2025-07-28 14:46:57.085452	\N	\N	\N	\N	\N	64	1	5
53	2025-07-28 14:47:18.165019	\N	\N	\N	\N	\N	65	1	5
54	2025-07-28 14:47:35.891135	\N	\N	\N	\N	\N	66	1	5
55	2025-07-29 13:09:00.430211	\N	\N	\N	\N	\N	67	1	5
56	2025-07-29 13:09:19.306733	\N	\N	\N	\N	\N	68	1	5
57	2025-07-29 13:09:37.901428	\N	\N	\N	\N	\N	69	1	5
58	2025-07-29 13:42:55.927995	\N	\N	\N	\N	\N	70	1	5
59	2025-07-29 13:43:17.709881	\N	\N	\N	\N	\N	71	1	5
60	2025-07-29 13:43:44.224609	\N	\N	\N	\N	\N	72	1	5
61	2025-07-29 14:14:14.694168	\N	\N	\N	\N	\N	73	1	5
62	2025-07-29 14:14:46.876288	\N	\N	\N	\N	\N	74	1	5
63	2025-07-29 14:15:15.138933	\N	\N	\N	\N	\N	75	1	5
64	2025-07-31 12:24:34.555704	\N	\N	\N	\N	\N	27	1	5
65	2025-07-31 12:25:34.920778	\N	\N	\N	\N	\N	22	1	5
66	2025-07-31 12:26:14.672761	\N	\N	\N	\N	\N	23	1	5
68	2025-07-31 13:16:02.251501	\N	\N	\N	\N	\N	12	1	5
69	2025-07-31 13:16:28.797551	\N	\N	\N	\N	\N	13	1	5
70	2025-07-31 13:16:56.543057	\N	\N	\N	\N	\N	14	1	5
71	2025-07-31 13:17:24.04402	\N	\N	\N	\N	\N	76	1	5
72	2025-07-31 14:02:10.035605	\N	\N	\N	\N	\N	77	1	5
73	2025-08-01 13:40:54.010329	\N	\N	\N	\N	\N	78	1	5
74	2025-08-01 13:41:31.420659	\N	\N	\N	\N	\N	79	1	5
75	2025-08-01 13:42:04.041655	\N	\N	\N	\N	\N	80	1	5
76	2025-08-01 22:55:04.597245	\N	\N	\N	\N	\N	81	1	5
77	2025-08-01 18:05:29.020417	\N	\N	\N	\N	\N	82	1	5
78	2025-08-01 18:06:38.027822	\N	\N	\N	\N	\N	83	1	5
79	2025-08-03 17:01:36.990743	\N	\N	\N	\N	\N	93	1	5
80	2025-08-03 17:02:33.150602	\N	\N	\N	\N	\N	94	1	5
81	2025-08-03 17:03:24.718978	\N	\N	\N	\N	\N	95	1	5
82	2025-08-04 18:38:11.638465	\N	\N	\N	\N	\N	87	1	5
83	2025-08-04 18:39:38.484248	\N	\N	\N	\N	\N	88	1	5
84	2025-08-04 18:40:32.939399	\N	\N	\N	\N	\N	89	1	5
85	2025-08-05 12:47:39.65535	\N	\N	\N	\N	\N	96	1	5
86	2025-08-05 12:48:30.099985	\N	\N	\N	\N	\N	97	1	5
87	2025-08-05 12:49:41.568167	\N	\N	\N	\N	\N	98	1	5
88	2025-08-05 12:55:20.834515	\N	\N	\N	\N	\N	99	1	5
89	2025-08-05 12:56:46.452698	\N	\N	\N	\N	\N	100	1	5
90	2025-08-05 13:03:56.934203	\N	\N	\N	\N	\N	84	1	5
91	2025-08-05 13:04:54.362131	\N	\N	\N	\N	\N	85	1	5
92	2025-08-05 13:05:29.923841	\N	\N	\N	\N	\N	86	1	5
93	2025-08-06 13:51:01.827714	\N	\N	\N	\N	\N	102	1	5
98	2025-08-09 07:44:56.429416	\N	\N	\N	\N	\N	107	1	5
99	2025-08-10 10:28:50.280936	\N	\N	\N	\N	\N	108	1	5
100	2025-08-10 10:29:05.113678	\N	\N	\N	\N	\N	109	1	5
101	2025-08-10 10:29:19.920678	\N	\N	\N	\N	\N	110	1	5
102	2025-08-10 11:35:43.74385	\N	\N	\N	\N	\N	111	1	5
103	2025-08-10 11:35:58.50695	\N	\N	\N	\N	\N	112	1	5
104	2025-08-10 11:36:11.715252	\N	\N	\N	\N	\N	113	1	5
105	2025-08-10 17:54:02.774567	\N	\N	\N	\N	\N	114	1	5
106	2025-08-10 17:56:22.663261	\N	\N	\N	\N	\N	115	1	5
107	2025-08-10 17:58:27.523476	\N	\N	\N	\N	\N	116	1	5
108	2025-08-12 18:40:49.995957	\N	\N	\N	\N	\N	117	1	5
109	2025-08-12 18:43:04.739682	\N	\N	\N	\N	\N	118	1	5
110	2025-08-12 18:44:51.628411	\N	\N	\N	\N	\N	119	1	5
111	2025-08-14 14:17:43.630935	\N	\N	\N	\N	\N	120	1	5
112	2025-08-14 14:17:53.40362	\N	\N	\N	\N	\N	121	1	5
113	2025-08-14 14:18:02.763744	\N	\N	\N	\N	\N	122	1	5
114	2025-08-14 18:20:53.259284	\N	\N	\N	\N	\N	90	1	5
115	2025-08-14 18:21:02.204467	\N	\N	\N	\N	\N	91	1	5
116	2025-08-14 18:21:11.530638	\N	\N	\N	\N	\N	92	1	5
117	2025-08-14 19:12:05.017197	\N	\N	\N	\N	\N	123	1	5
118	2025-08-14 19:12:14.386162	\N	\N	\N	\N	\N	124	1	5
119	2025-08-14 19:12:23.688185	\N	\N	\N	\N	\N	125	1	5
120	2025-08-15 14:22:02.751693	\N	\N	\N	\N	\N	126	1	5
121	2025-08-15 14:22:11.531241	\N	\N	\N	\N	\N	127	1	5
122	2025-08-15 14:22:49.702946	\N	\N	\N	\N	\N	128	1	5
123	2025-08-15 14:29:25.064203	\N	\N	\N	\N	\N	129	1	5
124	2025-08-15 14:29:33.638199	\N	\N	\N	\N	\N	130	1	5
125	2025-08-15 14:29:42.063974	\N	\N	\N	\N	\N	131	1	5
126	2025-08-15 14:37:44.084816	\N	\N	\N	\N	\N	132	1	5
127	2025-08-15 14:37:54.312127	\N	\N	\N	\N	\N	133	1	5
128	2025-08-15 14:38:03.773231	\N	\N	\N	\N	\N	134	1	5
129	2025-08-15 14:46:57.255904	\N	\N	\N	\N	\N	135	1	5
130	2025-08-15 14:47:06.900328	\N	\N	\N	\N	\N	136	1	5
131	2025-08-15 14:47:15.85356	\N	\N	\N	\N	\N	137	1	5
132	2025-08-15 14:49:13.379303	\N	\N	\N	\N	\N	138	1	5
133	2025-08-15 14:49:22.807071	\N	\N	\N	\N	\N	139	1	5
134	2025-08-15 14:49:31.099057	\N	\N	\N	\N	\N	140	1	5
135	2025-08-15 14:51:33.355645	\N	\N	\N	\N	\N	141	1	5
136	2025-08-15 14:51:44.390066	\N	\N	\N	\N	\N	142	1	5
137	2025-08-15 14:51:53.378519	\N	\N	\N	\N	\N	143	1	5
141	2025-08-16 13:34:33.609527	\N	\N	\N	\N	\N	150	1	5
142	2025-08-16 13:34:44.668816	\N	\N	\N	\N	\N	151	1	5
143	2025-08-16 13:34:59.376136	\N	\N	\N	\N	\N	152	1	5
144	2025-08-16 16:07:10.230034	\N	\N	\N	\N	\N	153	1	5
145	2025-08-16 16:07:21.778137	\N	\N	\N	\N	\N	154	1	5
146	2025-08-16 16:07:34.417452	\N	\N	\N	\N	\N	155	1	5
147	2025-08-16 17:02:41.605954	\N	\N	\N	\N	\N	156	1	5
148	2025-08-16 17:02:50.739494	\N	\N	\N	\N	\N	157	1	5
149	2025-08-16 17:02:58.57889	\N	\N	\N	\N	\N	158	1	5
150	2025-08-16 17:42:28.914315	\N	\N	\N	\N	\N	159	1	5
151	2025-08-16 17:42:38.130117	\N	\N	\N	\N	\N	160	1	5
152	2025-08-16 17:42:50.655847	\N	\N	\N	\N	\N	161	1	5
156	2025-08-17 13:55:26.521048	\N	\N	\N	\N	\N	165	1	5
157	2025-08-17 13:55:35.687813	\N	\N	\N	\N	\N	166	1	5
158	2025-08-17 13:55:44.57619	\N	\N	\N	\N	\N	167	1	5
159	2025-08-17 14:53:44.048806	\N	\N	\N	\N	\N	168	1	5
160	2025-08-17 14:53:53.783561	\N	\N	\N	\N	\N	169	1	5
161	2025-08-17 14:54:03.654389	\N	\N	\N	\N	\N	170	1	5
162	2025-08-17 15:11:23.071537	\N	\N	\N	\N	\N	171	1	5
165	2025-08-17 15:12:35.157117	\N	\N	\N	\N	\N	172	1	5
166	2025-08-17 15:12:44.479359	\N	\N	\N	\N	\N	173	1	5
167	2025-08-17 16:00:11.424544	\N	\N	\N	\N	\N	174	1	5
168	2025-08-17 16:00:20.716158	\N	\N	\N	\N	\N	175	1	5
169	2025-08-17 16:00:30.297403	\N	\N	\N	\N	\N	176	1	5
170	2025-08-17 16:16:36.009826	\N	\N	\N	\N	\N	177	1	5
171	2025-08-17 16:16:45.002785	\N	\N	\N	\N	\N	178	1	5
172	2025-08-17 16:16:56.292159	\N	\N	\N	\N	\N	179	1	5
173	2025-08-17 16:34:44.405496	\N	\N	\N	\N	\N	180	1	5
174	2025-08-17 16:34:56.587087	\N	\N	\N	\N	\N	181	1	5
175	2025-08-17 16:35:08.393948	\N	\N	\N	\N	\N	182	1	5
176	2025-08-17 16:57:00.685334	\N	\N	\N	\N	\N	183	1	5
177	2025-08-17 16:57:08.782688	\N	\N	\N	\N	\N	184	1	5
178	2025-08-17 16:57:18.350334	\N	\N	\N	\N	\N	185	1	5
179	2025-08-18 16:52:56.019027	\N	\N	\N	\N	\N	186	1	5
180	2025-08-18 16:53:05.183934	\N	\N	\N	\N	\N	187	1	5
181	2025-08-18 16:53:14.042106	\N	\N	\N	\N	\N	188	1	5
182	2025-08-18 18:18:37.120326	\N	\N	\N	\N	\N	189	1	5
183	2025-08-18 18:18:47.896539	\N	\N	\N	\N	\N	190	1	5
184	2025-08-18 18:18:58.428761	\N	\N	\N	\N	\N	191	1	5
185	2025-08-19 18:27:32.697026	\N	\N	\N	\N	\N	87	7	5
186	2025-08-19 18:27:43.612511	\N	\N	\N	\N	\N	88	7	5
187	2025-08-19 18:31:02.306536	\N	\N	\N	\N	\N	78	7	5
188	2025-08-19 18:31:15.014701	\N	\N	\N	\N	\N	79	7	5
189	2025-08-19 18:35:06.571359	\N	\N	\N	\N	\N	90	7	5
190	2025-08-19 18:35:21.719215	\N	\N	\N	\N	\N	91	7	5
191	2025-08-19 18:35:52.69465	\N	\N	\N	\N	\N	81	7	5
192	2025-08-19 18:36:08.439197	\N	\N	\N	\N	\N	82	7	5
193	2025-08-19 18:37:04.473388	\N	\N	\N	\N	\N	105	7	5
196	2025-08-19 18:38:47.269355	\N	\N	\N	\N	\N	106	7	5
197	2025-08-19 18:39:29.812738	\N	\N	\N	\N	\N	117	7	5
198	2025-08-19 18:47:01.109345	\N	\N	\N	\N	\N	192	1	5
199	2025-08-19 18:47:10.827046	\N	\N	\N	\N	\N	193	1	5
200	2025-08-19 18:47:20.854058	\N	\N	\N	\N	\N	194	1	5
201	2025-08-22 19:35:03.759539	\N	\N	\N	\N	\N	195	1	5
202	2025-08-22 19:35:19.033622	\N	\N	\N	\N	\N	196	1	5
203	2025-08-22 19:35:32.875133	\N	\N	\N	\N	\N	197	1	5
204	2025-08-23 16:52:35.949156	\N	\N	\N	\N	\N	198	1	5
205	2025-08-23 16:52:48.753158	\N	\N	\N	\N	\N	199	1	5
206	2025-08-23 16:53:02.831057	\N	\N	\N	\N	\N	200	1	5
207	2025-08-24 12:31:41.833235	\N	\N	\N	\N	\N	201	1	5
208	2025-08-24 12:31:56.726952	\N	\N	\N	\N	\N	202	1	5
209	2025-08-24 12:32:14.068523	\N	\N	\N	\N	\N	203	1	5
213	2025-08-24 15:25:33.280209	\N	\N	\N	\N	\N	207	1	5
214	2025-08-24 15:25:46.717338	\N	\N	\N	\N	\N	208	1	5
215	2025-08-24 15:26:01.161058	\N	\N	\N	\N	\N	209	1	5
217	2025-08-31 17:37:34.096335	\N	\N	\N	\N	\N	210	1	5
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: authorization_schema; Owner: fractal
--

COPY authorization_schema.role (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
1	2025-07-19 14:38:37.260086	\N	ADMIN	Administrator	\N	\N
5	2025-08-06 09:19:22.372973	\N	CUSTOMER	Customer Service	\N	\N
6	2025-08-06 09:19:47.532649	\N	CASHIER	Cashier	\N	\N
7	2025-08-19 18:22:46.743367	\N	HROFFICER	HR Officer	\N	\N
\.


--
-- Data for Name: role_menu; Type: TABLE DATA; Schema: authorization_schema; Owner: fractal
--

COPY authorization_schema.role_menu (id, created_date, updated_date, confirmed_date, created_user_id, updated_user_id, confirmed_user_id, menu_id, role_id, status_id) FROM stdin;
1	2025-07-23 12:22:10.660348	\N	\N	\N	\N	\N	1	1	5
2	2025-07-23 12:22:18.180393	\N	\N	\N	\N	\N	2	1	5
3	2025-07-24 12:57:15.541266	\N	\N	\N	\N	\N	4	1	5
4	2025-07-24 12:57:23.21666	\N	\N	\N	\N	\N	5	1	5
5	2025-07-24 12:57:28.802453	\N	\N	\N	\N	\N	6	1	5
6	2025-07-24 12:57:32.931993	\N	\N	\N	\N	\N	7	1	5
7	2025-07-24 12:57:37.143715	\N	\N	\N	\N	\N	8	1	5
8	2025-07-24 12:57:42.059674	\N	\N	\N	\N	\N	9	1	5
9	2025-07-26 12:40:55.967888	\N	\N	\N	\N	\N	25	1	5
10	2025-07-26 12:40:55.967888	\N	\N	\N	\N	\N	26	1	5
11	2025-07-27 08:47:06.969475	\N	\N	\N	\N	\N	3	1	5
13	2025-07-27 08:51:39.314615	\N	\N	\N	\N	\N	28	1	5
14	2025-07-27 11:59:23.977527	\N	\N	\N	\N	\N	29	1	5
15	2025-07-27 11:59:35.533026	\N	\N	\N	\N	\N	30	1	5
16	2025-07-27 11:59:45.763312	\N	\N	\N	\N	\N	31	1	5
17	2025-07-27 11:59:58.35203	\N	\N	\N	\N	\N	32	1	5
18	2025-07-28 12:08:04.62963	\N	\N	\N	\N	\N	33	1	5
19	2025-07-28 12:22:15.20771	\N	\N	\N	\N	\N	34	1	5
20	2025-07-28 13:53:59.30031	\N	\N	\N	\N	\N	35	1	5
21	2025-07-28 13:54:07.961964	\N	\N	\N	\N	\N	34	1	5
22	2025-07-28 14:18:51.712184	\N	\N	\N	\N	\N	37	1	5
23	2025-07-28 14:46:36.045657	\N	\N	\N	\N	\N	38	1	5
24	2025-07-29 13:08:32.409911	\N	\N	\N	\N	\N	39	1	5
25	2025-07-29 13:42:25.961141	\N	\N	\N	\N	\N	40	1	5
26	2025-07-29 14:13:41.947952	\N	\N	\N	\N	\N	41	1	5
27	2025-08-01 10:40:00.096769	\N	\N	\N	\N	\N	42	1	5
28	2025-08-01 10:40:12.551625	\N	\N	\N	\N	\N	43	1	5
29	2025-08-01 10:40:25.050024	\N	\N	\N	\N	\N	44	1	5
30	2025-08-01 10:40:40.917394	\N	\N	\N	\N	\N	45	1	5
31	2025-08-01 10:42:35.682595	\N	\N	\N	\N	\N	47	1	5
32	2025-08-03 17:00:45.924838	\N	\N	\N	\N	\N	48	1	5
33	2025-08-05 12:45:10.026476	\N	\N	\N	\N	\N	49	1	5
34	2025-08-05 12:45:21.103948	\N	\N	\N	\N	\N	50	1	5
35	2025-08-06 13:54:12.7066	\N	\N	\N	\N	\N	51	1	5
36	2025-08-09 07:43:59.864315	\N	\N	\N	\N	\N	52	1	5
37	2025-08-10 10:28:19.683618	\N	\N	\N	\N	\N	53	1	5
38	2025-08-10 10:28:28.167553	\N	\N	\N	\N	\N	54	1	5
39	2025-08-10 11:35:21.120069	\N	\N	\N	\N	\N	55	1	5
40	2025-08-10 17:50:02.029994	\N	\N	\N	\N	\N	56	1	5
43	2025-08-16 13:34:14.739017	\N	\N	\N	\N	\N	68	1	5
44	2025-08-16 16:06:47.082671	\N	\N	\N	\N	\N	69	1	5
45	2025-08-16 17:02:32.245684	\N	\N	\N	\N	\N	70	1	5
46	2025-08-16 17:42:19.461392	\N	\N	\N	\N	\N	71	1	5
48	2025-08-17 13:55:15.477132	\N	\N	\N	\N	\N	73	1	5
49	2025-08-17 14:53:21.783258	\N	\N	\N	\N	\N	74	1	5
50	2025-08-17 14:53:27.172555	\N	\N	\N	\N	\N	75	1	5
51	2025-08-17 15:11:10.903072	\N	\N	\N	\N	\N	76	1	5
52	2025-08-17 16:00:00.651931	\N	\N	\N	\N	\N	77	1	5
53	2025-08-17 16:16:25.835936	\N	\N	\N	\N	\N	78	1	5
54	2025-08-17 16:34:30.24009	\N	\N	\N	\N	\N	79	1	5
55	2025-08-17 16:56:50.7012	\N	\N	\N	\N	\N	80	1	5
56	2025-08-18 16:32:47.541668	\N	\N	\N	\N	\N	81	1	5
57	2025-08-18 16:52:42.014786	\N	\N	\N	\N	\N	82	1	5
58	2025-08-19 18:24:12.459608	\N	\N	\N	\N	\N	42	7	5
62	2025-08-19 18:46:48.770367	\N	\N	\N	\N	\N	84	1	5
63	2025-08-22 19:32:08.839162	\N	\N	\N	\N	\N	85	1	5
64	2025-08-24 12:31:19.288782	\N	\N	\N	\N	\N	87	1	5
66	2025-08-24 15:25:15.440158	\N	\N	\N	\N	\N	89	1	5
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: authorization_schema; Owner: fractal
--

COPY authorization_schema."user" (id, created_date, updated_date, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username, created_user_id, updated_user_id) FROM stdin;
1	2025-07-02 23:54:38.942158	\N	t	t	t	t	$2a$10$/RfTdqEvW3Dlx1PrwnhJT.pd8pGjG6SYduykH/t2YbaGFl4Owhe7a	admin	\N	\N
5	2025-08-01 22:13:19.818526	2025-08-06 14:15:50.284253	t	t	t	t	$2a$10$YJ0ZzKxY0sBjRLAXba9oKe.HzLL2BsQHx9XSZcfr1Buk/QqZO8DE.	test	\N	\N
8	2025-08-19 18:22:15.6488	\N	t	t	t	t	$2a$10$B1uhNRbHeKABRrfKcpRNFeSKbfbhZ98jAHld5Si6sd8ZugIXt/Ma6	operator	\N	\N
\.


--
-- Data for Name: user_role; Type: TABLE DATA; Schema: authorization_schema; Owner: fractal
--

COPY authorization_schema.user_role (id, created_date, updated_date, created_user_id, updated_user_id, role_id, user_id, status_id) FROM stdin;
2	2025-07-19 14:46:04.830608	\N	\N	\N	1	1	5
8	2025-08-07 12:56:40.234011	\N	\N	\N	1	5	5
9	2025-08-19 18:22:57.829353	\N	\N	\N	7	8	5
\.


--
-- Data for Name: citizenship; Type: TABLE DATA; Schema: citizenship_schema; Owner: fractal
--

COPY citizenship_schema.citizenship (id, created_date, updated_date, created_user_id, updated_user_id, country_id) FROM stdin;
6	2025-08-24 16:52:02.412242	\N	\N	\N	3
7	2025-08-24 17:10:47.916521	\N	\N	\N	3
\.


--
-- Data for Name: contact; Type: TABLE DATA; Schema: contact_schema; Owner: fractal
--

COPY contact_schema.contact (id, created_date, updated_date, created_user_id, updated_user_id, value, contact_type_id) FROM stdin;
2	2025-08-04 09:59:17.154626	\N	\N	\N	224600750	1
3	2025-08-04 10:00:09.712153	\N	\N	\N	mycompacn@gmail.com	3
52	2025-08-09 10:16:14.160613	\N	\N	\N	wdqwd	6
5	2025-08-04 12:39:15.288694	2025-08-19 19:01:34.325399	\N	\N	my@mail.tj	3
4	2025-08-04 12:39:03.678907	2025-08-19 19:02:12.71413	\N	\N	+992907907907	1
152	2025-08-22 18:58:20.068909	2025-08-22 18:58:24.276343	\N	\N	2131232123	1
253	2025-08-24 15:37:40.35199	\N	\N	\N	123	1
254	2025-08-24 16:25:58.943313	\N	\N	\N	3213213	1
303	2025-08-24 16:52:02.417023	\N	\N	\N	9876541458	1
304	2025-08-24 17:10:47.926696	\N	\N	\N	988606227	1
\.


--
-- Data for Name: contact_type; Type: TABLE DATA; Schema: contact_schema; Owner: fractal
--

COPY contact_schema.contact_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
1	2025-08-03 17:07:14.630298	\N	PHONE	Phone 	\N	\N
3	2025-08-03 17:09:25.3097	\N	EMAIL	E-mail	\N	\N
5	2025-08-09 10:12:24.22794	\N	TELEGRAM	Telegram	\N	\N
6	2025-08-09 10:14:32.044517	2025-08-09 10:28:49.468703	WHATSAPP	Whatsapp	\N	\N
\.


--
-- Data for Name: email; Type: TABLE DATA; Schema: contact_schema; Owner: fractal
--

COPY contact_schema.email (id, created_date, updated_date, created_user_id, updated_user_id, address) FROM stdin;
\.


--
-- Data for Name: phone; Type: TABLE DATA; Schema: contact_schema; Owner: fractal
--

COPY contact_schema.phone (id, created_date, updated_date, created_user_id, updated_user_id, number, country_id) FROM stdin;
\.


--
-- Data for Name: boolean_type; Type: TABLE DATA; Schema: dictionary_schema; Owner: fractal
--

COPY dictionary_schema.boolean_type (id, created_date, updated_date, code, name, value, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: color; Type: TABLE DATA; Schema: dictionary_schema; Owner: fractal
--

COPY dictionary_schema.color (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: currency; Type: TABLE DATA; Schema: dictionary_schema; Owner: fractal
--

COPY dictionary_schema.currency (id, created_date, updated_date, code, name, numeric_code, created_user_id, updated_user_id, country_id) FROM stdin;
3	2025-08-10 12:05:04.768303	2025-08-12 18:18:25.841654	USD	USD	840	\N	\N	6
5	2025-08-12 18:19:03.466754	\N	TJS	TJS	972	\N	\N	3
6	2025-08-12 18:25:19.508327	\N	RUS	RUS	643	\N	\N	5
\.


--
-- Data for Name: entity_type; Type: TABLE DATA; Schema: dictionary_schema; Owner: fractal
--

COPY dictionary_schema.entity_type (id, created_date, updated_date, code, name, source, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: gender; Type: TABLE DATA; Schema: dictionary_schema; Owner: fractal
--

COPY dictionary_schema.gender (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
1	2025-05-29 17:10:33.280328	\N	MALE	Male	\N	\N
20	2025-07-23 13:19:09.345149	2025-07-23 14:23:21.633183	FEMALE	Female	\N	\N
\.


--
-- Data for Name: marital_status; Type: TABLE DATA; Schema: dictionary_schema; Owner: fractal
--

COPY dictionary_schema.marital_status (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
2	2025-07-11 13:49:09.281419	2025-07-13 07:37:57.039635	MARRIED	Married	\N	\N
5	2025-07-13 08:44:18.466877	\N	UNMARRIED	Unmarried	\N	\N
8	2025-08-30 17:54:54.413963	\N	SINGLE	SINGLE	\N	\N
\.


--
-- Data for Name: nationality; Type: TABLE DATA; Schema: dictionary_schema; Owner: fractal
--

COPY dictionary_schema.nationality (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
1	2025-08-23 12:57:33.626708	\N	TAJIK	Tajik	\N	\N
\.


--
-- Data for Name: notification_template; Type: TABLE DATA; Schema: dictionary_schema; Owner: fractal
--

COPY dictionary_schema.notification_template (id, created_date, updated_date, code, name, description, key_words, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: priority; Type: TABLE DATA; Schema: dictionary_schema; Owner: fractal
--

COPY dictionary_schema.priority (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: profile_attribute; Type: TABLE DATA; Schema: dictionary_schema; Owner: fractal
--

COPY dictionary_schema.profile_attribute (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: status; Type: TABLE DATA; Schema: dictionary_schema; Owner: fractal
--

COPY dictionary_schema.status (id, created_date, updated_date, code, name, description, created_user_id, updated_user_id, status_category_id) FROM stdin;
3	2025-07-13 10:26:27.059726	2025-07-17 14:04:07.778756	CLOSE	Close	fwefef	\N	\N	4
5	2025-07-19 14:42:47.646154	\N	ACTIVE	Active	Active	\N	\N	4
\.


--
-- Data for Name: status_category; Type: TABLE DATA; Schema: dictionary_schema; Owner: fractal
--

COPY dictionary_schema.status_category (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
2	2025-07-13 09:40:51.556071	\N	TRANS	Transaction	\N	\N
4	2025-07-13 10:19:21.518855	2025-07-18 10:49:50.505832	OTHER	Other	\N	\N
\.


--
-- Data for Name: week_day; Type: TABLE DATA; Schema: dictionary_schema; Owner: fractal
--

COPY dictionary_schema.week_day (id, created_date, updated_date, code, name, index, created_user_id, updated_user_id) FROM stdin;
1	2025-08-23 12:49:40.207517	\N	MONDAY	Monday	1	\N	\N
2	2025-08-23 12:51:40.257641	\N	TUESDAY	Tuesday	2	\N	\N
3	2025-08-23 12:52:05.543216	\N	WEDNESDAY	Wednesday	3	\N	\N
4	2025-08-23 12:52:42.709861	\N	THURSDAY	Thursday	4	\N	\N
5	2025-08-23 12:53:00.922916	\N	FRIDAY	Friday	5	\N	\N
6	2025-08-23 12:53:18.42638	\N	SATURDAY	Saturday	6	\N	\N
7	2025-08-23 12:53:38.251594	\N	SUNDAY	Sunday	7	\N	\N
\.


--
-- Data for Name: accreditation_status; Type: TABLE DATA; Schema: education_schema; Owner: fractal
--

COPY education_schema.accreditation_status (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
2	2025-08-17 16:18:03.965676	\N	ACC	Accredited	\N	\N
3	2025-08-17 16:18:14.038808	\N	PROV	Provisionally Accredited	\N	\N
4	2025-08-17 16:18:24.751865	\N	CAND	Candidate for Accreditation	\N	\N
5	2025-08-17 16:18:35.532319	\N	NOT	Not Accredited	\N	\N
6	2025-08-17 16:18:43.870741	\N	REV	Revoked	\N	\N
7	2025-08-17 16:18:51.737219	\N	EXP	Expired	\N	\N
8	2025-08-17 16:19:03.952253	\N	PEND	Pending Review	\N	\N
\.


--
-- Data for Name: degree_type; Type: TABLE DATA; Schema: education_schema; Owner: fractal
--

COPY education_schema.degree_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
1	2025-08-17 15:15:27.085902	\N	BACHELOR	Bachelor's Degree	\N	\N
2	2025-08-17 15:15:38.860504	\N	DOCTRAL	Doctoral Degree	\N	\N
3	2025-08-17 15:15:51.20632	\N	PROFESSSIONAL	Professional Degree	\N	\N
4	2025-08-17 15:16:04.659878	\N	CERTIFICATE	Certificate	\N	\N
\.


--
-- Data for Name: education; Type: TABLE DATA; Schema: education_schema; Owner: fractal
--

COPY education_schema.education (id, created_date, updated_date, begin_date, document_verified, end_date, institution_address, institution_name, is_foreign_institution, specialization, verification_notes, created_user_id, updated_user_id, accreditation_status_id, degree_type_id, education_document_type_id, education_type_id, grade_point_average_id, status_id) FROM stdin;
4	2025-08-24 16:52:02.417023	\N	2025-06-11	t	2025-12-30	Осими	Осими	f	Программист	вцвйц	\N	\N	2	1	3	4	3	5
5	2025-08-24 17:10:47.926696	\N	2025-08-06	t	2025-12-23	ТУТ	ТУТ	f	ТИ	пукпк	\N	\N	3	1	3	3	3	5
\.


--
-- Data for Name: education_document_type; Type: TABLE DATA; Schema: education_schema; Owner: fractal
--

COPY education_schema.education_document_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
1	2025-08-17 16:01:19.396766	\N	ATTESTAT	Аттестат	\N	\N
2	2025-08-17 16:01:34.919974	2025-08-17 16:01:43.737316	CERTIFICATE	Сертификат	\N	\N
3	2025-08-17 16:01:58.182849	\N	DIPBACH	Диплом бакалавра	\N	\N
4	2025-08-17 16:02:09.302092	\N	DIPMASTER	Диплом магистра	\N	\N
5	2025-08-17 16:02:23.024842	\N	SCINES	Диплом кандидата	\N	\N
\.


--
-- Data for Name: education_resource; Type: TABLE DATA; Schema: education_schema; Owner: fractal
--

COPY education_schema.education_resource (id, education_id) FROM stdin;
\.


--
-- Data for Name: education_type; Type: TABLE DATA; Schema: education_schema; Owner: fractal
--

COPY education_schema.education_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
2	2025-08-17 14:55:59.538616	\N	MIDDLESPEC	средне-специальное	\N	\N
3	2025-08-17 14:56:10.74036	\N	HIGHEDU	высшее	\N	\N
4	2025-08-17 14:56:22.985986	\N	BACHAR	бакалавр	\N	\N
1	2025-08-17 14:55:43.795491	2025-08-30 17:58:43.080069	MIDDLEEDU	миёна	\N	\N
5	2025-08-17 14:56:34.890718	2025-08-30 17:58:57.672116	MASTER	мастер	\N	\N
\.


--
-- Data for Name: grade_point_average; Type: TABLE DATA; Schema: education_schema; Owner: fractal
--

COPY education_schema.grade_point_average (id, created_date, updated_date, scale, value, created_user_id, updated_user_id) FROM stdin;
2	2025-08-17 16:37:07.259041	\N	5	A	\N	\N
3	2025-08-17 16:37:20.961411	\N	4	B	\N	\N
4	2025-08-17 16:38:08.543568	\N	3	C	\N	\N
5	2025-08-17 16:38:19.791136	\N	2	D	\N	\N
6	2025-08-17 16:38:31.000262	\N	0	F	\N	\N
\.


--
-- Data for Name: absence; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.absence (id, created_date, updated_date, duration, end_date, reason, remarks, start_date, created_user_id, updated_user_id, absence_type_id, employee_id) FROM stdin;
\.


--
-- Data for Name: absence_type; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.absence_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: agreement; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.agreement (id, created_date, updated_date, end_date, number, start_date, created_user_id, updated_user_id, employment_history_id, status_id) FROM stdin;
\.


--
-- Data for Name: agreement_resource; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.agreement_resource (id, agreement_id) FROM stdin;
\.


--
-- Data for Name: attendance; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.attendance (id, created_date, updated_date, date, end_time, hours_worked, overtime_hours, remarks, start_time, created_user_id, updated_user_id, employee_id, status_id) FROM stdin;
\.


--
-- Data for Name: business_trip; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.business_trip (id, created_date, updated_date, description, end_date, order_date, order_number, start_date, created_user_id, updated_user_id, employee_id, organization_id, status_id, approved_date, reviewed_date, days, location, purpose, approved_user_id, reviewed_user_id, business_trip_type_id) FROM stdin;
\.


--
-- Data for Name: business_trip_order; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.business_trip_order (number, id, business_trip_id) FROM stdin;
\.


--
-- Data for Name: business_trip_resource; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.business_trip_resource (id, business_trip_id) FROM stdin;
\.


--
-- Data for Name: business_trip_type; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.business_trip_type (id, created_date, updated_date, code, name, description, created_user_id, updated_user_id) FROM stdin;
3	2025-08-10 11:47:28.203639	2025-08-16 17:06:06.80845	OKKK	okkkk update	okkkk	\N	\N
\.


--
-- Data for Name: category; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.category (id, created_date, updated_date, code, name, created_user_id, updated_user_id, index) FROM stdin;
1	2025-07-13 07:00:11.688298	2025-07-18 10:50:00.583354	TAJIK	Tajik	\N	\N	\N
7	2025-08-14 14:27:57.66887	2025-08-23 12:45:29.40023	RUSSIA	RussiaAA	\N	\N	1
\.


--
-- Data for Name: citizenship; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.citizenship (id, created_date, updated_date, created_user_id, updated_user_id, country_id) FROM stdin;
\.


--
-- Data for Name: degree_type; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.degree_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.employee (id, created_date, updated_date, birth_date, first_name, last_name, patronymic_name, ssn, tin, created_user_id, updated_user_id, country_id, employee_id, gender_id, marital_status_id, nationality_id, status_id) FROM stdin;
\.


--
-- Data for Name: employee_address; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.employee_address (id, employee_id) FROM stdin;
\.


--
-- Data for Name: employee_citizenship; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.employee_citizenship (id, employee_id) FROM stdin;
\.


--
-- Data for Name: employee_contact; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.employee_contact (id, employee_id) FROM stdin;
\.


--
-- Data for Name: employee_education; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.employee_education (id, employee_id) FROM stdin;
\.


--
-- Data for Name: employee_identification_document; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.employee_identification_document (id, employee_id) FROM stdin;
\.


--
-- Data for Name: employee_military_service; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.employee_military_service (id, employee_id) FROM stdin;
\.


--
-- Data for Name: employee_resource; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.employee_resource (id, employee_id) FROM stdin;
\.


--
-- Data for Name: employee_work_experience; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.employee_work_experience (id, employee_id) FROM stdin;
\.


--
-- Data for Name: employment_history; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.employment_history (id, created_date, updated_date, end_date, order_date, order_number, serial, start_date, created_user_id, updated_user_id, department_id, employee_id, employment_type_id, organization_id, position_id, status_id) FROM stdin;
\.


--
-- Data for Name: employment_history_order; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.employment_history_order (number, id, employment_history_id) FROM stdin;
\.


--
-- Data for Name: identification_document_resource; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.identification_document_resource (id, identification_document_id) FROM stdin;
\.


--
-- Data for Name: improvement_area; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.improvement_area (id, created_date, updated_date, action_plan, area_name, description, target_date, created_user_id, updated_user_id, performance_id, status_id) FROM stdin;
\.


--
-- Data for Name: military_data; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.military_data (id, created_date, updated_date, account_number, address, begin_date, category_fund, end_date, image, title, created_user_id, updated_user_id, employee_id) FROM stdin;
\.


--
-- Data for Name: military_service_resource; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.military_service_resource (id, military_service_id) FROM stdin;
\.


--
-- Data for Name: order; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema."order" (id, created_date, updated_date, approved_date, reviewed_date, date, created_user_id, updated_user_id, approved_user_id, reviewed_user_id, order_type_id) FROM stdin;
\.


--
-- Data for Name: order_resource; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.order_resource (id, order_id) FROM stdin;
\.


--
-- Data for Name: order_type; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.order_type (id, created_date, updated_date, code, name, description, created_user_id, updated_user_id) FROM stdin;
2	2025-08-18 16:22:21.12408	\N	ACCEPT	Ба кор кабул намудани корманд	Фармон ->>>Ба кор кабул намудани корманд	\N	\N
3	2025-08-18 16:22:38.989348	\N	DECIAML	Аз кор озод намудани корманд	Фармон ->>>Аз кор озод намудани корманд	\N	\N
4	2025-08-18 16:23:11.026703	\N	ANNUALLEAVE	Рухсати мехнати солона	Фармон ->>>Рухсати мехнати солона	\N	\N
5	2025-08-18 16:23:27.475704	\N	WEEKENDDAY	Рузи Истирохат	Фармон ->>>Рузи Истирохат	\N	\N
6	2025-08-18 16:23:42.395593	\N	TRANSFER	Ротатсиякунонии кормандон	Фармон ->>>Ротатсиякунонии кормандон	\N	\N
7	2025-08-18 16:24:00.972391	\N	RETURNEMP	Бозхонди рухсати мехнати	Фармон ->>>Бозхонди рухсати мехнати	\N	\N
\.


--
-- Data for Name: performance; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.performance (id, created_date, updated_date, comments, date, rating, review_period_end, review_period_start, created_user_id, updated_user_id, employee_id, performance_type_id, reviewer_employee_id, status_id) FROM stdin;
\.


--
-- Data for Name: performance_goal; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.performance_goal (id, created_date, updated_date, goal_achieved, achievement_date, description, remarks, created_user_id, updated_user_id, performance_id) FROM stdin;
\.


--
-- Data for Name: performance_type; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.performance_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
6	2025-08-24 17:38:17.193919	\N	WWDDW	dqwd	\N	\N
\.


--
-- Data for Name: relation_type; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.relation_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
3	2025-08-18 16:25:10.551509	\N	BROTHER	Бародар	\N	\N
4	2025-08-18 16:25:20.328903	\N	SISTER	Хохар	\N	\N
5	2025-08-18 16:25:29.825205	\N	SON	Писар	\N	\N
6	2025-08-18 16:25:40.384062	\N	FATHER	Падар	\N	\N
7	2025-08-18 16:25:49.088717	\N	MOTHER	Модар	\N	\N
8	2025-08-18 16:26:09.484115	\N	HUSBAND	Шавхар	\N	\N
9	2025-08-18 16:26:17.418447	\N	WIFE	Хамсар	\N	\N
\.


--
-- Data for Name: relative; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.relative (id, created_date, updated_date, birth_date, first_name, last_name, patronymic_name, ssn, tin, created_user_id, updated_user_id, gender_id, marital_status_id, nationality_id, employee_id, relation_type_id) FROM stdin;
\.


--
-- Data for Name: relative_address; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.relative_address (id, relative_id) FROM stdin;
\.


--
-- Data for Name: relative_contact; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.relative_contact (id, relative_id) FROM stdin;
\.


--
-- Data for Name: subordinate; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.subordinate (id, created_date, updated_date, end_date, start_date, created_user_id, updated_user_id, employee_id, status_id, subordinate_employee_id, subordinate_type_id) FROM stdin;
\.


--
-- Data for Name: subordinate_type; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.subordinate_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
5	2025-08-14 18:57:42.942007	\N	WDWD	dqwd	\N	\N
\.


--
-- Data for Name: vacation; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.vacation (id, created_date, updated_date, description, end_date, order_date, order_number, start_date, created_user_id, updated_user_id, employee_id, status_id, successor_employee_id, vacation_category_id, vacation_type_id, days) FROM stdin;
\.


--
-- Data for Name: vacation_category; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.vacation_category (id, created_date, updated_date, code, name, description, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: vacation_type; Type: TABLE DATA; Schema: employee_schema; Owner: fractal
--

COPY employee_schema.vacation_type (id, created_date, updated_date, code, name, description, created_user_id, updated_user_id) FROM stdin;
3	2025-08-18 16:29:12.67469	\N	ANNUALLEAVE	Рухсатии Солона	Рухсатии меҳнатии ҳарсола (бо маош)	\N	\N
\.


--
-- Data for Name: employment_type; Type: TABLE DATA; Schema: employment_schema; Owner: fractal
--

COPY employment_schema.employment_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
1	2025-08-17 13:56:57.128469	\N	PERMANENT	Permanent	\N	\N
3	2025-08-17 13:57:37.304503	\N	CONTRACT	Contract	\N	\N
\.


--
-- Data for Name: work_experience; Type: TABLE DATA; Schema: employment_schema; Owner: fractal
--

COPY employment_schema.work_experience (id, created_date, updated_date, end_date, start_date, achievements, separationReason, division, leave_reason, location, organization, "position", responsibilities, created_user_id, updated_user_id, employment_type_id, country_id, status_id) FROM stdin;
5	2025-08-24 16:52:02.438169	\N	2025-12-03	2025-08-06	цйв	цйв	йцв	цйв	вйцв	йцв	цв	йцв	\N	\N	1	3	5
6	2025-08-24 17:10:47.949779	\N	2025-11-19	2025-08-06	new projects	IT	Support	working now	Душанбе	FMFB	Manager of support IT	Manager	\N	\N	1	3	5
\.


--
-- Data for Name: identification_document; Type: TABLE DATA; Schema: identification_schema; Owner: fractal
--

COPY identification_schema.identification_document (id, created_date, updated_date, expiry_date, issue_date, issue_organization, issue_organization_address, number, series, term_in_years, created_user_id, updated_user_id, identification_type_id, status_id) FROM stdin;
6	2025-08-24 16:52:02.427635	\N	2025-12-31	2025-08-06	Ишкошим	Ишкошим	442343443	A	0	\N	\N	1	5
7	2025-08-24 17:10:47.936672	\N	2025-10-22	2025-08-05	ШВКД Сино2	ШВКД Сино2	32432434	А	0	\N	\N	1	5
\.


--
-- Data for Name: identification_document_type; Type: TABLE DATA; Schema: identification_schema; Owner: fractal
--

COPY identification_schema.identification_document_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
1	2025-08-17 17:05:40.962184	\N	PASSWORD	Паспорт	\N	\N
2	2025-08-17 17:05:58.549509	\N	NATIDCARD	Национальное удостоверение личности	\N	\N
3	2025-08-17 17:06:19.118233	\N	MILITARYID	Военный билет	\N	\N
4	2025-08-17 17:06:43.777461	\N	RESIDANCEPERMIT	Вид на жительство	\N	\N
\.


--
-- Data for Name: language; Type: TABLE DATA; Schema: localization_schema; Owner: fractal
--

COPY localization_schema.language (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
1	2025-07-12 16:20:30.957583	\N	TJ	Tajik	\N	\N
2	2025-07-12 16:20:47.92657	\N	RU	Russian	\N	\N
3	2025-07-12 16:21:01.768475	2025-08-06 09:17:11.35354	EN	English	\N	\N
\.


--
-- Data for Name: layout_label; Type: TABLE DATA; Schema: localization_schema; Owner: fractal
--

COPY localization_schema.layout_label (id, created_date, updated_date, name, created_user_id, updated_user_id) FROM stdin;
1	2025-07-12 16:24:00.285488	\N	action	\N	\N
2	2025-07-23 11:46:08.852311	\N	create	\N	\N
3	2025-07-23 11:47:24.876854	\N	update	\N	\N
4	2025-07-23 11:47:58.876789	\N	delete	\N	\N
5	2025-07-23 11:57:41.354478	\N	dictionaries	\N	\N
6	2025-07-23 11:58:32.951626	\N	gender	\N	\N
7	2025-07-23 13:04:07.877673	\N	marital_status	\N	\N
8	2025-07-23 13:40:54.706919	\N	add	\N	\N
9	2025-07-23 13:41:42.335986	\N	edit	\N	\N
10	2025-07-24 12:43:23.732524	\N	navigation	\N	\N
11	2025-07-24 12:43:53.442304	\N	menu	\N	\N
12	2025-07-24 12:44:53.182053	\N	action	\N	\N
13	2025-07-24 12:46:02.195677	\N	user	\N	\N
14	2025-07-24 12:47:07.614837	\N	role	\N	\N
15	2025-07-24 12:50:41.401548	\N	authorization	\N	\N
17	2025-07-27 13:19:20.457171	\N	language	\N	\N
18	2025-07-27 13:39:25.92745	\N	localization	\N	\N
19	2025-07-27 13:40:03.100223	\N	layout_label	\N	\N
20	2025-07-27 13:42:38.330148	\N	layout_label_detail	\N	\N
21	2025-07-27 13:43:29.690507	\N	permission	\N	\N
22	2025-07-27 13:44:35.585587	\N	action_category	\N	\N
23	2025-07-27 13:45:05.203625	\N	action_type	\N	\N
24	2025-07-27 14:08:48.550731	\N	role_menu	\N	\N
25	2025-07-27 14:09:15.191485	\N	menu_action	\N	\N
26	2025-07-28 12:05:01.312414	\N	nationality	\N	\N
27	2025-07-28 12:18:54.431101	\N	status_category	\N	\N
28	2025-07-28 13:46:30.603149	\N	location	\N	\N
29	2025-07-28 13:50:33.441043	\N	address_type	\N	\N
30	2025-07-28 14:16:03.77109	\N	region	\N	\N
31	2025-07-28 14:43:59.911687	\N	district	\N	\N
32	2025-07-29 13:06:20.835828	\N	country	\N	\N
33	2025-07-29 13:39:52.620618	\N	city	\N	\N
34	2025-07-29 14:09:10.120034	\N	status	\N	\N
35	2025-07-31 12:28:41.33393	2025-07-31 12:29:22.685526	reset_password	\N	\N
36	2025-07-31 13:59:53.38682	\N	change_password	\N	\N
37	2025-08-01 10:30:40.832937	\N	organization_management	\N	\N
38	2025-08-01 10:31:15.031298	\N	separationReason	\N	\N
39	2025-08-01 10:31:40.433484	\N	position	\N	\N
40	2025-08-01 10:31:53.678408	\N	job_description	\N	\N
41	2025-08-01 10:32:10.51423	\N	organization	\N	\N
42	2025-08-01 10:32:23.162462	\N	organization_unit	\N	\N
43	2025-08-03 16:58:53.341752	\N	contact_type	\N	\N
44	2025-08-05 12:40:35.448297	\N	organization_address	\N	\N
45	2025-08-05 12:43:29.579795	\N	organization_contact	\N	\N
46	2025-08-06 13:49:00.405792	2025-08-06 13:49:09.128135	currency	\N	\N
47	2025-08-09 07:41:37.871489	\N	grade	\N	\N
48	2025-08-10 10:24:39.855925	\N	employee_management	\N	\N
49	2025-08-10 10:25:52.951725	\N	business-trip_type	\N	\N
50	2025-08-10 11:34:06.699098	\N	subordinate_type	\N	\N
51	2025-08-10 17:44:03.343919	\N	grade_level	\N	\N
52	2025-08-12 18:33:23.880226	\N	grade_step	\N	\N
53	2025-08-14 14:15:33.794581	\N	reporting_line_type	\N	\N
54	2025-08-14 19:10:19.362396	\N	authority	\N	\N
55	2025-08-15 14:20:19.897185	\N	report_line	\N	\N
56	2025-08-15 14:27:51.999399	\N	accountability	\N	\N
57	2025-08-15 14:36:14.838712	\N	kpi	\N	\N
58	2025-08-15 14:45:42.709107	\N	responsibility	\N	\N
59	2025-08-15 14:47:54.188087	\N	qualification	\N	\N
60	2025-08-15 14:50:13.288869	\N	required-experience	\N	\N
61	2025-08-16 13:16:28.010244	\N	performance_type	\N	\N
62	2025-08-16 16:04:24.751335	\N	vacation_type	\N	\N
63	2025-08-16 17:00:55.395086	\N	relative_type	\N	\N
64	2025-08-16 17:40:20.087153	\N	order_type	\N	\N
65	2025-08-16 17:45:26.175097	\N	identification_document_type	\N	\N
66	2025-08-17 13:53:28.72994	\N	employment_type	\N	\N
67	2025-08-17 14:50:26.10312	\N	education	\N	\N
68	2025-08-17 14:50:53.654799	\N	education_type	\N	\N
69	2025-08-17 15:09:40.46558	\N	degree_type	\N	\N
70	2025-08-17 15:58:27.053643	\N	education_document_type	\N	\N
71	2025-08-17 16:15:16.681822	\N	accreditation_status	\N	\N
72	2025-08-17 16:32:44.371668	\N	grade_point_average	\N	\N
73	2025-08-18 16:30:45.924136	\N	recruitment	\N	\N
74	2025-08-18 16:34:01.601782	\N	candidate	\N	\N
75	2025-08-18 18:15:51.312819	\N	candidate_citizenships	\N	\N
76	2025-08-19 18:44:34.527687	\N	area_type	\N	\N
77	2025-08-22 19:29:18.079324	\N	week_day	\N	\N
78	2025-08-23 16:50:01.609767	\N	work_schedule	\N	\N
79	2025-08-24 12:28:18.369979	\N	interview_type	\N	\N
80	2025-08-24 13:27:31.910965	\N	resource_type	\N	\N
81	2025-08-31 15:17:38.220857	\N	close	\N	\N
\.


--
-- Data for Name: layout_label_detail; Type: TABLE DATA; Schema: localization_schema; Owner: fractal
--

COPY localization_schema.layout_label_detail (id, created_date, updated_date, description, created_user_id, updated_user_id, language_id, layout_label_id) FROM stdin;
2	2025-07-12 16:24:00.744483	\N	Действие	\N	\N	2	1
3	2025-07-12 16:24:00.953958	\N	Action	\N	\N	3	1
91	2025-07-31 14:00:07.690084	\N	Change password	\N	\N	3	36
1	2025-07-12 16:24:00.527488	2025-07-12 16:26:36.256723	Амал	\N	\N	1	1
4	2025-07-23 11:46:09.01519	\N	Сохтан	\N	\N	1	2
5	2025-07-23 11:46:09.042033	\N	Создать	\N	\N	2	2
6	2025-07-23 11:46:09.046312	\N	Create	\N	\N	3	2
7	2025-07-23 11:47:24.87953	\N	Тахрир	\N	\N	1	3
8	2025-07-23 11:47:24.882831	\N	Обновить	\N	\N	2	3
9	2025-07-23 11:47:24.887168	\N	Update	\N	\N	3	3
10	2025-07-23 11:47:58.884985	\N	Хориҷ	\N	\N	1	4
11	2025-07-23 11:47:58.890238	\N	Удалить	\N	\N	2	4
12	2025-07-23 11:47:58.896166	\N	Delete	\N	\N	3	4
13	2025-07-23 11:57:41.357777	\N	Маълумотномаҳо	\N	\N	1	5
14	2025-07-23 11:57:41.360808	\N	Справочники	\N	\N	2	5
15	2025-07-23 11:57:41.363184	\N	Dictionaries	\N	\N	3	5
16	2025-07-23 11:58:32.954746	\N	Ҷинс	\N	\N	1	6
17	2025-07-23 11:58:32.957547	\N	Поль	\N	\N	2	6
18	2025-07-23 11:58:32.960005	\N	Gender	\N	\N	3	6
19	2025-07-23 13:04:07.882032	\N	Аҳволи оилавӣ	\N	\N	1	7
20	2025-07-23 13:04:07.886535	\N	Семейное положение	\N	\N	2	7
21	2025-07-23 13:04:07.889401	\N	Marital status	\N	\N	3	7
22	2025-07-23 13:40:54.713583	\N	Дохилкуни	\N	\N	1	8
23	2025-07-23 13:40:54.722039	\N	Добавить	\N	\N	2	8
24	2025-07-23 13:40:54.727966	\N	Add	\N	\N	3	8
25	2025-07-23 13:41:42.338613	\N	Иваз	\N	\N	1	9
26	2025-07-23 13:41:42.340644	\N	Редактировать	\N	\N	2	9
27	2025-07-23 13:41:42.343869	\N	Edit	\N	\N	3	9
28	2025-07-24 12:43:23.762275	\N	Роҳнамоӣ	\N	\N	1	10
29	2025-07-24 12:43:23.777143	\N	Навигация	\N	\N	2	10
30	2025-07-24 12:43:23.780606	\N	Navigation	\N	\N	3	10
31	2025-07-24 12:43:53.44684	\N	Меню	\N	\N	1	11
32	2025-07-24 12:43:53.450598	\N	Меню	\N	\N	2	11
33	2025-07-24 12:43:53.453217	\N	Menu	\N	\N	3	11
34	2025-07-24 12:44:53.18725	\N	Амал	\N	\N	1	12
35	2025-07-24 12:44:53.191592	\N	Действие	\N	\N	2	12
36	2025-07-24 12:44:53.195424	\N	Action	\N	\N	3	12
37	2025-07-24 12:46:02.199526	\N	Корбар	\N	\N	1	13
38	2025-07-24 12:46:02.206679	\N	Пользователь	\N	\N	2	13
39	2025-07-24 12:46:02.209852	\N	User	\N	\N	3	13
40	2025-07-24 12:47:07.619447	\N	Рол	\N	\N	1	14
41	2025-07-24 12:47:07.623269	\N	Роль	\N	\N	2	14
42	2025-07-24 12:47:07.627591	\N	Role	\N	\N	3	14
43	2025-07-24 12:50:41.406649	\N	Иҷозатнома	\N	\N	1	15
44	2025-07-24 12:50:41.410341	\N	Авторизация	\N	\N	2	15
45	2025-07-24 12:50:41.41298	\N	Authorization	\N	\N	3	15
46	2025-07-27 13:36:01.908922	\N	Language	\N	\N	3	17
47	2025-07-27 13:36:18.423998	\N	Язык	\N	\N	2	17
92	2025-07-31 14:00:21.022705	\N	Изменить пароль	\N	\N	2	36
49	2025-07-27 13:39:41.097163	\N	Localization	\N	\N	3	18
50	2025-07-27 13:40:19.167843	\N	Layout Label	\N	\N	3	19
93	2025-07-31 14:00:33.550234	\N	Ивази рамз	\N	\N	1	36
54	2025-07-27 14:00:37.17219	\N	Забон	\N	\N	1	17
55	2025-07-27 14:05:29.409112	\N	Layout Label Detail	\N	\N	3	20
56	2025-07-27 14:06:06.296525	\N	Permission	\N	\N	3	21
57	2025-07-27 14:06:25.667154	\N	Action Category	\N	\N	3	22
58	2025-07-27 14:06:48.510527	\N	Action Type	\N	\N	3	23
59	2025-07-27 14:09:01.350035	\N	Role Menu	\N	\N	3	24
60	2025-07-27 14:09:30.65086	\N	Menu Action	\N	\N	3	25
61	2025-07-28 12:05:17.971891	\N	Nationality	\N	\N	3	26
62	2025-07-28 12:05:30.629847	\N	Миллат	\N	\N	1	26
63	2025-07-28 12:05:58.444243	\N	Национальность	\N	\N	2	26
64	2025-07-28 12:19:09.138892	\N	Status Category	\N	\N	3	27
65	2025-07-28 12:19:28.765829	\N	Категория статуса	\N	\N	2	27
66	2025-07-28 12:19:43.206726	\N	Категорияи Статус	\N	\N	1	27
67	2025-07-28 13:47:10.566485	\N	Location	\N	\N	3	28
68	2025-07-28 13:47:27.564987	\N	Расположение	\N	\N	2	28
69	2025-07-28 13:47:35.739989	\N	Ҷойгиршавӣ	\N	\N	1	28
70	2025-07-28 13:50:48.313897	\N	Address Type	\N	\N	3	29
71	2025-07-28 13:50:59.571834	\N	Навъи суроға	\N	\N	1	29
72	2025-07-28 13:51:07.765224	\N	Тип адреса	\N	\N	2	29
73	2025-07-28 14:16:18.498072	\N	Region	\N	\N	3	30
74	2025-07-28 14:16:48.324935	\N	Область	\N	\N	2	30
75	2025-07-28 14:16:58.939984	\N	Вилоят	\N	\N	1	30
76	2025-07-28 14:44:08.569269	\N	District	\N	\N	3	31
77	2025-07-28 14:44:24.195545	\N	Округ	\N	\N	2	31
78	2025-07-28 14:44:36.384992	\N	Район	\N	\N	1	31
79	2025-07-29 13:06:30.81424	\N	Country	\N	\N	3	32
80	2025-07-29 13:06:39.349625	\N	Страна	\N	\N	2	32
81	2025-07-29 13:06:47.357972	\N	Мамлакат	\N	\N	1	32
82	2025-07-29 13:40:03.316949	\N	City	\N	\N	3	33
83	2025-07-29 13:40:22.619306	\N	Город	\N	\N	2	33
84	2025-07-29 13:40:30.238794	\N	Шахр	\N	\N	1	33
85	2025-07-29 14:09:48.018252	\N	Status	\N	\N	3	34
86	2025-07-29 14:09:57.31778	\N	Статус	\N	\N	2	34
87	2025-07-29 14:10:03.927526	\N	Холат	\N	\N	1	34
88	2025-07-31 12:29:36.10709	\N	Reset Password	\N	\N	3	35
89	2025-07-31 12:29:58.420976	\N	Cбросить пароль	\N	\N	2	35
90	2025-07-31 12:30:09.91843	\N	Ивази рамз	\N	\N	1	35
94	2025-08-01 10:31:02.098332	\N	Organization Management	\N	\N	3	37
95	2025-08-01 10:31:31.132322	\N	Department	\N	\N	3	38
96	2025-08-01 10:32:38.352881	\N	Position	\N	\N	3	39
97	2025-08-01 10:33:03.668677	\N	Job Description	\N	\N	3	40
98	2025-08-01 10:33:19.794294	\N	Organization	\N	\N	3	41
99	2025-08-01 10:34:03.966567	\N	Organization Unit	\N	\N	3	42
100	2025-08-03 16:59:10.092615	\N	Contact Type	\N	\N	3	43
101	2025-08-04 12:49:24.727439	\N	Сохтори 	\N	\N	1	42
102	2025-08-05 12:41:40.194803	\N	Organization Address	\N	\N	3	44
103	2025-08-05 12:43:46.244459	\N	Organization Contact	\N	\N	3	45
104	2025-08-06 13:49:18.928034	\N	Currency	\N	\N	3	46
105	2025-08-06 13:49:28.739143	\N	Валюта	\N	\N	2	46
107	2025-08-09 07:41:54.374662	\N	Grade	\N	\N	3	47
108	2025-08-09 07:42:07.765474	\N	Грид	\N	\N	2	47
109	2025-08-09 07:42:11.755957	\N	Грид	\N	\N	1	47
106	2025-08-06 13:49:35.206151	2025-08-09 10:06:12.24206	Маблаг	\N	\N	1	46
110	2025-08-10 10:24:55.54475	\N	Employee Management	\N	\N	3	48
111	2025-08-10 10:25:13.202809	\N	ru employee management	\N	\N	2	48
112	2025-08-10 10:25:20.491949	\N	tj employee-management	\N	\N	1	48
113	2025-08-10 10:26:11.766948	\N	Business Trip Type	\N	\N	3	49
114	2025-08-10 10:26:18.898248	\N	ru business-trip/type	\N	\N	2	49
115	2025-08-10 10:26:25.23635	\N	tj business-trip/type	\N	\N	1	49
116	2025-08-10 11:34:19.773506	\N	Subordinate Type	\N	\N	3	50
117	2025-08-10 11:34:26.906904	\N	ru subordinate-type	\N	\N	2	50
118	2025-08-10 11:34:33.023471	\N	tj subordinate-type	\N	\N	1	50
119	2025-08-10 17:45:23.761876	\N	Grade Level	\N	\N	3	51
120	2025-08-10 17:45:33.922156	\N	ru Grade Level	\N	\N	2	51
121	2025-08-10 17:45:40.704193	\N	Grade Level	\N	\N	1	51
122	2025-08-12 18:34:00.705717	\N	Grade Step	\N	\N	3	52
123	2025-08-12 18:34:10.746048	\N	ru Grade Step	\N	\N	2	52
124	2025-08-12 18:34:20.036191	\N	tj Grade Step	\N	\N	1	52
125	2025-08-14 14:15:46.840414	\N	Reporting line type	\N	\N	3	53
126	2025-08-14 14:15:53.450834	\N	ru reporting-line-type	\N	\N	2	53
127	2025-08-14 14:15:59.903688	\N	tj reporting-line-type	\N	\N	1	53
128	2025-08-14 19:10:28.501732	\N	Authority	\N	\N	3	54
129	2025-08-14 19:10:36.625241	\N	Ru Authority	\N	\N	2	54
130	2025-08-14 19:10:42.315941	\N	TJ Authority	\N	\N	1	54
131	2025-08-15 14:20:32.941237	\N	Report Line	\N	\N	3	55
132	2025-08-15 14:20:38.7981	\N	ru Report Line	\N	\N	2	55
133	2025-08-15 14:20:44.611948	\N	tj Report Line	\N	\N	1	55
134	2025-08-15 14:28:04.928263	\N	Accountability	\N	\N	3	56
135	2025-08-15 14:28:10.915853	\N	ru accountability	\N	\N	2	56
136	2025-08-15 14:28:16.621899	\N	tj accountability	\N	\N	1	56
137	2025-08-15 14:36:24.890694	\N	KPI	\N	\N	3	57
138	2025-08-15 14:36:30.405773	\N	ru kpi	\N	\N	2	57
139	2025-08-15 14:36:35.929373	\N	tj kpi	\N	\N	1	57
140	2025-08-15 14:45:57.000526	\N	Responsibility	\N	\N	3	58
141	2025-08-15 14:46:00.937385	\N	responsibility	\N	\N	2	58
142	2025-08-15 14:46:04.323059	\N	responsibility	\N	\N	1	58
143	2025-08-15 14:48:02.971729	\N	Qualification	\N	\N	3	59
144	2025-08-15 14:48:08.072024	\N	qualification	\N	\N	2	59
145	2025-08-15 14:48:11.812117	\N	qualification	\N	\N	1	59
146	2025-08-15 14:50:25.894332	\N	Required Experience	\N	\N	3	60
147	2025-08-15 14:50:29.80213	\N	required-experience	\N	\N	2	60
148	2025-08-15 14:50:33.54178	\N	required-experience	\N	\N	1	60
149	2025-08-16 13:17:09.729884	\N	производительность	\N	\N	2	61
151	2025-08-16 13:17:42.302102	\N	cffdfsfsfds	\N	\N	1	61
150	2025-08-16 13:17:25.57801	2025-08-16 13:35:38.073181	Performance Type	\N	\N	3	61
152	2025-08-16 16:04:41.466368	\N	Vacation type	\N	\N	3	62
153	2025-08-16 16:04:47.386702	\N	vacation-type	\N	\N	2	62
154	2025-08-16 16:04:53.582975	\N	vacation-type	\N	\N	1	62
155	2025-08-16 17:01:06.961185	\N	Relative type	\N	\N	3	63
156	2025-08-16 17:01:11.838271	\N	relative_type	\N	\N	2	63
157	2025-08-16 17:01:15.807203	\N	relative_type	\N	\N	1	63
158	2025-08-16 17:40:44.866301	\N	Order Type	\N	\N	3	64
159	2025-08-16 17:40:50.672762	2025-08-16 17:40:55.024513	order_type	\N	\N	2	64
160	2025-08-16 17:40:59.110603	\N	order_type	\N	\N	1	64
161	2025-08-16 17:45:43.702835	\N	Identification document type	\N	\N	3	65
162	2025-08-16 17:45:47.949818	\N	identification-document-type	\N	\N	2	65
163	2025-08-16 17:45:51.548382	\N	identification-document-type	\N	\N	1	65
164	2025-08-17 13:53:46.733478	\N	Employment Type	\N	\N	3	66
165	2025-08-17 13:53:52.128126	\N	Employment Type	\N	\N	2	66
166	2025-08-17 13:53:56.425212	\N	Employment Type	\N	\N	1	66
167	2025-08-17 14:50:36.256017	\N	Education	\N	\N	3	67
168	2025-08-17 14:50:40.267134	\N	Education	\N	\N	2	67
169	2025-08-17 14:50:43.649289	\N	Education	\N	\N	1	67
170	2025-08-17 14:51:04.871437	\N	Education Type	\N	\N	3	68
171	2025-08-17 14:51:09.383246	\N	Education Type	\N	\N	2	68
172	2025-08-17 14:51:14.62906	\N	Education Type	\N	\N	1	68
173	2025-08-17 15:09:54.399215	\N	Degree Type	\N	\N	3	69
174	2025-08-17 15:09:58.691397	\N	degree_type	\N	\N	2	69
175	2025-08-17 15:10:02.190475	\N	degree_type	\N	\N	1	69
176	2025-08-17 15:58:43.25522	\N	Education Document Type	\N	\N	3	70
177	2025-08-17 15:58:47.981919	\N	education_document_type	\N	\N	2	70
178	2025-08-17 15:58:51.776502	\N	education_document_type	\N	\N	1	70
179	2025-08-17 16:15:23.739232	\N	Accreditation Status	\N	\N	3	71
180	2025-08-17 16:15:27.51243	\N	Accreditation Status	\N	\N	2	71
181	2025-08-17 16:15:30.738015	\N	Accreditation Status	\N	\N	1	71
182	2025-08-17 16:32:58.66025	\N	Grade Point Average	\N	\N	3	72
183	2025-08-17 16:33:03.678348	\N	grade-point-average	\N	\N	2	72
184	2025-08-17 16:33:07.579787	\N	grade-point-average	\N	\N	1	72
185	2025-08-18 16:30:55.81123	\N	Recruitment	\N	\N	3	73
186	2025-08-18 16:30:59.986293	\N	recruitment	\N	\N	2	73
187	2025-08-18 16:31:03.571061	\N	recruitment	\N	\N	1	73
188	2025-08-18 16:34:08.930965	\N	Candidate	\N	\N	3	74
189	2025-08-18 16:34:13.129091	\N	Candidate	\N	\N	2	74
190	2025-08-18 16:34:16.493386	\N	Candidate	\N	\N	1	74
191	2025-08-18 18:16:11.98498	\N	Candidate Citizenship	\N	\N	3	75
192	2025-08-18 18:16:18.047085	\N	candidate_citizenships	\N	\N	2	75
193	2025-08-18 18:16:22.122953	\N	candidate_citizenships	\N	\N	1	75
194	2025-08-19 18:44:46.474057	\N	Area type	\N	\N	3	76
195	2025-08-19 18:45:00.274295	\N	area_type	\N	\N	2	76
196	2025-08-19 18:45:04.715457	\N	area_type	\N	\N	1	76
197	2025-08-22 19:29:40.684001	\N	Рузи истирохат	\N	\N	1	77
199	2025-08-22 19:30:12.125243	\N	варҷвоарҷв	\N	\N	2	77
198	2025-08-22 19:30:00.649141	2025-08-23 12:43:02.248155	Week Day	\N	\N	3	77
200	2025-08-23 16:50:11.479813	\N	Work schedule	\N	\N	3	78
201	2025-08-23 16:50:15.361456	\N	work_schedule	\N	\N	2	78
202	2025-08-23 16:50:19.87271	\N	work_schedule	\N	\N	1	78
203	2025-08-24 12:28:31.071076	\N	dsfdfs	\N	\N	1	79
204	2025-08-24 12:28:36.960908	\N	sdfsdfsdfsdf	\N	\N	2	79
205	2025-08-24 12:29:00.709376	\N	Interview Type	\N	\N	3	79
206	2025-08-24 13:27:52.146298	\N	Resource Type	\N	\N	3	80
207	2025-08-24 13:27:58.960733	\N	rerfreccrc	\N	\N	1	80
208	2025-08-24 13:28:06.737892	\N	rferferfrfre	\N	\N	2	80
209	2025-08-31 15:17:46.541945	\N	Close	\N	\N	3	81
210	2025-08-31 15:17:57.184925	\N	Закрыть	\N	\N	2	81
211	2025-08-31 15:18:04.734062	\N	Махкам	\N	\N	1	81
\.


--
-- Data for Name: address; Type: TABLE DATA; Schema: location_schema; Owner: fractal
--

COPY location_schema.address (id, created_date, updated_date, apartment, building_number, end_date, floor_number, house, latitude, longitude, postal_code, start_date, street, created_user_id, updated_user_id, address_type_id, city_id, country_id, district_id, region_id) FROM stdin;
1	2025-08-02 11:21:49.158096	\N	aprt	125	\N	12	house	454646464646	464646466464646	1321564646	2025-08-02	ghdfhkd	\N	\N	3	5	3	3	4
52	2025-08-02 19:22:40.877045	2025-08-02 20:40:56.431447	aptrt	12	2025-09-05	32	fghfdhgk	46464646	46464646	4664646	2025-08-15	Street update	\N	\N	3	5	3	3	4
152	2025-08-04 10:01:26.559173	\N	12	322	\N	33	fdfdf	4464646	44646464646	765245464646	2025-09-04	dfgdsdf	\N	\N	3	5	3	3	4
153	2025-08-04 13:52:50.525679	2025-08-04 14:00:42.830751	4dsfsd	12	2025-09-05	3	dsfdsfsdf	4646464646	79864646464	7464646	2025-09-04	sdfsfsdf	\N	\N	3	5	3	3	4
353	2025-08-24 15:37:40.350988	\N	123	123	2025-10-28	123	123	213	12323	213	2025-08-05	3123	\N	\N	3	5	3	3	4
403	2025-08-24 17:10:47.915995	\N	12	\N	\N	\N	100	\N	\N	\N	\N	Неъмат Карабов	\N	\N	3	6	3	3	4
\.


--
-- Data for Name: address_type; Type: TABLE DATA; Schema: location_schema; Owner: fractal
--

COPY location_schema.address_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
3	2025-07-15 09:05:29.149532	2025-08-14 14:29:07.603927	REGISTRATION	Регистрация	\N	\N
5	2025-07-18 10:49:25.731305	2025-08-14 14:29:16.308302	FACT	Фактический	\N	\N
7	2025-08-14 14:29:27.363019	\N	TEMPORARYREG	Временная регистрация	\N	\N
8	2025-08-14 14:29:34.905835	\N	OTHER	Дополнительный	\N	\N
\.


--
-- Data for Name: area_type; Type: TABLE DATA; Schema: location_schema; Owner: fractal
--

COPY location_schema.area_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
1	2025-08-19 18:58:50.139202	\N	ADMIN	Роҳбарият	\N	\N
3	2025-08-19 19:23:59.558431	\N	HRR	Кадр	\N	\N
\.


--
-- Data for Name: city; Type: TABLE DATA; Schema: location_schema; Owner: fractal
--

COPY location_schema.city (id, created_date, updated_date, code, name, created_user_id, updated_user_id, region_id, area_type_id) FROM stdin;
4	2025-07-16 13:41:49.45795	2025-07-16 13:44:11.181922	JBALKHI	Чалолиддини Руми	\N	\N	3	1
5	2025-07-16 13:42:01.436512	2025-07-16 13:44:30.66304	KHUJAND	Хучанд	\N	\N	4	1
6	2025-07-16 13:42:13.807187	2025-08-19 19:13:42.651075	BUSTON	Бустон	\N	\N	5	1
\.


--
-- Data for Name: country; Type: TABLE DATA; Schema: location_schema; Owner: fractal
--

COPY location_schema.country (id, created_date, updated_date, code, name, iso3_code, numeric_code, phone_prefix, created_user_id, updated_user_id) FROM stdin;
4	2025-07-18 10:48:43.695899	\N	UZ	Uzbekiston	UZB	789	Uzbekiston	\N	\N
3	2025-07-15 14:08:13.382951	2025-07-18 10:48:57.060436	TJ	Tajikistan	TJS	992	Tajikistan	\N	\N
5	2025-07-29 13:25:59.711962	2025-07-29 13:26:10.451243	RU	Russia	RUS	935	+963	\N	\N
6	2025-08-09 10:29:48.546841	\N	US	USA	USA	840	+840	\N	\N
\.


--
-- Data for Name: district; Type: TABLE DATA; Schema: location_schema; Owner: fractal
--

COPY location_schema.district (id, created_date, updated_date, code, name, created_user_id, updated_user_id, city_id, region_id, area_type_id) FROM stdin;
3	2025-08-02 11:09:43.78903	\N	RDK	Rudaki	\N	\N	5	4	1
\.


--
-- Data for Name: region; Type: TABLE DATA; Schema: location_schema; Owner: fractal
--

COPY location_schema.region (id, created_date, updated_date, code, name, created_user_id, updated_user_id, country_id) FROM stdin;
5	2025-07-16 13:42:56.612951	2025-07-16 13:43:36.152094	BMKB	Бадахшон	\N	\N	3
3	2025-07-15 14:02:59.398973	2025-07-16 13:43:49.613207	KHATLON	Хатлон	\N	\N	3
4	2025-07-16 13:13:31.440312	2025-07-28 14:26:09.621306	SUGD	Сугд	\N	\N	3
\.


--
-- Data for Name: military_service; Type: TABLE DATA; Schema: military_schema; Owner: fractal
--

COPY military_schema.military_service (id, created_date, updated_date, account_number, address, begin_date, category_fund, end_date, title, created_user_id, updated_user_id) FROM stdin;
1	2025-08-24 16:35:57.506994	\N	dqw	qwd	2025-08-18	dqw	2025-08-26	dwq	\N	\N
2	2025-08-24 16:38:20.093511	\N	4234	qwr	2025-08-05	wqr	2025-11-05	qwrw	\N	\N
5	2025-08-24 16:52:02.432768	\N	41414	фыв	2025-08-19	фыв	2025-10-29	вывфыв	\N	\N
6	2025-08-24 17:10:47.943719	\N	123	fwe	2025-08-06	fwef	2025-08-06	kj	\N	\N
\.


--
-- Data for Name: military_service_resource; Type: TABLE DATA; Schema: military_schema; Owner: fractal
--

COPY military_schema.military_service_resource (id, military_service_id) FROM stdin;
\.


--
-- Data for Name: action; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.action (id, created_date, updated_date, icon, name, url, created_user_id, updated_user_id, action_category_id, action_type_id, layout_label_id) FROM stdin;
3	2025-07-23 11:54:44.349527	\N	DELETE	Delete	delete	\N	\N	1	2	4
1	2025-07-23 11:52:56.628023	\N	ADD	Add	add	\N	\N	1	1	8
2	2025-07-23 11:54:06.13807	\N	EDIT	Edit	edit	\N	\N	1	2	9
5	2025-07-31 14:01:08.635128	\N	CHANGE	Change password	change-password	\N	\N	1	2	36
4	2025-07-31 12:31:32.303401	2025-07-31 14:01:19.593411	RESET	Reset password	reset-password	\N	\N	1	2	35
6	2025-08-31 15:52:22.846625	\N	CLOSE	Close	close	\N	\N	1	2	81
\.


--
-- Data for Name: action_category; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.action_category (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
1	2025-07-23 11:52:43.73322	\N	NEW	New category	\N	\N
\.


--
-- Data for Name: action_type; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.action_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
1	2025-07-23 11:50:56.354272	\N	CONSTRUCTOR	Constructor	\N	\N
2	2025-07-23 11:53:58.098123	\N	INSTANCE_BASED	Instance Based	\N	\N
\.


--
-- Data for Name: configuration; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.configuration (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: form_component_attributes; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.form_component_attributes (id, created_date, updated_date, value, created_user_id, updated_user_id, component_attribute_id, form_component_id, status_id) FROM stdin;
\.


--
-- Data for Name: form_components; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.form_components (id, created_date, updated_date, section, sequence, source, value, created_user_id, updated_user_id, component_id, layout_label_id, status_id) FROM stdin;
\.


--
-- Data for Name: menu; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.menu (id, created_date, updated_date, class_name, icon, level, name, sequence, url, created_user_id, updated_user_id, layout_label_id, parent_id) FROM stdin;
1	2025-07-23 12:03:35.225302	\N	\N	BOOK	1	Dictionaries	2	dictionary	\N	\N	5	\N
5	2025-07-24 12:53:31.815692	\N	\N	USER	2	User	1	user	\N	\N	13	4
8	2025-07-24 12:56:04.774349	\N	\N	MENU	2	Menu	1	menu	\N	\N	11	7
36	2025-07-28 13:50:08.343125	2025-07-28 13:51:27.057033	\N	BUILDING	2	Address Type	1	address-type	\N	\N	29	35
37	2025-07-28 14:17:56.483	\N	\N	ARCHIVES	2	Region	2	region	\N	\N	30	35
35	2025-07-28 13:50:08.331849	2025-07-28 14:31:52.40402	\N	LOCATION_ARROW	1	Location	5	location	\N	\N	28	\N
38	2025-07-28 14:45:54.195333	\N	\N	CUBE	2	District	3	district	\N	\N	31	35
39	2025-07-29 13:07:40.917679	\N	\N	GLOBE	2	Country	4	country	\N	\N	32	35
40	2025-07-29 13:41:24.076751	\N	\N	OFFICE	2	City	5	city	\N	\N	33	35
25	2025-07-26 12:37:15.568609	2025-07-29 13:48:42.354441	\N	AUTOMATION	2	Action Type	3	action-type	\N	\N	23	7
26	2025-07-26 12:37:43.598787	2025-07-29 13:49:17.489721	\N	COLLECTION	2	Action Category	4	action-category	\N	\N	22	7
9	2025-07-24 12:56:04.777264	2025-07-29 13:50:14.815914	\N	FLASH	2	Action	2	action	\N	\N	12	7
41	2025-07-29 14:11:29.844598	\N	\N	CHECK	2	Status	5	status	\N	\N	34	1
43	2025-08-01 10:37:07.922843	\N	\N	BRANCH	2	Organization	1	organization	\N	\N	41	42
31	2025-07-27 11:56:09.122499	2025-07-27 13:42:01.894921	\N	LAYOUT	2	Layout Label	2	layout-label	\N	\N	19	29
32	2025-07-27 11:57:09.742139	2025-07-27 13:42:54.251512	\N	DETAIL	3	Layout Label Details	1	layout-label-detail	\N	\N	20	31
28	2025-07-27 08:50:29.55585	2025-07-27 13:44:07.762891	\N	KEY	2	Permission	3	permission	\N	\N	21	4
27	2025-07-27 08:43:36.4331	2025-07-27 14:09:58.038111	\N	MENU	3	Role Menu	1	role-menu	\N	\N	24	6
24	2025-07-26 10:13:04.601622	2025-07-27 14:10:07.904758	\N	MENU	3	Menu Action	1	menu-action	\N	\N	25	8
2	2025-07-23 12:05:06.992077	2025-07-28 11:21:08.592145	\N	MALE	2	Gender	1	gender	\N	\N	6	1
3	2025-07-23 13:05:38.383789	2025-07-28 11:21:50.518153	\N	USER_CARD	2	Marital status	2	marital-status	\N	\N	7	1
30	2025-07-27 11:56:09.118354	2025-07-28 11:23:36.561176	\N	FLAG	2	Language	1	language	\N	\N	17	29
29	2025-07-27 11:56:09.078333	2025-07-28 11:24:24.139094	\N	GLOBE	1	Localization	3	localization	\N	\N	18	\N
4	2025-07-24 12:53:31.800519	2025-07-28 11:25:19.472725	\N	SIGN_IN	1	Authorization	2	authorization	\N	\N	15	\N
6	2025-07-24 12:53:31.818747	2025-07-28 11:25:45.00487	\N	USER_STAR	2	Role	1	role	\N	\N	14	4
7	2025-07-24 12:56:04.770544	2025-07-28 11:28:02.928663	\N	COMPASS	1	Navigation	3	navigation	\N	\N	10	\N
33	2025-07-28 12:07:18.003651	\N	\N	FLAG	2	Nationality	3	nationality	\N	\N	26	1
34	2025-07-28 12:21:30.649273	\N	\N	TAGS	2	Status Category	4	status-category	\N	\N	27	1
47	2025-08-01 10:41:34.943319	\N	\N		2	Job Description	6	job-description	\N	\N	40	42
48	2025-08-03 16:59:45.021762	\N	\N	CONTACT	2	Contact Type	6	contact-type	\N	\N	43	1
49	2025-08-05 12:42:31.006339	\N	\N	LOCATION	3	Organization Address	1	organization-address	\N	\N	44	43
50	2025-08-05 12:44:29.971045	\N	\N	CONTACT	3	Organization Contact	2	organization-contact	\N	\N	45	43
44	2025-08-01 10:37:07.926638	2025-08-06 13:41:31.931738	\N	GROUP	2	Department	2	separationReason	\N	\N	38	42
45	2025-08-01 10:37:07.931601	2025-08-06 13:42:05.972136	\N	BRIEFCASE	2	Position	3	position	\N	\N	39	42
46	2025-08-01 10:37:07.941492	2025-08-06 13:42:37.743527	\N	SITEMAP	2	Organization Unit	4	organization-unit	\N	\N	42	42
42	2025-08-01 10:37:07.901045	2025-08-06 13:43:19.383519	\N	BUILDING	1	Organization Managment	5	organization-management	\N	\N	37	\N
51	2025-08-06 13:48:35.968119	2025-08-06 13:49:55.786745	\N	MONEY	2	Currency	7	currency	\N	\N	46	1
52	2025-08-09 07:43:23.204996	\N	\N	STAR	2	Grade	6	grade	\N	\N	47	42
53	2025-08-10 10:24:20.363787	2025-08-10 10:45:47.495588	\N	USERS	1	Employee Management	2	employee-management	\N	\N	48	\N
54	2025-08-10 10:27:24.511526	2025-08-10 10:57:08.726448	\N	TYPE	2	Business Trip Type	1	business-trip-type	\N	\N	49	53
55	2025-08-10 11:33:50.548413	2025-08-10 11:38:03.909365	\N	GROUP	2	Subordinate Type	2	subordinate-type	\N	\N	50	53
56	2025-08-10 17:48:18.046881	\N	\N	GRADE	2	Grade Level	7	grade-level	\N	\N	51	42
57	2025-08-12 18:32:42.4088	2025-08-12 18:37:09.697106	\N	STEP	3	Grade Step	1	grade-step	\N	\N	52	52
58	2025-08-14 14:16:58.701923	\N	\N	TYPE	2	Reporting line type	8	reporting-line-type	\N	\N	53	42
59	2025-08-14 19:11:35.207888	\N	\N	Authority	3	Authority	1	authority	\N	\N	54	47
60	2025-08-15 14:21:29.502326	2025-08-15 14:23:26.506184	\N	LINE	3	Report Line	2	reporting-line	\N	\N	55	47
61	2025-08-15 14:28:53.150726	\N	\N	accountability	3	Accountability	3	accountability	\N	\N	56	47
62	2025-08-15 14:37:15.789782	\N	\N	KPI	3	KPI	4	kpi	\N	\N	57	47
63	2025-08-15 14:46:29.134733	\N	\N	responsibility	3	Responsibility	5	responsibility	\N	\N	58	47
64	2025-08-15 14:48:41.981317	\N	\N	Qualification	3	Qualification	6	qualification	\N	\N	59	47
65	2025-08-15 14:51:06.024996	\N	\N	required-experience	3	Required Experience	7	required-experience	\N	\N	60	47
68	2025-08-16 13:33:25.702617	\N	\N	TYPE	2	Performance Type	3	performance-type	\N	\N	61	53
69	2025-08-16 16:05:56.526005	\N	\N	GROUP	2	Vacation Type	4	vacation-type	\N	\N	62	53
70	2025-08-16 17:02:03.172279	\N	\N	RELATIVE	3	Relative type	5	relative-type	\N	\N	63	53
71	2025-08-16 17:41:47.910634	\N	\N	ORDER	3	Order type	6	order-type	\N	\N	64	53
73	2025-08-17 13:54:43.767032	\N	\N	TYPE	2	Employment Type	8	employment-type	\N	\N	66	1
74	2025-08-17 14:51:53.841349	2025-08-17 14:52:18.195041	\N	EDUCATION	1	Education	8	education	\N	\N	67	\N
75	2025-08-17 14:52:49.185249	\N	\N	TYPE	2	Education Type	1	education-type	\N	\N	68	74
76	2025-08-17 15:10:45.550104	\N	\N	DEGREE	2	Degree Type	2	degree-type	\N	\N	69	74
77	2025-08-17 15:59:34.037722	\N	\N	DOCUMENT	2	Education Document Type	3	education-document-type	\N	\N	70	74
78	2025-08-17 16:16:03.072203	\N	\N	Accreditation	2	Accreditation Status	4	accreditation-status	\N	\N	71	74
79	2025-08-17 16:33:57.796577	\N	\N	GRADE	2	Grade Point Average	5	grade-point-average	\N	\N	72	74
80	2025-08-17 16:56:08.093056	\N	\N	Document 	2	Identification Document Type	9	identification-document-type	\N	\N	65	1
81	2025-08-18 16:31:26.886104	\N	\N	Recruitment	1	Recruitment	9	recruitment	\N	\N	73	\N
82	2025-08-18 16:34:38.06107	\N	\N	Candidate	2	Candidate	1	candidate	\N	\N	74	81
83	2025-08-18 18:17:48.141041	\N	\N	Candidate 	3	Candidate citizenship	1	candidate-citizenships	\N	\N	75	82
84	2025-08-19 18:46:18.59212	\N	\N	AREA	2	Area Type	6	area-type	\N	\N	76	35
85	2025-08-22 19:31:43.947189	\N	\N	TYPE	2	Week day	10	week-day	\N	\N	77	1
86	2025-08-23 16:51:52.333361	\N	\N	work	3	Organization work schedule	3	organization-work-schedule	\N	\N	78	43
87	2025-08-24 12:30:12.119007	\N	\N	TYPE	2	Interview Type	2	interview-type	\N	\N	79	81
89	2025-08-24 15:17:24.397945	\N	\N	TYPE	2	Resource Type	3	resource-type	\N	\N	80	81
\.


--
-- Data for Name: menu_action; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.menu_action (id, created_date, updated_date, is_active, created_user_id, updated_user_id, action_id, menu_id, status_id) FROM stdin;
23	2025-07-24 13:00:13.139444	\N	\N	\N	\N	3	9	5
12	2025-07-24 12:59:17.125416	\N	\N	\N	\N	1	5	5
20	2025-07-24 12:59:58.998553	\N	\N	\N	\N	3	8	5
82	2025-08-01 10:38:24.732445	\N	\N	\N	\N	2	43	5
19	2025-07-24 12:59:54.928521	\N	\N	\N	\N	2	8	5
17	2025-07-24 12:59:43.453773	\N	\N	\N	\N	3	6	5
10	2025-07-23 12:56:55.976845	\N	\N	\N	\N	3	2	5
16	2025-07-24 12:59:38.999125	\N	\N	\N	\N	2	6	5
83	2025-08-01 10:38:31.86027	\N	\N	\N	\N	3	43	5
18	2025-07-24 12:59:51.807096	\N	\N	\N	\N	1	8	5
9	2025-07-23 12:56:47.827435	\N	\N	\N	\N	2	2	5
14	2025-07-24 12:59:27.5751	\N	\N	\N	\N	3	5	5
13	2025-07-24 12:59:22.29047	\N	\N	\N	\N	2	5	5
15	2025-07-24 12:59:35.700147	\N	\N	\N	\N	1	6	5
8	2025-07-23 12:56:40.488225	\N	\N	\N	\N	1	2	5
24	2025-07-26 10:14:38.329742	\N	\N	\N	\N	1	24	5
25	2025-07-26 10:14:42.033881	\N	\N	\N	\N	2	24	5
26	2025-07-26 10:14:46.233516	\N	\N	\N	\N	3	24	5
27	2025-07-26 11:16:38.441761	\N	\N	\N	\N	1	9	5
84	2025-08-01 10:38:46.085646	\N	\N	\N	\N	1	45	5
22	2025-07-24 13:00:09.333676	2025-07-26 12:33:22.966533	\N	\N	\N	2	9	5
28	2025-07-26 12:38:01.412673	\N	\N	\N	\N	3	25	5
29	2025-07-26 12:38:07.961599	\N	\N	\N	\N	1	25	5
30	2025-07-26 12:38:16.185951	\N	\N	\N	\N	2	25	5
31	2025-07-26 12:38:28.341643	\N	\N	\N	\N	3	26	5
32	2025-07-26 12:38:34.413704	\N	\N	\N	\N	1	26	5
33	2025-07-26 12:38:40.627421	\N	\N	\N	\N	2	26	5
34	2025-07-27 08:43:50.113303	\N	\N	\N	\N	1	27	5
35	2025-07-27 08:43:58.036656	\N	\N	\N	\N	2	27	5
36	2025-07-27 08:44:06.588344	\N	\N	\N	\N	3	27	5
37	2025-07-27 08:50:54.455258	\N	\N	\N	\N	1	28	5
38	2025-07-27 08:51:02.348051	\N	\N	\N	\N	2	28	5
39	2025-07-27 08:51:09.486974	\N	\N	\N	\N	3	28	5
40	2025-07-27 11:57:24.434157	\N	\N	\N	\N	1	32	5
41	2025-07-27 11:57:31.404659	\N	\N	\N	\N	2	32	5
43	2025-07-27 11:57:59.11342	\N	\N	\N	\N	1	31	5
44	2025-07-27 11:58:06.558303	\N	\N	\N	\N	2	31	5
45	2025-07-27 11:58:15.000736	\N	\N	\N	\N	3	31	5
46	2025-07-27 11:58:29.337087	\N	\N	\N	\N	1	30	5
47	2025-07-27 11:58:35.481319	\N	\N	\N	\N	2	30	5
48	2025-07-27 11:58:44.979903	\N	\N	\N	\N	3	30	5
42	2025-07-27 11:57:40.125564	2025-07-27 12:03:11.532745	\N	\N	\N	3	32	5
49	2025-07-28 11:47:34.512546	\N	\N	\N	\N	1	3	5
50	2025-07-28 11:47:42.085447	\N	\N	\N	\N	2	3	5
51	2025-07-28 11:47:48.168276	\N	\N	\N	\N	3	3	5
52	2025-07-28 12:07:28.640985	\N	\N	\N	\N	1	33	5
53	2025-07-28 12:07:35.040331	\N	\N	\N	\N	2	33	5
54	2025-07-28 12:07:40.874084	\N	\N	\N	\N	3	33	5
55	2025-07-28 12:21:40.801189	\N	\N	\N	\N	1	34	5
56	2025-07-28 12:21:45.916026	\N	\N	\N	\N	2	34	5
57	2025-07-28 12:21:50.853485	\N	\N	\N	\N	3	34	5
58	2025-07-28 13:51:48.065524	\N	\N	\N	\N	1	36	5
59	2025-07-28 13:51:53.614912	\N	\N	\N	\N	2	36	5
60	2025-07-28 13:51:58.765791	\N	\N	\N	\N	3	36	5
61	2025-07-28 14:18:05.493854	\N	\N	\N	\N	1	37	5
62	2025-07-28 14:18:11.471658	\N	\N	\N	\N	2	37	5
63	2025-07-28 14:18:16.77591	\N	\N	\N	\N	3	37	5
64	2025-07-28 14:46:02.510612	\N	\N	\N	\N	1	38	5
65	2025-07-28 14:46:08.046832	\N	\N	\N	\N	2	38	5
66	2025-07-28 14:46:14.009844	\N	\N	\N	\N	3	38	5
67	2025-07-29 13:07:50.650336	\N	\N	\N	\N	1	39	5
68	2025-07-29 13:07:56.633961	\N	\N	\N	\N	2	39	5
69	2025-07-29 13:08:01.9566	\N	\N	\N	\N	3	39	5
70	2025-07-29 13:41:35.43753	\N	\N	\N	\N	1	40	5
71	2025-07-29 13:41:42.076399	\N	\N	\N	\N	2	40	5
72	2025-07-29 13:41:47.954205	\N	\N	\N	\N	3	40	5
73	2025-07-29 14:11:39.377015	\N	\N	\N	\N	1	41	5
74	2025-07-29 14:11:49.606832	\N	\N	\N	\N	2	41	5
75	2025-07-29 14:11:55.192331	\N	\N	\N	\N	3	41	5
76	2025-07-31 12:31:48.561893	\N	\N	\N	\N	4	5	5
77	2025-07-31 14:01:41.149704	\N	\N	\N	\N	5	5	5
78	2025-08-01 10:37:47.539204	\N	\N	\N	\N	1	46	5
79	2025-08-01 10:37:53.603243	\N	\N	\N	\N	2	46	5
80	2025-08-01 10:38:01.530611	\N	\N	\N	\N	3	46	5
81	2025-08-01 10:38:16.335223	\N	\N	\N	\N	1	43	5
85	2025-08-01 10:38:53.201606	\N	\N	\N	\N	2	45	5
86	2025-08-01 10:39:00.737521	\N	\N	\N	\N	3	45	5
87	2025-08-01 10:39:19.333408	\N	\N	\N	\N	1	44	5
88	2025-08-01 10:39:26.20942	\N	\N	\N	\N	2	44	5
89	2025-08-01 10:39:34.424194	\N	\N	\N	\N	3	44	5
90	2025-08-01 10:41:46.565005	\N	\N	\N	\N	1	47	5
91	2025-08-01 10:41:54.724738	\N	\N	\N	\N	2	47	5
92	2025-08-01 10:42:02.95242	\N	\N	\N	\N	3	47	5
93	2025-08-03 16:59:56.116562	\N	\N	\N	\N	1	48	5
94	2025-08-03 17:00:02.807056	\N	\N	\N	\N	2	48	5
95	2025-08-03 17:00:10.211816	\N	\N	\N	\N	3	48	5
96	2025-08-05 12:42:43.11668	\N	\N	\N	\N	1	49	5
97	2025-08-05 12:42:51.062571	\N	\N	\N	\N	2	49	5
98	2025-08-05 12:42:58.954935	\N	\N	\N	\N	3	49	5
99	2025-08-05 12:51:00.212765	\N	\N	\N	\N	1	50	5
100	2025-08-05 12:51:11.331938	\N	\N	\N	\N	2	50	5
101	2025-08-05 12:51:19.569107	\N	\N	\N	\N	3	50	5
102	2025-08-06 13:50:09.131046	\N	\N	\N	\N	1	51	5
103	2025-08-06 13:50:16.994205	\N	\N	\N	\N	2	51	5
104	2025-08-06 13:50:22.864014	\N	\N	\N	\N	3	51	5
105	2025-08-09 07:43:32.56992	\N	\N	\N	\N	1	52	5
106	2025-08-09 07:43:37.957859	\N	\N	\N	\N	2	52	5
107	2025-08-09 07:43:42.566154	\N	\N	\N	\N	3	52	5
108	2025-08-10 10:27:34.089479	\N	\N	\N	\N	1	54	5
109	2025-08-10 10:27:40.169628	\N	\N	\N	\N	2	54	5
110	2025-08-10 10:27:48.22533	\N	\N	\N	\N	3	54	5
111	2025-08-10 11:34:51.009002	\N	\N	\N	\N	1	55	5
112	2025-08-10 11:34:57.647966	\N	\N	\N	\N	2	55	5
113	2025-08-10 11:35:02.98453	\N	\N	\N	\N	3	55	5
114	2025-08-10 17:51:49.641863	\N	\N	\N	\N	1	56	5
115	2025-08-10 17:52:03.285268	\N	\N	\N	\N	2	56	5
116	2025-08-10 17:52:17.315027	\N	\N	\N	\N	3	56	5
117	2025-08-12 18:38:15.066625	\N	\N	\N	\N	1	57	5
118	2025-08-12 18:38:29.105109	\N	\N	\N	\N	2	57	5
119	2025-08-12 18:38:45.923426	\N	\N	\N	\N	3	57	5
120	2025-08-14 14:17:07.175819	\N	\N	\N	\N	1	58	5
121	2025-08-14 14:17:12.416357	\N	\N	\N	\N	2	58	5
122	2025-08-14 14:17:16.746817	\N	\N	\N	\N	3	58	5
123	2025-08-14 19:11:42.612654	\N	\N	\N	\N	1	59	5
124	2025-08-14 19:11:47.195916	\N	\N	\N	\N	2	59	5
125	2025-08-14 19:11:51.046406	\N	\N	\N	\N	3	59	5
126	2025-08-15 14:21:37.198247	\N	\N	\N	\N	1	60	5
127	2025-08-15 14:21:41.678443	\N	\N	\N	\N	2	60	5
128	2025-08-15 14:21:46.350572	\N	\N	\N	\N	3	60	5
129	2025-08-15 14:29:01.178242	\N	\N	\N	\N	1	61	5
130	2025-08-15 14:29:05.645228	\N	\N	\N	\N	2	61	5
131	2025-08-15 14:29:09.651482	\N	\N	\N	\N	3	61	5
132	2025-08-15 14:37:21.768428	\N	\N	\N	\N	1	62	5
133	2025-08-15 14:37:26.908479	\N	\N	\N	\N	2	62	5
134	2025-08-15 14:37:30.963595	\N	\N	\N	\N	3	62	5
135	2025-08-15 14:46:36.115439	\N	\N	\N	\N	1	63	5
136	2025-08-15 14:46:40.704579	\N	\N	\N	\N	2	63	5
137	2025-08-15 14:46:45.215582	\N	\N	\N	\N	3	63	5
138	2025-08-15 14:48:48.873128	\N	\N	\N	\N	1	64	5
139	2025-08-15 14:48:53.421491	\N	\N	\N	\N	2	64	5
140	2025-08-15 14:48:57.145525	\N	\N	\N	\N	3	64	5
141	2025-08-15 14:51:13.306452	\N	\N	\N	\N	1	65	5
142	2025-08-15 14:51:18.023137	\N	\N	\N	\N	2	65	5
143	2025-08-15 14:51:22.200913	\N	\N	\N	\N	3	65	5
150	2025-08-16 13:33:36.468938	\N	\N	\N	\N	3	68	5
151	2025-08-16 13:33:42.999144	\N	\N	\N	\N	1	68	5
152	2025-08-16 13:33:49.470038	\N	\N	\N	\N	2	68	5
153	2025-08-16 16:06:10.974239	\N	\N	\N	\N	1	69	5
154	2025-08-16 16:06:17.735494	\N	\N	\N	\N	2	69	5
155	2025-08-16 16:06:26.415637	\N	\N	\N	\N	3	69	5
156	2025-08-16 17:02:09.651388	\N	\N	\N	\N	1	70	5
157	2025-08-16 17:02:14.27324	\N	\N	\N	\N	2	70	5
158	2025-08-16 17:02:21.179076	\N	\N	\N	\N	3	70	5
159	2025-08-16 17:41:54.588146	\N	\N	\N	\N	1	71	5
160	2025-08-16 17:41:59.331758	\N	\N	\N	\N	2	71	5
161	2025-08-16 17:42:04.233016	\N	\N	\N	\N	3	71	5
165	2025-08-17 13:54:54.059987	\N	\N	\N	\N	1	73	5
166	2025-08-17 13:54:58.387233	\N	\N	\N	\N	2	73	5
167	2025-08-17 13:55:02.388273	\N	\N	\N	\N	3	73	5
168	2025-08-17 14:52:55.165387	\N	\N	\N	\N	1	75	5
169	2025-08-17 14:53:00.99768	\N	\N	\N	\N	2	75	5
170	2025-08-17 14:53:05.779392	\N	\N	\N	\N	3	75	5
171	2025-08-17 15:10:51.650984	\N	\N	\N	\N	1	76	5
172	2025-08-17 15:10:55.887466	\N	\N	\N	\N	2	76	5
173	2025-08-17 15:11:02.028755	\N	\N	\N	\N	3	76	5
174	2025-08-17 15:59:40.934696	\N	\N	\N	\N	1	77	5
175	2025-08-17 15:59:45.359088	\N	\N	\N	\N	2	77	5
176	2025-08-17 15:59:49.739767	\N	\N	\N	\N	3	77	5
177	2025-08-17 16:16:09.315015	\N	\N	\N	\N	1	78	5
178	2025-08-17 16:16:13.470404	\N	\N	\N	\N	2	78	5
179	2025-08-17 16:16:17.22843	\N	\N	\N	\N	3	78	5
180	2025-08-17 16:34:09.024014	\N	\N	\N	\N	1	79	5
181	2025-08-17 16:34:13.58644	\N	\N	\N	\N	2	79	5
182	2025-08-17 16:34:17.581846	\N	\N	\N	\N	3	79	5
183	2025-08-17 16:56:16.2982	\N	\N	\N	\N	1	80	5
184	2025-08-17 16:56:20.615632	\N	\N	\N	\N	2	80	5
185	2025-08-17 16:56:27.677184	\N	\N	\N	\N	3	80	5
186	2025-08-18 16:34:44.776692	\N	\N	\N	\N	1	82	5
187	2025-08-18 16:34:49.395119	\N	\N	\N	\N	2	82	5
188	2025-08-18 16:34:53.499868	\N	\N	\N	\N	3	82	5
189	2025-08-18 18:17:54.202965	\N	\N	\N	\N	1	83	5
190	2025-08-18 18:17:58.929701	\N	\N	\N	\N	2	83	5
191	2025-08-18 18:18:03.001878	\N	\N	\N	\N	3	83	5
192	2025-08-19 18:46:24.742465	\N	\N	\N	\N	1	84	5
193	2025-08-19 18:46:29.847727	\N	\N	\N	\N	2	84	5
194	2025-08-19 18:46:36.402688	\N	\N	\N	\N	3	84	5
195	2025-08-22 19:34:30.094818	\N	\N	\N	\N	1	85	5
196	2025-08-22 19:34:37.64485	\N	\N	\N	\N	2	85	5
197	2025-08-22 19:34:45.158869	\N	\N	\N	\N	3	85	5
198	2025-08-23 16:51:58.219152	\N	\N	\N	\N	1	86	5
199	2025-08-23 16:52:02.555161	\N	\N	\N	\N	2	86	5
200	2025-08-23 16:52:06.394082	\N	\N	\N	\N	3	86	5
201	2025-08-24 12:30:24.896766	\N	\N	\N	\N	1	87	5
202	2025-08-24 12:30:32.611909	\N	\N	\N	\N	2	87	5
203	2025-08-24 12:30:40.81925	\N	\N	\N	\N	3	87	5
207	2025-08-24 15:17:40.307847	\N	\N	\N	\N	1	89	5
208	2025-08-24 15:17:46.303074	\N	\N	\N	\N	2	89	5
209	2025-08-24 15:17:53.850392	\N	\N	\N	\N	3	89	5
210	2025-08-31 15:52:43.590323	\N	\N	\N	\N	6	57	5
\.


--
-- Data for Name: menu_action_form_component; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.menu_action_form_component (id, created_date, updated_date, sequence, created_user_id, updated_user_id, form_component_id, menu_action_id, status_id) FROM stdin;
\.


--
-- Data for Name: menu_action_transition; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.menu_action_transition (id, created_date, updated_date, entity_id, sequence, created_user_id, updated_user_id, menu_action_id, menu_transition_id, status_id) FROM stdin;
\.


--
-- Data for Name: menu_configuration; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.menu_configuration (id, created_date, updated_date, value, created_user_id, updated_user_id, configuration_id, menu_id, status_id) FROM stdin;
\.


--
-- Data for Name: menu_transition; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.menu_transition (id, created_date, updated_date, created_user_id, updated_user_id, entity_type_id, menu_id, status_id) FROM stdin;
\.


--
-- Data for Name: navigation_unit; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.navigation_unit (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: public_url; Type: TABLE DATA; Schema: navigation_schema; Owner: fractal
--

COPY navigation_schema.public_url (id, created_date, updated_date, name, url, created_user_id, updated_user_id, status_id) FROM stdin;
\.


--
-- Data for Name: accountability; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.accountability (id, created_date, updated_date, description, performance_measure, created_user_id, updated_user_id, job_description_id) FROM stdin;
7	2025-08-15 18:00:12.181477	\N	rtret	rtrt	\N	\N	5
8	2025-08-16 18:45:48.028935	\N	asdsd	asdsad	\N	\N	6
\.


--
-- Data for Name: authority; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.authority (id, created_date, updated_date, description, scope, created_user_id, updated_user_id, job_description_id) FROM stdin;
9	2025-08-15 18:00:12.186194	\N	rtrtret	rtert	\N	\N	5
10	2025-08-16 18:45:48.034201	\N	asdsad	asdsad	\N	\N	6
\.


--
-- Data for Name: separationReason; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.separationReason (id, created_date, updated_date, code, level, level_map, name, created_user_id, updated_user_id, organization_unit_id, parent_id, status_id, close_date, close_reason, open_date, open_reason) FROM stdin;
14	2025-09-01 18:34:36.395309	\N	SUPPORT	1	ewrwer	Support	\N	\N	1	\N	5	2025-09-17		2025-09-10	ewrwer
\.


--
-- Data for Name: grade; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.grade (id, created_date, updated_date, code, name, end_date, max_salary, min_salary, notes, start_date, created_user_id, updated_user_id, currency_id, status_id, parent_id, grade_level_id) FROM stdin;
3	2025-08-12 17:26:05.817637	2025-08-12 17:27:54.629895	GRADE	GRADE5	2025-10-15	233.00	12.00	Grade 1	2025-08-12	\N	\N	3	5	\N	1
4	2025-08-12 17:36:47.918704	2025-08-12 18:25:51.596425	GRD	GRADE4	2025-10-01	233.00	1.00	GRADE4	2025-08-12	\N	\N	5	5	\N	4
11	2025-08-14 16:54:00.325934	2025-08-14 16:54:21.997545	GRAD	First Grade	2025-09-18	1000.00	10.00	First Grade created	2025-08-07	\N	\N	5	5	\N	1
12	2025-08-14 16:56:56.1029	2025-08-14 19:06:45.539617	CHGRAD	Child Grade	2025-10-16	1212.00	13.00	Child Grade fwef	2025-07-17	\N	\N	6	5	11	3
\.


--
-- Data for Name: grade_level; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.grade_level (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
1	2025-08-10 18:05:11.180719	\N	HIGH	high	\N	\N
3	2025-08-12 18:12:15.937945	\N	LOW	Low	\N	\N
4	2025-08-12 18:12:25.33202	\N	MIDDLE	Middle	\N	\N
\.


--
-- Data for Name: grade_step; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.grade_step (id, created_date, updated_date, max_salary, min_salary, created_user_id, updated_user_id, grade_id, status_id) FROM stdin;
2	2025-08-12 19:05:29.888382	\N	10000.00	1000.00	\N	\N	4	5
9	2025-08-14 16:54:00.330089	\N	100.00	10.00	\N	\N	11	5
12	2025-08-27 16:01:02.060974	2025-08-31 13:51:37.267285	50.00	50.00	\N	\N	3	3
17	2025-08-31 14:38:43.91303	\N	2.00	1.00	\N	\N	3	5
10	2025-08-14 16:56:56.107903	2025-08-31 15:59:18.469219	1200.00	120.00	\N	\N	12	5
24	2025-08-31 15:59:28.573076	\N	12.00	1.00	\N	\N	12	5
26	2025-08-31 16:42:20.397796	\N	4214.00	414.00	\N	\N	3	5
27	2025-08-31 17:22:03.316467	2025-08-31 17:22:09.47459	12.00	12.00	\N	\N	3	3
\.


--
-- Data for Name: job_description; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.job_description (id, created_date, updated_date, effective_date, summary, title, created_user_id, updated_user_id, position_id, status_id) FROM stdin;
5	2025-08-15 18:00:12.17045	\N	2025-08-26	1	egtt	\N	\N	12	5
6	2025-08-16 18:45:48.017395	2025-08-24 17:31:41.365245	2025-08-05	13213\n13566	RERE	\N	\N	13	5
\.


--
-- Data for Name: key_performance_indicator; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.key_performance_indicator (id, created_date, updated_date, description, frequency, measure_unit, name, target_value, created_user_id, updated_user_id, job_description_id) FROM stdin;
6	2025-08-15 18:00:12.190915	\N	werewr	erer	werewr	ewrwer	5	\N	\N	5
7	2025-08-15 18:00:12.195099	\N	werewr	erer	werewr	ewrwer	5	\N	\N	5
8	2025-08-16 18:45:48.039454	\N	asdsd	asdd	asd	asdasd	213	\N	\N	6
9	2025-08-16 18:45:48.044744	\N	asdsd	asdd	asd	asdasd	213	\N	\N	6
\.


--
-- Data for Name: organization; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.organization (id, created_date, updated_date, close_date, code, full_name, level, level_map, name, open_date, tin_number, created_user_id, updated_user_id, organization_unit_id, parent_id, close_reason, open_reason) FROM stdin;
6	2025-08-04 13:52:50.511233	2025-08-19 18:56:33.392088	\N	RASHT	CJSC ICB, Rasht Branch	2	001-004	RASHT	2015-02-11	234123456	\N	\N	3	\N	\N	\N
1	2025-08-02 11:21:49.097093	2025-08-19 18:58:11.205186	\N	DMB	CJSC ICB, Dushanbe Branch	2	001-002	Dushanbe	2012-08-28	250178690	\N	\N	3	\N	\N	\N
5	2025-08-04 10:01:26.509557	2025-08-19 19:04:43.342675	\N	SADBARG	CJSC ICB, Sadbarg BSC	3	001-002-001	SADBARG	2016-12-29	880880880	\N	\N	7	1	\N	\N
9	2025-08-24 15:37:40.340991	\N	2025-11-05	KORVON	dqwd	3	001-01-06	dqwdwq	2025-08-04	14124	\N	\N	7	\N	\N	\N
\.


--
-- Data for Name: organization_address; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.organization_address (id, organization_id) FROM stdin;
1	1
52	1
152	5
153	6
353	9
\.


--
-- Data for Name: organization_contact; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.organization_contact (id, organization_id) FROM stdin;
2	1
3	1
4	5
5	5
52	6
152	6
253	9
\.


--
-- Data for Name: organization_unit; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.organization_unit (id, created_date, updated_date, code, name, description, created_user_id, updated_user_id) FROM stdin;
1	2025-08-01 13:42:50.101969	\N	HEADOFFICE	Head Office	The head office	\N	\N
5	2025-08-04 10:48:50.903989	\N	DEPARTMENT	Department	Department	\N	\N
6	2025-08-04 10:49:14.374705	\N	DIVISION	Division	Division	\N	\N
7	2025-08-19 18:33:03.843498	\N	BSC	BSC	Bank Service Center	\N	\N
3	2025-08-02 13:03:22.084534	2025-08-23 13:15:01.420252	BRANCH	Branch	Branch	\N	\N
\.


--
-- Data for Name: position; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema."position" (id, created_date, updated_date, code, description, name, created_user_id, updated_user_id, department_id, grade_id, status_id, close_date, close_reason, open_date, open_reason) FROM stdin;
12	2025-08-12 17:47:01.316103	2025-09-01 18:34:46.315734	HUMAN	Human Right	Human Right	\N	\N	14	3	5	\N	\N	\N	\N
13	2025-08-24 17:27:53.491721	2025-09-01 18:34:53.128804	HRHEAD	Head of Human Resource	Head of HR	\N	\N	14	3	5	\N	\N	\N	\N
2	2025-08-05 13:19:07.752497	2025-09-01 18:34:59.355764	SPMANAGER	Manager technical update	Manager technical update	\N	\N	14	4	5	\N	\N	\N	\N
\.


--
-- Data for Name: qualification; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.qualification (id, created_date, updated_date, description, created_user_id, updated_user_id, job_description_id) FROM stdin;
7	2025-08-15 18:00:12.196699	\N	erer	\N	\N	5
8	2025-08-16 18:45:48.045807	\N	adsd	\N	\N	6
9	2025-08-16 18:45:48.04895	\N	asdsad	\N	\N	6
10	2025-08-16 18:45:48.049988	\N	asdasdsd	\N	\N	6
11	2025-08-16 18:45:48.051029	\N	adsd	\N	\N	6
\.


--
-- Data for Name: reporting_line; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.reporting_line (id, created_date, updated_date, created_user_id, updated_user_id, job_description_id, position_id, reporting_line_type_id, status_id) FROM stdin;
5	2025-08-15 18:00:12.199841	\N	\N	\N	5	12	7	5
6	2025-08-16 18:45:48.052071	\N	\N	\N	6	2	7	5
\.


--
-- Data for Name: reporting_line_type; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.reporting_line_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
7	2025-08-15 16:50:45.159962	\N	MAIN	Main	\N	\N
8	2025-08-15 16:50:56.540102	\N	SECOND	Second type	\N	\N
\.


--
-- Data for Name: required_experience; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.required_experience (id, created_date, updated_date, description, domain, end_date, level, mandatory, notes, required_years, start_date, created_user_id, updated_user_id, job_description_id) FROM stdin;
6	2025-08-15 18:00:12.202916	\N	erewr	weer	2025-08-19	weee	f	ewtrwerewr	1259	2025-08-27	\N	\N	5
7	2025-08-16 18:45:48.055842	\N	dqwd	dasd	2025-08-20	asdd	t	asd	21332	2025-08-19	\N	\N	6
\.


--
-- Data for Name: responsibility; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.responsibility (id, created_date, updated_date, description, created_user_id, updated_user_id, job_description_id) FROM stdin;
7	2025-08-15 18:00:12.206062	\N	erfewr	\N	\N	5
8	2025-08-16 18:45:48.059486	\N	dwqdwqd	\N	\N	6
\.


--
-- Data for Name: work_schedule; Type: TABLE DATA; Schema: organization_schema; Owner: fractal
--

COPY organization_schema.work_schedule (id, organization_id) FROM stdin;
4	9
\.


--
-- Data for Name: candidate; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.candidate (id, created_date, updated_date, birth_date, first_name, last_name, patronymic_name, ssn, tin, created_user_id, updated_user_id, gender_id, marital_status_id, nationality_id, status_id, vacancy_id) FROM stdin;
5	2025-08-24 16:52:02.399883	2025-08-24 17:10:58.367018	1996-09-09	Манучехр	Зумрадшоев	Курбонхонович	789456	79846125	\N	\N	1	2	1	5	\N
6	2025-08-24 17:10:47.909053	2025-08-24 17:37:47.654649	1992-07-07	Хусрав	Шукронов	Курбуалиевич	7894545	78946123	\N	\N	1	5	1	5	\N
9	2025-08-26 18:52:44.902018	\N	2025-08-12	fwef	fwef	fwef	234	3244	\N	\N	1	5	1	5	\N
\.


--
-- Data for Name: candidate_address; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.candidate_address (id, candidate_id) FROM stdin;
403	6
\.


--
-- Data for Name: candidate_citizenship; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.candidate_citizenship (id, candidate_id) FROM stdin;
6	5
7	6
\.


--
-- Data for Name: candidate_contact; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.candidate_contact (id, candidate_id) FROM stdin;
303	5
304	6
\.


--
-- Data for Name: candidate_education; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.candidate_education (id, candidate_id) FROM stdin;
4	5
5	6
\.


--
-- Data for Name: candidate_identification_document; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.candidate_identification_document (id, candidate_id) FROM stdin;
6	5
7	6
\.


--
-- Data for Name: candidate_military_service; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.candidate_military_service (id, candidate_id) FROM stdin;
5	5
6	6
\.


--
-- Data for Name: candidate_resource; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.candidate_resource (id, candidate_id, candidate_resource_type_id) FROM stdin;
\.


--
-- Data for Name: candidate_resource_type; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.candidate_resource_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
2	2025-08-24 16:02:41.067959	2025-08-24 16:10:14.215546	DOCUMENT	Document	\N	\N
3	2025-08-24 16:10:22.216748	\N	IMAGE	Image	\N	\N
4	2025-08-24 16:10:30.165365	\N	VIDEO	Video	\N	\N
5	2025-08-24 16:10:38.25087	\N	AUDIO	Audio	\N	\N
6	2025-08-24 16:10:45.875647	\N	OTHER	Other	\N	\N
\.


--
-- Data for Name: candidate_work_experience; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.candidate_work_experience (id, candidate_id) FROM stdin;
5	5
6	6
\.


--
-- Data for Name: duty; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.duty (id, created_date, updated_date, description, created_user_id, updated_user_id, vacancy_id) FROM stdin;
\.


--
-- Data for Name: experience; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.experience (id, created_date, updated_date, description, domain, level, mandatory, notes, required_years, created_user_id, updated_user_id, vacancy_id) FROM stdin;
\.


--
-- Data for Name: interview; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.interview (id, created_date, updated_date, description, details, duration_minutes, notes, scheduled_time, created_user_id, updated_user_id, interview_type_id, status_id) FROM stdin;
\.


--
-- Data for Name: interview_evaluation; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.interview_evaluation (id, created_date, updated_date, date, created_user_id, updated_user_id, approved_date, reviewed_date, approved_user_id, reviewed_user_id, status_id) FROM stdin;
\.


--
-- Data for Name: interview_evaluation_answer; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.interview_evaluation_answer (id, created_date, updated_date, text, created_user_id, updated_user_id, interview_evaluation_question_id, status_id) FROM stdin;
\.


--
-- Data for Name: interview_evaluation_question; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.interview_evaluation_question (id, created_date, updated_date, max_selectable_options, text, created_user_id, updated_user_id, interview_evaluation_section_id, question_type_id, status_id) FROM stdin;
\.


--
-- Data for Name: interview_evaluation_section; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.interview_evaluation_section (id, created_date, updated_date, created_user_id, updated_user_id, interview_evaluation_id, parent_id, status_id) FROM stdin;
\.


--
-- Data for Name: interview_type; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.interview_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
2	2025-08-24 12:48:24.033558	2025-08-24 13:39:17.836359	ONLINE	Online	\N	\N
4	2025-08-24 16:10:59.93875	\N	OFFLINE	Offline	\N	\N
\.


--
-- Data for Name: interviewee; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.interviewee (id, created_date, updated_date, duration_minutes, scheduled_time, created_user_id, updated_user_id, candidate_id, interview_id, status_id) FROM stdin;
\.


--
-- Data for Name: interviewer; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.interviewer (id, created_date, updated_date, created_user_id, updated_user_id, employee_id, interview_id, status_id, duration_minutes, scheduled_time, interview_evaluation_id) FROM stdin;
\.


--
-- Data for Name: skill; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.skill (id, created_date, updated_date, description, created_user_id, updated_user_id, vacancy_id) FROM stdin;
\.


--
-- Data for Name: vacancy; Type: TABLE DATA; Schema: recruitment_schema; Owner: fractal
--

COPY recruitment_schema.vacancy (id, created_date, updated_date, close_date, description, open_date, salary, created_user_id, updated_user_id, organization_id, position_id, status_id) FROM stdin;
\.


--
-- Data for Name: resource; Type: TABLE DATA; Schema: resource_schema; Owner: fractal
--

COPY resource_schema.resource (id, created_date, updated_date, content_type, file_name, size_in_bytes, url, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: entity_state; Type: TABLE DATA; Schema: state_schema; Owner: fractal
--

COPY state_schema.entity_state (id, created_date, updated_date, created_user_id, updated_user_id, status_id) FROM stdin;
\.


--
-- Data for Name: environment_variable; Type: TABLE DATA; Schema: system_schema; Owner: fractal
--

COPY system_schema.environment_variable (id, created_date, updated_date, code, name, value, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: message; Type: TABLE DATA; Schema: system_schema; Owner: fractal
--

COPY system_schema.message (id, created_date, updated_date, code, description, name, created_user_id, updated_user_id, language_id, message_type_id) FROM stdin;
\.


--
-- Data for Name: message_type; Type: TABLE DATA; Schema: system_schema; Owner: fractal
--

COPY system_schema.message_type (id, created_date, updated_date, code, name, description, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: notification; Type: TABLE DATA; Schema: system_schema; Owner: fractal
--

COPY system_schema.notification (id, created_date, updated_date, message, receiver, sender, created_user_id, updated_user_id, notification_type_id, service_provider_id, status_id) FROM stdin;
\.


--
-- Data for Name: notification_type; Type: TABLE DATA; Schema: system_schema; Owner: fractal
--

COPY system_schema.notification_type (id, created_date, updated_date, code, name, description, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: service_provider; Type: TABLE DATA; Schema: system_schema; Owner: fractal
--

COPY system_schema.service_provider (id, created_date, updated_date, code, host, name, password, port, protocol, username, created_user_id, updated_user_id, service_provider_id, status_id) FROM stdin;
\.


--
-- Data for Name: service_provider_type; Type: TABLE DATA; Schema: system_schema; Owner: fractal
--

COPY system_schema.service_provider_type (id, created_date, updated_date, code, name, description, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: selectedAnswer; Type: TABLE DATA; Schema: testing_schema; Owner: fractal
--

COPY testing_schema.selectedAnswer (id, created_date, updated_date, is_correct, text, created_user_id, updated_user_id, question_id) FROM stdin;
\.


--
-- Data for Name: answer_submission; Type: TABLE DATA; Schema: testing_schema; Owner: fractal
--

COPY testing_schema.answer_submission (id, created_date, updated_date, approved_date, reviewed_date, created_user_id, updated_user_id, approved_user_id, reviewed_user_id, question_id, status_id, test_session_id) FROM stdin;
\.


--
-- Data for Name: question; Type: TABLE DATA; Schema: testing_schema; Owner: fractal
--

COPY testing_schema.question (id, created_date, updated_date, text, created_user_id, updated_user_id, question_type_id, max_selectable_options, status_id, test_id) FROM stdin;
\.


--
-- Data for Name: question_type; Type: TABLE DATA; Schema: testing_schema; Owner: fractal
--

COPY testing_schema.question_type (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: selected_answer; Type: TABLE DATA; Schema: testing_schema; Owner: fractal
--

COPY testing_schema.selected_answer (id, created_date, updated_date, approved_date, reviewed_date, selected_date, created_user_id, updated_user_id, approved_user_id, reviewed_user_id, answer_id, answer_submission_id) FROM stdin;
\.


--
-- Data for Name: test; Type: TABLE DATA; Schema: testing_schema; Owner: fractal
--

COPY testing_schema.test (id, created_date, updated_date, approved_date, reviewed_date, description, duration_minutes, title, created_user_id, updated_user_id, approved_user_id, reviewed_user_id, status_id) FROM stdin;
\.


--
-- Data for Name: test_session; Type: TABLE DATA; Schema: testing_schema; Owner: fractal
--

COPY testing_schema.test_session (id, created_date, updated_date, approved_date, reviewed_date, end_date, score, start_date, created_user_id, updated_user_id, approved_user_id, reviewed_user_id, status_id, test_id, user_id) FROM stdin;
\.


--
-- Data for Name: attribute; Type: TABLE DATA; Schema: ui_schema; Owner: fractal
--

COPY ui_schema.attribute (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: component; Type: TABLE DATA; Schema: ui_schema; Owner: fractal
--

COPY ui_schema.component (id, created_date, updated_date, code, name, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: component_attributes; Type: TABLE DATA; Schema: ui_schema; Owner: fractal
--

COPY ui_schema.component_attributes (id, created_date, updated_date, created_user_id, updated_user_id, attribute_id, component_id, status_id) FROM stdin;
\.


--
-- Data for Name: authentication; Type: TABLE DATA; Schema: user_schema; Owner: fractal
--

COPY user_schema.authentication (id, language, sign_in_date, sign_out_date, token, status_id, user_id) FROM stdin;
\.


--
-- Data for Name: profile; Type: TABLE DATA; Schema: user_schema; Owner: fractal
--

COPY user_schema.profile (id, created_date, updated_date, value, created_user_id, updated_user_id, profile_attribute_id, status_id, user_id) FROM stdin;
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: user_schema; Owner: fractal
--

COPY user_schema."user" (id, created_date, updated_date, employee_id, is_account_expired, is_active, is_credentials_expired, is_lock, password, username, created_user_id, updated_user_id) FROM stdin;
\.


--
-- Data for Name: work_schedule; Type: TABLE DATA; Schema: work_schedule_schema; Owner: fractal
--

COPY work_schedule_schema.work_schedule (id, created_date, updated_date, end_time, start_time, created_user_id, updated_user_id, status_id, week_day_id) FROM stdin;
4	2025-08-24 15:37:40.35199	\N	21:00:00	00:00:00	\N	\N	5	1
\.


--
-- Name: permission_id_seq; Type: SEQUENCE SET; Schema: authorization_schema; Owner: fractal
--

SELECT pg_catalog.setval('authorization_schema.permission_id_seq', 217, true);


--
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: authorization_schema; Owner: fractal
--

SELECT pg_catalog.setval('authorization_schema.role_id_seq', 7, true);


--
-- Name: role_menu_id_seq; Type: SEQUENCE SET; Schema: authorization_schema; Owner: fractal
--

SELECT pg_catalog.setval('authorization_schema.role_menu_id_seq', 66, true);


--
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: authorization_schema; Owner: fractal
--

SELECT pg_catalog.setval('authorization_schema.user_id_seq', 8, true);


--
-- Name: user_role_id_seq; Type: SEQUENCE SET; Schema: authorization_schema; Owner: fractal
--

SELECT pg_catalog.setval('authorization_schema.user_role_id_seq', 9, true);


--
-- Name: citizenship_id_seq; Type: SEQUENCE SET; Schema: citizenship_schema; Owner: fractal
--

SELECT pg_catalog.setval('citizenship_schema.citizenship_id_seq', 8, true);


--
-- Name: contact_type_id_seq; Type: SEQUENCE SET; Schema: contact_schema; Owner: fractal
--

SELECT pg_catalog.setval('contact_schema.contact_type_id_seq', 6, true);


--
-- Name: boolean_type_id_seq; Type: SEQUENCE SET; Schema: dictionary_schema; Owner: fractal
--

SELECT pg_catalog.setval('dictionary_schema.boolean_type_id_seq', 1, false);


--
-- Name: color_id_seq; Type: SEQUENCE SET; Schema: dictionary_schema; Owner: fractal
--

SELECT pg_catalog.setval('dictionary_schema.color_id_seq', 1, false);


--
-- Name: currency_id_seq; Type: SEQUENCE SET; Schema: dictionary_schema; Owner: fractal
--

SELECT pg_catalog.setval('dictionary_schema.currency_id_seq', 6, true);


--
-- Name: entity_type_id_seq; Type: SEQUENCE SET; Schema: dictionary_schema; Owner: fractal
--

SELECT pg_catalog.setval('dictionary_schema.entity_type_id_seq', 1, false);


--
-- Name: gender_id_seq; Type: SEQUENCE SET; Schema: dictionary_schema; Owner: fractal
--

SELECT pg_catalog.setval('dictionary_schema.gender_id_seq', 21, true);


--
-- Name: marital_status_id_seq; Type: SEQUENCE SET; Schema: dictionary_schema; Owner: fractal
--

SELECT pg_catalog.setval('dictionary_schema.marital_status_id_seq', 8, true);


--
-- Name: nationality_id_seq; Type: SEQUENCE SET; Schema: dictionary_schema; Owner: fractal
--

SELECT pg_catalog.setval('dictionary_schema.nationality_id_seq', 1, true);


--
-- Name: notification_template_id_seq; Type: SEQUENCE SET; Schema: dictionary_schema; Owner: fractal
--

SELECT pg_catalog.setval('dictionary_schema.notification_template_id_seq', 1, false);


--
-- Name: priority_id_seq; Type: SEQUENCE SET; Schema: dictionary_schema; Owner: fractal
--

SELECT pg_catalog.setval('dictionary_schema.priority_id_seq', 1, false);


--
-- Name: profile_attribute_id_seq; Type: SEQUENCE SET; Schema: dictionary_schema; Owner: fractal
--

SELECT pg_catalog.setval('dictionary_schema.profile_attribute_id_seq', 1, false);


--
-- Name: status_category_id_seq; Type: SEQUENCE SET; Schema: dictionary_schema; Owner: fractal
--

SELECT pg_catalog.setval('dictionary_schema.status_category_id_seq', 5, true);


--
-- Name: status_id_seq; Type: SEQUENCE SET; Schema: dictionary_schema; Owner: fractal
--

SELECT pg_catalog.setval('dictionary_schema.status_id_seq', 6, true);


--
-- Name: week_day_id_seq; Type: SEQUENCE SET; Schema: dictionary_schema; Owner: fractal
--

SELECT pg_catalog.setval('dictionary_schema.week_day_id_seq', 8, true);


--
-- Name: accreditation_status_id_seq; Type: SEQUENCE SET; Schema: education_schema; Owner: fractal
--

SELECT pg_catalog.setval('education_schema.accreditation_status_id_seq', 8, true);


--
-- Name: degree_type_id_seq; Type: SEQUENCE SET; Schema: education_schema; Owner: fractal
--

SELECT pg_catalog.setval('education_schema.degree_type_id_seq', 4, true);


--
-- Name: education_document_type_id_seq; Type: SEQUENCE SET; Schema: education_schema; Owner: fractal
--

SELECT pg_catalog.setval('education_schema.education_document_type_id_seq', 5, true);


--
-- Name: education_id_seq; Type: SEQUENCE SET; Schema: education_schema; Owner: fractal
--

SELECT pg_catalog.setval('education_schema.education_id_seq', 6, true);


--
-- Name: education_type_id_seq; Type: SEQUENCE SET; Schema: education_schema; Owner: fractal
--

SELECT pg_catalog.setval('education_schema.education_type_id_seq', 6, true);


--
-- Name: grade_point_average_id_seq; Type: SEQUENCE SET; Schema: education_schema; Owner: fractal
--

SELECT pg_catalog.setval('education_schema.grade_point_average_id_seq', 6, true);


--
-- Name: absence_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.absence_id_seq', 1, false);


--
-- Name: absence_type_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.absence_type_id_seq', 1, false);


--
-- Name: agreement_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.agreement_id_seq', 1, false);


--
-- Name: attendance_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.attendance_id_seq', 1, false);


--
-- Name: business_trip_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.business_trip_id_seq', 1, false);


--
-- Name: business_trip_type_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.business_trip_type_id_seq', 4, true);


--
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.category_id_seq', 10, true);


--
-- Name: citizenship_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.citizenship_id_seq', 1, false);


--
-- Name: degree_type_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.degree_type_id_seq', 1, false);


--
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.employee_id_seq', 1, false);


--
-- Name: employment_history_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.employment_history_id_seq', 1, false);


--
-- Name: improvement_area_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.improvement_area_id_seq', 1, false);


--
-- Name: military_data_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.military_data_id_seq', 1, false);


--
-- Name: order_type_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.order_type_id_seq', 7, true);


--
-- Name: performance_goal_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.performance_goal_id_seq', 1, false);


--
-- Name: performance_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.performance_id_seq', 1, false);


--
-- Name: performance_type_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.performance_type_id_seq', 6, true);


--
-- Name: relation_type_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.relation_type_id_seq', 9, true);


--
-- Name: relative_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.relative_id_seq', 1, false);


--
-- Name: subordinate_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.subordinate_id_seq', 1, false);


--
-- Name: subordinate_type_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.subordinate_type_id_seq', 5, true);


--
-- Name: vacation_category_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.vacation_category_id_seq', 1, false);


--
-- Name: vacation_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.vacation_id_seq', 1, false);


--
-- Name: vacation_type_id_seq; Type: SEQUENCE SET; Schema: employee_schema; Owner: fractal
--

SELECT pg_catalog.setval('employee_schema.vacation_type_id_seq', 3, true);


--
-- Name: employment_type_id_seq; Type: SEQUENCE SET; Schema: employment_schema; Owner: fractal
--

SELECT pg_catalog.setval('employment_schema.employment_type_id_seq', 3, true);


--
-- Name: work_experience_id_seq; Type: SEQUENCE SET; Schema: employment_schema; Owner: fractal
--

SELECT pg_catalog.setval('employment_schema.work_experience_id_seq', 7, true);


--
-- Name: identification_document_id_seq; Type: SEQUENCE SET; Schema: identification_schema; Owner: fractal
--

SELECT pg_catalog.setval('identification_schema.identification_document_id_seq', 8, true);


--
-- Name: identification_document_type_id_seq; Type: SEQUENCE SET; Schema: identification_schema; Owner: fractal
--

SELECT pg_catalog.setval('identification_schema.identification_document_type_id_seq', 4, true);


--
-- Name: language_id_seq; Type: SEQUENCE SET; Schema: localization_schema; Owner: fractal
--

SELECT pg_catalog.setval('localization_schema.language_id_seq', 5, true);


--
-- Name: layout_label_detail_id_seq; Type: SEQUENCE SET; Schema: localization_schema; Owner: fractal
--

SELECT pg_catalog.setval('localization_schema.layout_label_detail_id_seq', 211, true);


--
-- Name: layout_label_id_seq; Type: SEQUENCE SET; Schema: localization_schema; Owner: fractal
--

SELECT pg_catalog.setval('localization_schema.layout_label_id_seq', 81, true);


--
-- Name: address_type_id_seq; Type: SEQUENCE SET; Schema: location_schema; Owner: fractal
--

SELECT pg_catalog.setval('location_schema.address_type_id_seq', 8, true);


--
-- Name: area_type_id_seq; Type: SEQUENCE SET; Schema: location_schema; Owner: fractal
--

SELECT pg_catalog.setval('location_schema.area_type_id_seq', 3, true);


--
-- Name: city_id_seq; Type: SEQUENCE SET; Schema: location_schema; Owner: fractal
--

SELECT pg_catalog.setval('location_schema.city_id_seq', 9, true);


--
-- Name: country_id_seq; Type: SEQUENCE SET; Schema: location_schema; Owner: fractal
--

SELECT pg_catalog.setval('location_schema.country_id_seq', 6, true);


--
-- Name: district_id_seq; Type: SEQUENCE SET; Schema: location_schema; Owner: fractal
--

SELECT pg_catalog.setval('location_schema.district_id_seq', 5, true);


--
-- Name: region_id_seq; Type: SEQUENCE SET; Schema: location_schema; Owner: fractal
--

SELECT pg_catalog.setval('location_schema.region_id_seq', 8, true);


--
-- Name: military_service_id_seq; Type: SEQUENCE SET; Schema: military_schema; Owner: fractal
--

SELECT pg_catalog.setval('military_schema.military_service_id_seq', 7, true);


--
-- Name: action_category_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.action_category_id_seq', 2, true);


--
-- Name: action_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.action_id_seq', 6, true);


--
-- Name: action_type_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.action_type_id_seq', 3, true);


--
-- Name: configuration_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.configuration_id_seq', 1, false);


--
-- Name: form_component_attributes_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.form_component_attributes_id_seq', 1, false);


--
-- Name: form_components_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.form_components_id_seq', 1, false);


--
-- Name: menu_action_form_component_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.menu_action_form_component_id_seq', 1, false);


--
-- Name: menu_action_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.menu_action_id_seq', 210, true);


--
-- Name: menu_action_transition_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.menu_action_transition_id_seq', 1, false);


--
-- Name: menu_configuration_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.menu_configuration_id_seq', 1, false);


--
-- Name: menu_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.menu_id_seq', 89, true);


--
-- Name: menu_transition_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.menu_transition_id_seq', 1, false);


--
-- Name: navigation_unit_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.navigation_unit_id_seq', 1, false);


--
-- Name: public_url_id_seq; Type: SEQUENCE SET; Schema: navigation_schema; Owner: fractal
--

SELECT pg_catalog.setval('navigation_schema.public_url_id_seq', 1, false);


--
-- Name: accountability_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.accountability_id_seq', 8, true);


--
-- Name: authority_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.authority_id_seq', 10, true);


--
-- Name: department_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.department_id_seq', 27, true);


--
-- Name: grade_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.grade_id_seq', 17, true);


--
-- Name: grade_level_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.grade_level_id_seq', 4, true);


--
-- Name: grade_step_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.grade_step_id_seq', 27, true);


--
-- Name: job_description_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.job_description_id_seq', 6, true);


--
-- Name: key_performance_indicator_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.key_performance_indicator_id_seq', 9, true);


--
-- Name: organization_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.organization_id_seq', 9, true);


--
-- Name: organization_unit_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.organization_unit_id_seq', 7, true);


--
-- Name: position_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.position_id_seq', 15, true);


--
-- Name: qualification_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.qualification_id_seq', 11, true);


--
-- Name: reporting_line_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.reporting_line_id_seq', 6, true);


--
-- Name: reporting_line_type_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.reporting_line_type_id_seq', 8, true);


--
-- Name: required_experience_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.required_experience_id_seq', 7, true);


--
-- Name: responsibility_id_seq; Type: SEQUENCE SET; Schema: organization_schema; Owner: fractal
--

SELECT pg_catalog.setval('organization_schema.responsibility_id_seq', 8, true);


--
-- Name: address_seq; Type: SEQUENCE SET; Schema: public; Owner: fractal
--

SELECT pg_catalog.setval('public.address_seq', 501, true);


--
-- Name: contact_seq; Type: SEQUENCE SET; Schema: public; Owner: fractal
--

SELECT pg_catalog.setval('public.contact_seq', 401, true);


--
-- Name: oder_seq; Type: SEQUENCE SET; Schema: public; Owner: fractal
--

SELECT pg_catalog.setval('public.oder_seq', 1, false);


--
-- Name: order_seq; Type: SEQUENCE SET; Schema: public; Owner: fractal
--

SELECT pg_catalog.setval('public.order_seq', 1, false);


--
-- Name: resource_seq; Type: SEQUENCE SET; Schema: public; Owner: fractal
--

SELECT pg_catalog.setval('public.resource_seq', 1, false);


--
-- Name: candidate_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.candidate_id_seq', 9, true);


--
-- Name: candidate_resource_type_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.candidate_resource_type_id_seq', 6, true);


--
-- Name: duty_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.duty_id_seq', 1, false);


--
-- Name: experience_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.experience_id_seq', 1, false);


--
-- Name: interview_evaluation_answer_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.interview_evaluation_answer_id_seq', 1, false);


--
-- Name: interview_evaluation_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.interview_evaluation_id_seq', 1, false);


--
-- Name: interview_evaluation_question_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.interview_evaluation_question_id_seq', 1, false);


--
-- Name: interview_evaluation_section_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.interview_evaluation_section_id_seq', 1, false);


--
-- Name: interview_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.interview_id_seq', 1, false);


--
-- Name: interview_type_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.interview_type_id_seq', 4, true);


--
-- Name: interviewee_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.interviewee_id_seq', 1, false);


--
-- Name: interviewer_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.interviewer_id_seq', 1, false);


--
-- Name: skill_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.skill_id_seq', 1, false);


--
-- Name: vacancy_id_seq; Type: SEQUENCE SET; Schema: recruitment_schema; Owner: fractal
--

SELECT pg_catalog.setval('recruitment_schema.vacancy_id_seq', 1, false);


--
-- Name: entity_state_id_seq; Type: SEQUENCE SET; Schema: state_schema; Owner: fractal
--

SELECT pg_catalog.setval('state_schema.entity_state_id_seq', 1, false);


--
-- Name: environment_variable_id_seq; Type: SEQUENCE SET; Schema: system_schema; Owner: fractal
--

SELECT pg_catalog.setval('system_schema.environment_variable_id_seq', 1, false);


--
-- Name: message_id_seq; Type: SEQUENCE SET; Schema: system_schema; Owner: fractal
--

SELECT pg_catalog.setval('system_schema.message_id_seq', 1, false);


--
-- Name: message_type_id_seq; Type: SEQUENCE SET; Schema: system_schema; Owner: fractal
--

SELECT pg_catalog.setval('system_schema.message_type_id_seq', 1, false);


--
-- Name: notification_id_seq; Type: SEQUENCE SET; Schema: system_schema; Owner: fractal
--

SELECT pg_catalog.setval('system_schema.notification_id_seq', 1, false);


--
-- Name: notification_type_id_seq; Type: SEQUENCE SET; Schema: system_schema; Owner: fractal
--

SELECT pg_catalog.setval('system_schema.notification_type_id_seq', 1, false);


--
-- Name: service_provider_id_seq; Type: SEQUENCE SET; Schema: system_schema; Owner: fractal
--

SELECT pg_catalog.setval('system_schema.service_provider_id_seq', 1, false);


--
-- Name: service_provider_type_id_seq; Type: SEQUENCE SET; Schema: system_schema; Owner: fractal
--

SELECT pg_catalog.setval('system_schema.service_provider_type_id_seq', 1, false);


--
-- Name: answer_id_seq; Type: SEQUENCE SET; Schema: testing_schema; Owner: fractal
--

SELECT pg_catalog.setval('testing_schema.answer_id_seq', 1, false);


--
-- Name: answer_submission_id_seq; Type: SEQUENCE SET; Schema: testing_schema; Owner: fractal
--

SELECT pg_catalog.setval('testing_schema.answer_submission_id_seq', 1, false);


--
-- Name: question_id_seq; Type: SEQUENCE SET; Schema: testing_schema; Owner: fractal
--

SELECT pg_catalog.setval('testing_schema.question_id_seq', 1, false);


--
-- Name: question_type_id_seq; Type: SEQUENCE SET; Schema: testing_schema; Owner: fractal
--

SELECT pg_catalog.setval('testing_schema.question_type_id_seq', 1, false);


--
-- Name: selected_answer_id_seq; Type: SEQUENCE SET; Schema: testing_schema; Owner: fractal
--

SELECT pg_catalog.setval('testing_schema.selected_answer_id_seq', 1, false);


--
-- Name: test_id_seq; Type: SEQUENCE SET; Schema: testing_schema; Owner: fractal
--

SELECT pg_catalog.setval('testing_schema.test_id_seq', 1, false);


--
-- Name: test_session_id_seq; Type: SEQUENCE SET; Schema: testing_schema; Owner: fractal
--

SELECT pg_catalog.setval('testing_schema.test_session_id_seq', 1, false);


--
-- Name: attribute_id_seq; Type: SEQUENCE SET; Schema: ui_schema; Owner: fractal
--

SELECT pg_catalog.setval('ui_schema.attribute_id_seq', 1, false);


--
-- Name: component_attributes_id_seq; Type: SEQUENCE SET; Schema: ui_schema; Owner: fractal
--

SELECT pg_catalog.setval('ui_schema.component_attributes_id_seq', 1, false);


--
-- Name: component_id_seq; Type: SEQUENCE SET; Schema: ui_schema; Owner: fractal
--

SELECT pg_catalog.setval('ui_schema.component_id_seq', 1, false);


--
-- Name: authentication_id_seq; Type: SEQUENCE SET; Schema: user_schema; Owner: fractal
--

SELECT pg_catalog.setval('user_schema.authentication_id_seq', 1, false);


--
-- Name: profile_id_seq; Type: SEQUENCE SET; Schema: user_schema; Owner: fractal
--

SELECT pg_catalog.setval('user_schema.profile_id_seq', 1, false);


--
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: user_schema; Owner: fractal
--

SELECT pg_catalog.setval('user_schema.user_id_seq', 1, false);


--
-- Name: work_schedule_id_seq; Type: SEQUENCE SET; Schema: work_schedule_schema; Owner: fractal
--

SELECT pg_catalog.setval('work_schedule_schema.work_schedule_id_seq', 4, true);


--
-- Name: permission permission_pkey; Type: CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.permission
    ADD CONSTRAINT permission_pkey PRIMARY KEY (id);


--
-- Name: role_menu role_menu_pkey; Type: CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.role_menu
    ADD CONSTRAINT role_menu_pkey PRIMARY KEY (id);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: user_role user_role_pkey; Type: CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.user_role
    ADD CONSTRAINT user_role_pkey PRIMARY KEY (id);


--
-- Name: citizenship citizenship_pkey; Type: CONSTRAINT; Schema: citizenship_schema; Owner: fractal
--

ALTER TABLE ONLY citizenship_schema.citizenship
    ADD CONSTRAINT citizenship_pkey PRIMARY KEY (id);


--
-- Name: contact contact_pkey; Type: CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.contact
    ADD CONSTRAINT contact_pkey PRIMARY KEY (id);


--
-- Name: contact_type contact_type_pkey; Type: CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.contact_type
    ADD CONSTRAINT contact_type_pkey PRIMARY KEY (id);


--
-- Name: email email_pkey; Type: CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.email
    ADD CONSTRAINT email_pkey PRIMARY KEY (id);


--
-- Name: phone phone_pkey; Type: CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.phone
    ADD CONSTRAINT phone_pkey PRIMARY KEY (id);


--
-- Name: contact_type uk6xkkjn2v20dl07mev8umc1ism; Type: CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.contact_type
    ADD CONSTRAINT uk6xkkjn2v20dl07mev8umc1ism UNIQUE (code);


--
-- Name: boolean_type boolean_type_pkey; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.boolean_type
    ADD CONSTRAINT boolean_type_pkey PRIMARY KEY (id);


--
-- Name: color color_pkey; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.color
    ADD CONSTRAINT color_pkey PRIMARY KEY (id);


--
-- Name: currency currency_pkey; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.currency
    ADD CONSTRAINT currency_pkey PRIMARY KEY (id);


--
-- Name: entity_type entity_type_pkey; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.entity_type
    ADD CONSTRAINT entity_type_pkey PRIMARY KEY (id);


--
-- Name: gender gender_pkey; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.gender
    ADD CONSTRAINT gender_pkey PRIMARY KEY (id);


--
-- Name: marital_status marital_status_pkey; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.marital_status
    ADD CONSTRAINT marital_status_pkey PRIMARY KEY (id);


--
-- Name: nationality nationality_pkey; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.nationality
    ADD CONSTRAINT nationality_pkey PRIMARY KEY (id);


--
-- Name: notification_template notification_template_pkey; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.notification_template
    ADD CONSTRAINT notification_template_pkey PRIMARY KEY (id);


--
-- Name: priority priority_pkey; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.priority
    ADD CONSTRAINT priority_pkey PRIMARY KEY (id);


--
-- Name: profile_attribute profile_attribute_pkey; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.profile_attribute
    ADD CONSTRAINT profile_attribute_pkey PRIMARY KEY (id);


--
-- Name: status_category status_category_pkey; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.status_category
    ADD CONSTRAINT status_category_pkey PRIMARY KEY (id);


--
-- Name: status status_pkey; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.status
    ADD CONSTRAINT status_pkey PRIMARY KEY (id);


--
-- Name: profile_attribute uk15s1544boy61ldqmww1udf0wm; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.profile_attribute
    ADD CONSTRAINT uk15s1544boy61ldqmww1udf0wm UNIQUE (code);


--
-- Name: marital_status uk2pst8q940ve55w5fcb8rals9t; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.marital_status
    ADD CONSTRAINT uk2pst8q940ve55w5fcb8rals9t UNIQUE (code);


--
-- Name: priority uk639erqxmw75u6kt3lfksougmb; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.priority
    ADD CONSTRAINT uk639erqxmw75u6kt3lfksougmb UNIQUE (code);


--
-- Name: notification_template uk78ljxu1rtyj29qj8a3bao9bfx; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.notification_template
    ADD CONSTRAINT uk78ljxu1rtyj29qj8a3bao9bfx UNIQUE (code);


--
-- Name: entity_type uk8ykg7p8p3n0hjnpwl9gft36g3; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.entity_type
    ADD CONSTRAINT uk8ykg7p8p3n0hjnpwl9gft36g3 UNIQUE (code);


--
-- Name: status uk90n0sv25slo1kmu0tcakhjjed; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.status
    ADD CONSTRAINT uk90n0sv25slo1kmu0tcakhjjed UNIQUE (code);


--
-- Name: color ukcbnc5ktj6whhh690w32k8cyh8; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.color
    ADD CONSTRAINT ukcbnc5ktj6whhh690w32k8cyh8 UNIQUE (code);


--
-- Name: status_category ukdldakj77yydalqni2sj0u6inw; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.status_category
    ADD CONSTRAINT ukdldakj77yydalqni2sj0u6inw UNIQUE (code);


--
-- Name: nationality ukfhrdubfm3may69kh6fx05ndk; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.nationality
    ADD CONSTRAINT ukfhrdubfm3may69kh6fx05ndk UNIQUE (code);


--
-- Name: currency ukh84pd2rtr12isnifnj655rkra; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.currency
    ADD CONSTRAINT ukh84pd2rtr12isnifnj655rkra UNIQUE (code);


--
-- Name: week_day ukhq6bi56xgu0lkj3a8x55ibm08; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.week_day
    ADD CONSTRAINT ukhq6bi56xgu0lkj3a8x55ibm08 UNIQUE (code);


--
-- Name: boolean_type ukkfut4g2l7kkee3l47xjsmn3w3; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.boolean_type
    ADD CONSTRAINT ukkfut4g2l7kkee3l47xjsmn3w3 UNIQUE (code);


--
-- Name: gender ukmxvfcsf1euhi5hsw1uecvke7b; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.gender
    ADD CONSTRAINT ukmxvfcsf1euhi5hsw1uecvke7b UNIQUE (code);


--
-- Name: week_day week_day_pkey; Type: CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.week_day
    ADD CONSTRAINT week_day_pkey PRIMARY KEY (id);


--
-- Name: accreditation_status accreditation_status_pkey; Type: CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.accreditation_status
    ADD CONSTRAINT accreditation_status_pkey PRIMARY KEY (id);


--
-- Name: degree_type degree_type_pkey; Type: CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.degree_type
    ADD CONSTRAINT degree_type_pkey PRIMARY KEY (id);


--
-- Name: education_document_type education_document_type_pkey; Type: CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education_document_type
    ADD CONSTRAINT education_document_type_pkey PRIMARY KEY (id);


--
-- Name: education education_pkey; Type: CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education
    ADD CONSTRAINT education_pkey PRIMARY KEY (id);


--
-- Name: education_resource education_resource_pkey; Type: CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education_resource
    ADD CONSTRAINT education_resource_pkey PRIMARY KEY (id);


--
-- Name: education_type education_type_pkey; Type: CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education_type
    ADD CONSTRAINT education_type_pkey PRIMARY KEY (id);


--
-- Name: grade_point_average grade_point_average_pkey; Type: CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.grade_point_average
    ADD CONSTRAINT grade_point_average_pkey PRIMARY KEY (id);


--
-- Name: education_type ukbs1eww46yx7tfr1mmj1992mwo; Type: CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education_type
    ADD CONSTRAINT ukbs1eww46yx7tfr1mmj1992mwo UNIQUE (code);


--
-- Name: degree_type ukf8slwa45wba6217cj0pm28i4a; Type: CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.degree_type
    ADD CONSTRAINT ukf8slwa45wba6217cj0pm28i4a UNIQUE (code);


--
-- Name: accreditation_status uklpn2bhq1jq2wwib5drvl636eq; Type: CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.accreditation_status
    ADD CONSTRAINT uklpn2bhq1jq2wwib5drvl636eq UNIQUE (code);


--
-- Name: education_document_type uksf750v55q844hxbs563cjn5m6; Type: CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education_document_type
    ADD CONSTRAINT uksf750v55q844hxbs563cjn5m6 UNIQUE (code);


--
-- Name: absence absence_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.absence
    ADD CONSTRAINT absence_pkey PRIMARY KEY (id);


--
-- Name: absence_type absence_type_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.absence_type
    ADD CONSTRAINT absence_type_pkey PRIMARY KEY (id);


--
-- Name: agreement agreement_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.agreement
    ADD CONSTRAINT agreement_pkey PRIMARY KEY (id);


--
-- Name: agreement_resource agreement_resource_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.agreement_resource
    ADD CONSTRAINT agreement_resource_pkey PRIMARY KEY (id);


--
-- Name: attendance attendance_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.attendance
    ADD CONSTRAINT attendance_pkey PRIMARY KEY (id);


--
-- Name: business_trip_order business_trip_order_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip_order
    ADD CONSTRAINT business_trip_order_pkey PRIMARY KEY (id);


--
-- Name: business_trip business_trip_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip
    ADD CONSTRAINT business_trip_pkey PRIMARY KEY (id);


--
-- Name: business_trip_resource business_trip_resource_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip_resource
    ADD CONSTRAINT business_trip_resource_pkey PRIMARY KEY (id);


--
-- Name: business_trip_type business_trip_type_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip_type
    ADD CONSTRAINT business_trip_type_pkey PRIMARY KEY (id);


--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- Name: citizenship citizenship_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.citizenship
    ADD CONSTRAINT citizenship_pkey PRIMARY KEY (id);


--
-- Name: degree_type degree_type_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.degree_type
    ADD CONSTRAINT degree_type_pkey PRIMARY KEY (id);


--
-- Name: employee_address employee_address_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_address
    ADD CONSTRAINT employee_address_pkey PRIMARY KEY (id);


--
-- Name: employee_citizenship employee_citizenship_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_citizenship
    ADD CONSTRAINT employee_citizenship_pkey PRIMARY KEY (id);


--
-- Name: employee_contact employee_contact_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_contact
    ADD CONSTRAINT employee_contact_pkey PRIMARY KEY (id);


--
-- Name: employee_education employee_education_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_education
    ADD CONSTRAINT employee_education_pkey PRIMARY KEY (id);


--
-- Name: employee_identification_document employee_identification_document_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_identification_document
    ADD CONSTRAINT employee_identification_document_pkey PRIMARY KEY (id);


--
-- Name: employee_military_service employee_military_service_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_military_service
    ADD CONSTRAINT employee_military_service_pkey PRIMARY KEY (id);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- Name: employee_resource employee_resource_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_resource
    ADD CONSTRAINT employee_resource_pkey PRIMARY KEY (id);


--
-- Name: employee_work_experience employee_work_experience_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_work_experience
    ADD CONSTRAINT employee_work_experience_pkey PRIMARY KEY (id);


--
-- Name: employment_history_order employment_history_order_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employment_history_order
    ADD CONSTRAINT employment_history_order_pkey PRIMARY KEY (id);


--
-- Name: employment_history employment_history_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employment_history
    ADD CONSTRAINT employment_history_pkey PRIMARY KEY (id);


--
-- Name: identification_document_resource identification_document_resource_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.identification_document_resource
    ADD CONSTRAINT identification_document_resource_pkey PRIMARY KEY (id);


--
-- Name: improvement_area improvement_area_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.improvement_area
    ADD CONSTRAINT improvement_area_pkey PRIMARY KEY (id);


--
-- Name: military_data military_data_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.military_data
    ADD CONSTRAINT military_data_pkey PRIMARY KEY (id);


--
-- Name: military_service_resource military_service_resource_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.military_service_resource
    ADD CONSTRAINT military_service_resource_pkey PRIMARY KEY (id);


--
-- Name: order oder_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema."order"
    ADD CONSTRAINT oder_pkey PRIMARY KEY (id);


--
-- Name: order_resource order_resource_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.order_resource
    ADD CONSTRAINT order_resource_pkey PRIMARY KEY (id);


--
-- Name: order_type order_type_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.order_type
    ADD CONSTRAINT order_type_pkey PRIMARY KEY (id);


--
-- Name: performance_goal performance_goal_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance_goal
    ADD CONSTRAINT performance_goal_pkey PRIMARY KEY (id);


--
-- Name: performance performance_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance
    ADD CONSTRAINT performance_pkey PRIMARY KEY (id);


--
-- Name: performance_type performance_type_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance_type
    ADD CONSTRAINT performance_type_pkey PRIMARY KEY (id);


--
-- Name: relation_type relation_type_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relation_type
    ADD CONSTRAINT relation_type_pkey PRIMARY KEY (id);


--
-- Name: relative_address relative_address_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative_address
    ADD CONSTRAINT relative_address_pkey PRIMARY KEY (id);


--
-- Name: relative_contact relative_contact_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative_contact
    ADD CONSTRAINT relative_contact_pkey PRIMARY KEY (id);


--
-- Name: relative relative_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative
    ADD CONSTRAINT relative_pkey PRIMARY KEY (id);


--
-- Name: subordinate subordinate_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.subordinate
    ADD CONSTRAINT subordinate_pkey PRIMARY KEY (id);


--
-- Name: subordinate_type subordinate_type_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.subordinate_type
    ADD CONSTRAINT subordinate_type_pkey PRIMARY KEY (id);


--
-- Name: order_type uk4guluy495shiio5qhhmb79tp6; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.order_type
    ADD CONSTRAINT uk4guluy495shiio5qhhmb79tp6 UNIQUE (code);


--
-- Name: subordinate_type uk4lblubv0wriq6p2wnl202v8cp; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.subordinate_type
    ADD CONSTRAINT uk4lblubv0wriq6p2wnl202v8cp UNIQUE (code);


--
-- Name: absence_type uk9v9g4p72tax6fkuo4id7943jt; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.absence_type
    ADD CONSTRAINT uk9v9g4p72tax6fkuo4id7943jt UNIQUE (code);


--
-- Name: category ukacatplu22q5d1andql2jbvjy7; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.category
    ADD CONSTRAINT ukacatplu22q5d1andql2jbvjy7 UNIQUE (code);


--
-- Name: performance_type ukbxm6l0cvge4qtuc250wsx321b; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance_type
    ADD CONSTRAINT ukbxm6l0cvge4qtuc250wsx321b UNIQUE (code);


--
-- Name: degree_type ukf8slwa45wba6217cj0pm28i4a; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.degree_type
    ADD CONSTRAINT ukf8slwa45wba6217cj0pm28i4a UNIQUE (code);


--
-- Name: relation_type ukifjynaw0ofk2slpcyf6453ele; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relation_type
    ADD CONSTRAINT ukifjynaw0ofk2slpcyf6453ele UNIQUE (code);


--
-- Name: business_trip_type uko1ggbkyajjiptmcomhi0ffagm; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip_type
    ADD CONSTRAINT uko1ggbkyajjiptmcomhi0ffagm UNIQUE (code);


--
-- Name: vacation_category ukrp87nf5taxt1ugg3b5h21q3lo; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation_category
    ADD CONSTRAINT ukrp87nf5taxt1ugg3b5h21q3lo UNIQUE (code);


--
-- Name: vacation_type ukx7o5137x8hwqhuh1wml1n32r; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation_type
    ADD CONSTRAINT ukx7o5137x8hwqhuh1wml1n32r UNIQUE (code);


--
-- Name: vacation_category vacation_category_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation_category
    ADD CONSTRAINT vacation_category_pkey PRIMARY KEY (id);


--
-- Name: vacation vacation_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation
    ADD CONSTRAINT vacation_pkey PRIMARY KEY (id);


--
-- Name: vacation_type vacation_type_pkey; Type: CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation_type
    ADD CONSTRAINT vacation_type_pkey PRIMARY KEY (id);


--
-- Name: employment_type employment_type_pkey; Type: CONSTRAINT; Schema: employment_schema; Owner: fractal
--

ALTER TABLE ONLY employment_schema.employment_type
    ADD CONSTRAINT employment_type_pkey PRIMARY KEY (id);


--
-- Name: employment_type uk71pmomvgrujwpl0dg2shtvlut; Type: CONSTRAINT; Schema: employment_schema; Owner: fractal
--

ALTER TABLE ONLY employment_schema.employment_type
    ADD CONSTRAINT uk71pmomvgrujwpl0dg2shtvlut UNIQUE (code);


--
-- Name: work_experience work_experience_pkey; Type: CONSTRAINT; Schema: employment_schema; Owner: fractal
--

ALTER TABLE ONLY employment_schema.work_experience
    ADD CONSTRAINT work_experience_pkey PRIMARY KEY (id);


--
-- Name: identification_document identification_document_pkey; Type: CONSTRAINT; Schema: identification_schema; Owner: fractal
--

ALTER TABLE ONLY identification_schema.identification_document
    ADD CONSTRAINT identification_document_pkey PRIMARY KEY (id);


--
-- Name: identification_document_type identification_document_type_pkey; Type: CONSTRAINT; Schema: identification_schema; Owner: fractal
--

ALTER TABLE ONLY identification_schema.identification_document_type
    ADD CONSTRAINT identification_document_type_pkey PRIMARY KEY (id);


--
-- Name: identification_document_type uk2dxiha4nh0a2kcxd2o4o3tshf; Type: CONSTRAINT; Schema: identification_schema; Owner: fractal
--

ALTER TABLE ONLY identification_schema.identification_document_type
    ADD CONSTRAINT uk2dxiha4nh0a2kcxd2o4o3tshf UNIQUE (code);


--
-- Name: language language_pkey; Type: CONSTRAINT; Schema: localization_schema; Owner: fractal
--

ALTER TABLE ONLY localization_schema.language
    ADD CONSTRAINT language_pkey PRIMARY KEY (id);


--
-- Name: layout_label_detail layout_label_detail_pkey; Type: CONSTRAINT; Schema: localization_schema; Owner: fractal
--

ALTER TABLE ONLY localization_schema.layout_label_detail
    ADD CONSTRAINT layout_label_detail_pkey PRIMARY KEY (id);


--
-- Name: layout_label layout_label_pkey; Type: CONSTRAINT; Schema: localization_schema; Owner: fractal
--

ALTER TABLE ONLY localization_schema.layout_label
    ADD CONSTRAINT layout_label_pkey PRIMARY KEY (id);


--
-- Name: address address_pkey; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);


--
-- Name: address_type address_type_pkey; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.address_type
    ADD CONSTRAINT address_type_pkey PRIMARY KEY (id);


--
-- Name: area_type area_type_pkey; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.area_type
    ADD CONSTRAINT area_type_pkey PRIMARY KEY (id);


--
-- Name: city city_pkey; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);


--
-- Name: country country_pkey; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.country
    ADD CONSTRAINT country_pkey PRIMARY KEY (id);


--
-- Name: district district_pkey; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.district
    ADD CONSTRAINT district_pkey PRIMARY KEY (id);


--
-- Name: region region_pkey; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.region
    ADD CONSTRAINT region_pkey PRIMARY KEY (id);


--
-- Name: country uk5s4ptnuqtd24d4p9au2rv53qm; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.country
    ADD CONSTRAINT uk5s4ptnuqtd24d4p9au2rv53qm UNIQUE (code);


--
-- Name: district uk7ava2vvsdlafw7ca6y5j2a6q8; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.district
    ADD CONSTRAINT uk7ava2vvsdlafw7ca6y5j2a6q8 UNIQUE (code);


--
-- Name: country uk7x9edox99l6q9s85eh60h7qx3; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.country
    ADD CONSTRAINT uk7x9edox99l6q9s85eh60h7qx3 UNIQUE (iso3_code);


--
-- Name: area_type uk83ptek778l1bcp5tw5gd7v2hv; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.area_type
    ADD CONSTRAINT uk83ptek778l1bcp5tw5gd7v2hv UNIQUE (code);


--
-- Name: address_type uk855fb2napr2cby4c0dyx62fof; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.address_type
    ADD CONSTRAINT uk855fb2napr2cby4c0dyx62fof UNIQUE (code);


--
-- Name: country ukik5yv6a3ayb6i3fl69nuv2cbg; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.country
    ADD CONSTRAINT ukik5yv6a3ayb6i3fl69nuv2cbg UNIQUE (numeric_code);


--
-- Name: region ukkntnlvx8xwbfrg1flw2mnwa9v; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.region
    ADD CONSTRAINT ukkntnlvx8xwbfrg1flw2mnwa9v UNIQUE (code);


--
-- Name: city ukp738egrkomomgourst3hqfipb; Type: CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.city
    ADD CONSTRAINT ukp738egrkomomgourst3hqfipb UNIQUE (code);


--
-- Name: military_service military_service_pkey; Type: CONSTRAINT; Schema: military_schema; Owner: fractal
--

ALTER TABLE ONLY military_schema.military_service
    ADD CONSTRAINT military_service_pkey PRIMARY KEY (id);


--
-- Name: military_service_resource military_service_resource_pkey; Type: CONSTRAINT; Schema: military_schema; Owner: fractal
--

ALTER TABLE ONLY military_schema.military_service_resource
    ADD CONSTRAINT military_service_resource_pkey PRIMARY KEY (id);


--
-- Name: action_category action_category_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action_category
    ADD CONSTRAINT action_category_pkey PRIMARY KEY (id);


--
-- Name: action action_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action
    ADD CONSTRAINT action_pkey PRIMARY KEY (id);


--
-- Name: action_type action_type_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action_type
    ADD CONSTRAINT action_type_pkey PRIMARY KEY (id);


--
-- Name: configuration configuration_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.configuration
    ADD CONSTRAINT configuration_pkey PRIMARY KEY (id);


--
-- Name: form_component_attributes form_component_attributes_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.form_component_attributes
    ADD CONSTRAINT form_component_attributes_pkey PRIMARY KEY (id);


--
-- Name: form_components form_components_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.form_components
    ADD CONSTRAINT form_components_pkey PRIMARY KEY (id);


--
-- Name: menu_action_form_component menu_action_form_component_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action_form_component
    ADD CONSTRAINT menu_action_form_component_pkey PRIMARY KEY (id);


--
-- Name: menu_action menu_action_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action
    ADD CONSTRAINT menu_action_pkey PRIMARY KEY (id);


--
-- Name: menu_action_transition menu_action_transition_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action_transition
    ADD CONSTRAINT menu_action_transition_pkey PRIMARY KEY (id);


--
-- Name: menu_configuration menu_configuration_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_configuration
    ADD CONSTRAINT menu_configuration_pkey PRIMARY KEY (id);


--
-- Name: menu menu_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (id);


--
-- Name: menu_transition menu_transition_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_transition
    ADD CONSTRAINT menu_transition_pkey PRIMARY KEY (id);


--
-- Name: navigation_unit navigation_unit_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.navigation_unit
    ADD CONSTRAINT navigation_unit_pkey PRIMARY KEY (id);


--
-- Name: public_url public_url_pkey; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.public_url
    ADD CONSTRAINT public_url_pkey PRIMARY KEY (id);


--
-- Name: action_type uk3face27420q5tai4u7senj6id; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action_type
    ADD CONSTRAINT uk3face27420q5tai4u7senj6id UNIQUE (code);


--
-- Name: action_category uks7ch6269v14wjpa05sp193rhn; Type: CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action_category
    ADD CONSTRAINT uks7ch6269v14wjpa05sp193rhn UNIQUE (code);


--
-- Name: accountability accountability_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.accountability
    ADD CONSTRAINT accountability_pkey PRIMARY KEY (id);


--
-- Name: authority authority_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.authority
    ADD CONSTRAINT authority_pkey PRIMARY KEY (id);


--
-- Name: separationReason department_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.separationReason
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


--
-- Name: grade_level grade_level_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade_level
    ADD CONSTRAINT grade_level_pkey PRIMARY KEY (id);


--
-- Name: grade grade_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade
    ADD CONSTRAINT grade_pkey PRIMARY KEY (id);


--
-- Name: grade_step grade_step_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade_step
    ADD CONSTRAINT grade_step_pkey PRIMARY KEY (id);


--
-- Name: job_description job_description_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.job_description
    ADD CONSTRAINT job_description_pkey PRIMARY KEY (id);


--
-- Name: key_performance_indicator key_performance_indicator_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.key_performance_indicator
    ADD CONSTRAINT key_performance_indicator_pkey PRIMARY KEY (id);


--
-- Name: organization_address organization_address_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization_address
    ADD CONSTRAINT organization_address_pkey PRIMARY KEY (id);


--
-- Name: organization_contact organization_contact_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization_contact
    ADD CONSTRAINT organization_contact_pkey PRIMARY KEY (id);


--
-- Name: organization organization_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization
    ADD CONSTRAINT organization_pkey PRIMARY KEY (id);


--
-- Name: organization_unit organization_unit_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization_unit
    ADD CONSTRAINT organization_unit_pkey PRIMARY KEY (id);


--
-- Name: position position_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema."position"
    ADD CONSTRAINT position_pkey PRIMARY KEY (id);


--
-- Name: qualification qualification_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.qualification
    ADD CONSTRAINT qualification_pkey PRIMARY KEY (id);


--
-- Name: reporting_line reporting_line_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.reporting_line
    ADD CONSTRAINT reporting_line_pkey PRIMARY KEY (id);


--
-- Name: reporting_line_type reporting_line_type_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.reporting_line_type
    ADD CONSTRAINT reporting_line_type_pkey PRIMARY KEY (id);


--
-- Name: required_experience required_experience_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.required_experience
    ADD CONSTRAINT required_experience_pkey PRIMARY KEY (id);


--
-- Name: responsibility responsibility_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.responsibility
    ADD CONSTRAINT responsibility_pkey PRIMARY KEY (id);


--
-- Name: organization uk27tbqbmjb9kf4al49ojliavjt; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization
    ADD CONSTRAINT uk27tbqbmjb9kf4al49ojliavjt UNIQUE (code);


--
-- Name: organization_unit uka3pc00agj2tlg6eoo1kvvvkoy; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization_unit
    ADD CONSTRAINT uka3pc00agj2tlg6eoo1kvvvkoy UNIQUE (code);


--
-- Name: position ukaqoegu9tj6s7t7f31abslcng; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema."position"
    ADD CONSTRAINT ukaqoegu9tj6s7t7f31abslcng UNIQUE (code);


--
-- Name: grade_level ukbjrlvdyf754q4tuy7y3d6yv0x; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade_level
    ADD CONSTRAINT ukbjrlvdyf754q4tuy7y3d6yv0x UNIQUE (code);


--
-- Name: grade ukmfpeq9u7tfkalk2vbwwibtf4f; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade
    ADD CONSTRAINT ukmfpeq9u7tfkalk2vbwwibtf4f UNIQUE (code);


--
-- Name: separationReason ukq8ymhgj6pt1msox0o3bg51uvo; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.separationReason
    ADD CONSTRAINT ukq8ymhgj6pt1msox0o3bg51uvo UNIQUE (code);


--
-- Name: reporting_line_type ukrs8vcxrd9geshgoit5p4u7i0h; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.reporting_line_type
    ADD CONSTRAINT ukrs8vcxrd9geshgoit5p4u7i0h UNIQUE (code);


--
-- Name: work_schedule work_schedule_pkey; Type: CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.work_schedule
    ADD CONSTRAINT work_schedule_pkey PRIMARY KEY (id);


--
-- Name: candidate_address candidate_address_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_address
    ADD CONSTRAINT candidate_address_pkey PRIMARY KEY (id);


--
-- Name: candidate_citizenship candidate_citizenship_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_citizenship
    ADD CONSTRAINT candidate_citizenship_pkey PRIMARY KEY (id);


--
-- Name: candidate_contact candidate_contact_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_contact
    ADD CONSTRAINT candidate_contact_pkey PRIMARY KEY (id);


--
-- Name: candidate_education candidate_education_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_education
    ADD CONSTRAINT candidate_education_pkey PRIMARY KEY (id);


--
-- Name: candidate_identification_document candidate_identification_document_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_identification_document
    ADD CONSTRAINT candidate_identification_document_pkey PRIMARY KEY (id);


--
-- Name: candidate_military_service candidate_military_service_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_military_service
    ADD CONSTRAINT candidate_military_service_pkey PRIMARY KEY (id);


--
-- Name: candidate candidate_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate
    ADD CONSTRAINT candidate_pkey PRIMARY KEY (id);


--
-- Name: candidate_resource candidate_resource_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_resource
    ADD CONSTRAINT candidate_resource_pkey PRIMARY KEY (id);


--
-- Name: candidate_resource_type candidate_resource_type_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_resource_type
    ADD CONSTRAINT candidate_resource_type_pkey PRIMARY KEY (id);


--
-- Name: candidate_work_experience candidate_work_experience_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_work_experience
    ADD CONSTRAINT candidate_work_experience_pkey PRIMARY KEY (id);


--
-- Name: duty duty_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.duty
    ADD CONSTRAINT duty_pkey PRIMARY KEY (id);


--
-- Name: experience experience_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.experience
    ADD CONSTRAINT experience_pkey PRIMARY KEY (id);


--
-- Name: interview_evaluation_answer interview_evaluation_answer_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_answer
    ADD CONSTRAINT interview_evaluation_answer_pkey PRIMARY KEY (id);


--
-- Name: interview_evaluation interview_evaluation_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation
    ADD CONSTRAINT interview_evaluation_pkey PRIMARY KEY (id);


--
-- Name: interview_evaluation_question interview_evaluation_question_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_question
    ADD CONSTRAINT interview_evaluation_question_pkey PRIMARY KEY (id);


--
-- Name: interview_evaluation_section interview_evaluation_section_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_section
    ADD CONSTRAINT interview_evaluation_section_pkey PRIMARY KEY (id);


--
-- Name: interview interview_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview
    ADD CONSTRAINT interview_pkey PRIMARY KEY (id);


--
-- Name: interview_type interview_type_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_type
    ADD CONSTRAINT interview_type_pkey PRIMARY KEY (id);


--
-- Name: interviewee interviewee_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interviewee
    ADD CONSTRAINT interviewee_pkey PRIMARY KEY (id);


--
-- Name: interviewer interviewer_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interviewer
    ADD CONSTRAINT interviewer_pkey PRIMARY KEY (id);


--
-- Name: skill skill_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.skill
    ADD CONSTRAINT skill_pkey PRIMARY KEY (id);


--
-- Name: candidate_resource_type uked3on7pgjke7dg5y0or7njivt; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_resource_type
    ADD CONSTRAINT uked3on7pgjke7dg5y0or7njivt UNIQUE (code);


--
-- Name: interview_type ukth0vxw19f48biow3p3iikvt5r; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_type
    ADD CONSTRAINT ukth0vxw19f48biow3p3iikvt5r UNIQUE (code);


--
-- Name: vacancy vacancy_pkey; Type: CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.vacancy
    ADD CONSTRAINT vacancy_pkey PRIMARY KEY (id);


--
-- Name: resource resource_pkey; Type: CONSTRAINT; Schema: resource_schema; Owner: fractal
--

ALTER TABLE ONLY resource_schema.resource
    ADD CONSTRAINT resource_pkey PRIMARY KEY (id);


--
-- Name: entity_state entity_state_pkey; Type: CONSTRAINT; Schema: state_schema; Owner: fractal
--

ALTER TABLE ONLY state_schema.entity_state
    ADD CONSTRAINT entity_state_pkey PRIMARY KEY (id);


--
-- Name: environment_variable environment_variable_pkey; Type: CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.environment_variable
    ADD CONSTRAINT environment_variable_pkey PRIMARY KEY (id);


--
-- Name: message message_pkey; Type: CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.message
    ADD CONSTRAINT message_pkey PRIMARY KEY (id);


--
-- Name: message_type message_type_pkey; Type: CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.message_type
    ADD CONSTRAINT message_type_pkey PRIMARY KEY (id);


--
-- Name: notification notification_pkey; Type: CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.notification
    ADD CONSTRAINT notification_pkey PRIMARY KEY (id);


--
-- Name: notification_type notification_type_pkey; Type: CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.notification_type
    ADD CONSTRAINT notification_type_pkey PRIMARY KEY (id);


--
-- Name: service_provider service_provider_pkey; Type: CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.service_provider
    ADD CONSTRAINT service_provider_pkey PRIMARY KEY (id);


--
-- Name: service_provider_type service_provider_type_pkey; Type: CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.service_provider_type
    ADD CONSTRAINT service_provider_type_pkey PRIMARY KEY (id);


--
-- Name: notification_type uk7xy7aqj808cq628lqotsynoyx; Type: CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.notification_type
    ADD CONSTRAINT uk7xy7aqj808cq628lqotsynoyx UNIQUE (code);


--
-- Name: message ukf01yqjmocyfddiquvwskkaqh4; Type: CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.message
    ADD CONSTRAINT ukf01yqjmocyfddiquvwskkaqh4 UNIQUE (code);


--
-- Name: message_type uklkdrmpmq8pwcat2q77n97ul9e; Type: CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.message_type
    ADD CONSTRAINT uklkdrmpmq8pwcat2q77n97ul9e UNIQUE (code);


--
-- Name: service_provider_type ukm91w434gce8g8e532nb0sqbj5; Type: CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.service_provider_type
    ADD CONSTRAINT ukm91w434gce8g8e532nb0sqbj5 UNIQUE (code);


--
-- Name: selectedAnswer answer_pkey; Type: CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.selectedAnswer
    ADD CONSTRAINT answer_pkey PRIMARY KEY (id);


--
-- Name: answer_submission answer_submission_pkey; Type: CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.answer_submission
    ADD CONSTRAINT answer_submission_pkey PRIMARY KEY (id);


--
-- Name: question question_pkey; Type: CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id);


--
-- Name: question_type question_type_pkey; Type: CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.question_type
    ADD CONSTRAINT question_type_pkey PRIMARY KEY (id);


--
-- Name: selected_answer selected_answer_pkey; Type: CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.selected_answer
    ADD CONSTRAINT selected_answer_pkey PRIMARY KEY (id);


--
-- Name: test test_pkey; Type: CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);


--
-- Name: test_session test_session_pkey; Type: CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test_session
    ADD CONSTRAINT test_session_pkey PRIMARY KEY (id);


--
-- Name: question_type uk3oe9r9iajofacvmw5n198nb66; Type: CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.question_type
    ADD CONSTRAINT uk3oe9r9iajofacvmw5n198nb66 UNIQUE (code);


--
-- Name: attribute attribute_pkey; Type: CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.attribute
    ADD CONSTRAINT attribute_pkey PRIMARY KEY (id);


--
-- Name: component_attributes component_attributes_pkey; Type: CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.component_attributes
    ADD CONSTRAINT component_attributes_pkey PRIMARY KEY (id);


--
-- Name: component component_pkey; Type: CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.component
    ADD CONSTRAINT component_pkey PRIMARY KEY (id);


--
-- Name: attribute uk1774shfid1uaopl9tu8am19fq; Type: CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.attribute
    ADD CONSTRAINT uk1774shfid1uaopl9tu8am19fq UNIQUE (code);


--
-- Name: component uk24wq1y3l3mfjohvgtsewd3vo; Type: CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.component
    ADD CONSTRAINT uk24wq1y3l3mfjohvgtsewd3vo UNIQUE (code);


--
-- Name: authentication authentication_pkey; Type: CONSTRAINT; Schema: user_schema; Owner: fractal
--

ALTER TABLE ONLY user_schema.authentication
    ADD CONSTRAINT authentication_pkey PRIMARY KEY (id);


--
-- Name: profile profile_pkey; Type: CONSTRAINT; Schema: user_schema; Owner: fractal
--

ALTER TABLE ONLY user_schema.profile
    ADD CONSTRAINT profile_pkey PRIMARY KEY (id);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: user_schema; Owner: fractal
--

ALTER TABLE ONLY user_schema."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: work_schedule work_schedule_pkey; Type: CONSTRAINT; Schema: work_schedule_schema; Owner: fractal
--

ALTER TABLE ONLY work_schedule_schema.work_schedule
    ADD CONSTRAINT work_schedule_pkey PRIMARY KEY (id);


--
-- Name: role_menu fk1qnjbh7xgyidgxp4y91j54kfu; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.role_menu
    ADD CONSTRAINT fk1qnjbh7xgyidgxp4y91j54kfu FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: permission fk1vuuuiyorxgvlph2maf3slffu; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.permission
    ADD CONSTRAINT fk1vuuuiyorxgvlph2maf3slffu FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: permission fk5ibv5hxbhsssd0wf5i0ivfcel; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.permission
    ADD CONSTRAINT fk5ibv5hxbhsssd0wf5i0ivfcel FOREIGN KEY (confirmed_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: permission fk78dqnhvwivyqqvxk94cm9jknn; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.permission
    ADD CONSTRAINT fk78dqnhvwivyqqvxk94cm9jknn FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: user_role fk859n2jvi8ivhui0rl0esws6o; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.user_role
    ADD CONSTRAINT fk859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: permission fk8tesfd2mgbbhptupsmypnd0f0; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.permission
    ADD CONSTRAINT fk8tesfd2mgbbhptupsmypnd0f0 FOREIGN KEY (menu_action_id) REFERENCES navigation_schema.menu_action(id);


--
-- Name: user_role fka68196081fvovjhkek5m97n3y; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.user_role
    ADD CONSTRAINT fka68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES authorization_schema.role(id);


--
-- Name: role_menu fke89oo3eui9vm09ykl0hrp3m7x; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.role_menu
    ADD CONSTRAINT fke89oo3eui9vm09ykl0hrp3m7x FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: user_role fkeaal3twvgbxugcnyu3s80muwa; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.user_role
    ADD CONSTRAINT fkeaal3twvgbxugcnyu3s80muwa FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: role_menu fkfg4e2mb2318tph615gh44ll3; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.role_menu
    ADD CONSTRAINT fkfg4e2mb2318tph615gh44ll3 FOREIGN KEY (menu_id) REFERENCES navigation_schema.menu(id);


--
-- Name: permission fkgxp3gb1gugx0m59afu94q4vsk; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.permission
    ADD CONSTRAINT fkgxp3gb1gugx0m59afu94q4vsk FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: user fkhnncm3gx8plxt0kxg73vb9xdl; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema."user"
    ADD CONSTRAINT fkhnncm3gx8plxt0kxg73vb9xdl FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: user_role fki9a4o2ub6hnix7u6v954kq13e; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.user_role
    ADD CONSTRAINT fki9a4o2ub6hnix7u6v954kq13e FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: role fkl0e5mr26wklg19k284s3hl97x; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.role
    ADD CONSTRAINT fkl0e5mr26wklg19k284s3hl97x FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: role fkll733e2s14htp59p4u1xu6igt; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.role
    ADD CONSTRAINT fkll733e2s14htp59p4u1xu6igt FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: role_menu fkoyyb9fbrw8m2bg394b17thutk; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.role_menu
    ADD CONSTRAINT fkoyyb9fbrw8m2bg394b17thutk FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: user fkpm7nbf6vwm8j4iooot5u2l2im; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema."user"
    ADD CONSTRAINT fkpm7nbf6vwm8j4iooot5u2l2im FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: role_menu fkqyvxw2gg2qk0wld3bqfcb58vq; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.role_menu
    ADD CONSTRAINT fkqyvxw2gg2qk0wld3bqfcb58vq FOREIGN KEY (role_id) REFERENCES authorization_schema.role(id);


--
-- Name: permission fkrvhjnns4bvlh4m1n97vb7vbar; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.permission
    ADD CONSTRAINT fkrvhjnns4bvlh4m1n97vb7vbar FOREIGN KEY (role_id) REFERENCES authorization_schema.role(id);


--
-- Name: user_role fks4g23geu7g5v07nnvrnq67ona; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.user_role
    ADD CONSTRAINT fks4g23geu7g5v07nnvrnq67ona FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: role_menu fksqvftvysmktcjrny8eime8ieg; Type: FK CONSTRAINT; Schema: authorization_schema; Owner: fractal
--

ALTER TABLE ONLY authorization_schema.role_menu
    ADD CONSTRAINT fksqvftvysmktcjrny8eime8ieg FOREIGN KEY (confirmed_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: citizenship fkalap3rkkecpos5jlroxa9jdc5; Type: FK CONSTRAINT; Schema: citizenship_schema; Owner: fractal
--

ALTER TABLE ONLY citizenship_schema.citizenship
    ADD CONSTRAINT fkalap3rkkecpos5jlroxa9jdc5 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: citizenship fkeqfwa7oobdr2jhxkxjp2bcexl; Type: FK CONSTRAINT; Schema: citizenship_schema; Owner: fractal
--

ALTER TABLE ONLY citizenship_schema.citizenship
    ADD CONSTRAINT fkeqfwa7oobdr2jhxkxjp2bcexl FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: citizenship fkgboenhn57icfrd8w0pvwqngr6; Type: FK CONSTRAINT; Schema: citizenship_schema; Owner: fractal
--

ALTER TABLE ONLY citizenship_schema.citizenship
    ADD CONSTRAINT fkgboenhn57icfrd8w0pvwqngr6 FOREIGN KEY (country_id) REFERENCES location_schema.country(id);


--
-- Name: phone fk1lsao6buypghr60y1qr4hqccg; Type: FK CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.phone
    ADD CONSTRAINT fk1lsao6buypghr60y1qr4hqccg FOREIGN KEY (country_id) REFERENCES location_schema.country(id);


--
-- Name: contact_type fk4y3njac1f77eq0e8pawvi187i; Type: FK CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.contact_type
    ADD CONSTRAINT fk4y3njac1f77eq0e8pawvi187i FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: email fk58a0ae7aoxo72yhmornr36rch; Type: FK CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.email
    ADD CONSTRAINT fk58a0ae7aoxo72yhmornr36rch FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: phone fk5fonk3epkuq5y0lji2rxgoi46; Type: FK CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.phone
    ADD CONSTRAINT fk5fonk3epkuq5y0lji2rxgoi46 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: email fk5ut3utbreyxhc26aj3dbqwo6o; Type: FK CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.email
    ADD CONSTRAINT fk5ut3utbreyxhc26aj3dbqwo6o FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: contact fk6dfda2c1owl8p09s48oeqsevo; Type: FK CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.contact
    ADD CONSTRAINT fk6dfda2c1owl8p09s48oeqsevo FOREIGN KEY (contact_type_id) REFERENCES contact_schema.contact_type(id);


--
-- Name: phone fk7oeaickke8yowswp3jw0ttp1j; Type: FK CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.phone
    ADD CONSTRAINT fk7oeaickke8yowswp3jw0ttp1j FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: contact fkhle461hp79ep59427x8sy8mcv; Type: FK CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.contact
    ADD CONSTRAINT fkhle461hp79ep59427x8sy8mcv FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: contact fkq3txv43jn2phda1erhgna376; Type: FK CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.contact
    ADD CONSTRAINT fkq3txv43jn2phda1erhgna376 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: contact_type fkr37miqa9wwlta390e7y1g11qg; Type: FK CONSTRAINT; Schema: contact_schema; Owner: fractal
--

ALTER TABLE ONLY contact_schema.contact_type
    ADD CONSTRAINT fkr37miqa9wwlta390e7y1g11qg FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: currency fk17ygkjm2gdj1c9xwqc9ypqy00; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.currency
    ADD CONSTRAINT fk17ygkjm2gdj1c9xwqc9ypqy00 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: gender fk1tq6qdh89422se45pax0grn09; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.gender
    ADD CONSTRAINT fk1tq6qdh89422se45pax0grn09 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: notification_template fk39qy1mf664q9dw7ggc3vd0mtf; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.notification_template
    ADD CONSTRAINT fk39qy1mf664q9dw7ggc3vd0mtf FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: week_day fk3qjdeyq3j3xq7240wf2wwe7eg; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.week_day
    ADD CONSTRAINT fk3qjdeyq3j3xq7240wf2wwe7eg FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: marital_status fk40f9yjfi56ggrpk0awkdcl2hv; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.marital_status
    ADD CONSTRAINT fk40f9yjfi56ggrpk0awkdcl2hv FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: currency fk79etc6q9b2vootvpsqidchvpo; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.currency
    ADD CONSTRAINT fk79etc6q9b2vootvpsqidchvpo FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: boolean_type fk85qmg5hqxtwohdvp0osq80tja; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.boolean_type
    ADD CONSTRAINT fk85qmg5hqxtwohdvp0osq80tja FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: marital_status fk8gq2yeljves7bd5v1e1t0u1io; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.marital_status
    ADD CONSTRAINT fk8gq2yeljves7bd5v1e1t0u1io FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: boolean_type fk8kxc7gjq2al2161mi3j9vct1d; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.boolean_type
    ADD CONSTRAINT fk8kxc7gjq2al2161mi3j9vct1d FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: currency fka1xqilmjmlheudk4sayosgw35; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.currency
    ADD CONSTRAINT fka1xqilmjmlheudk4sayosgw35 FOREIGN KEY (country_id) REFERENCES location_schema.country(id);


--
-- Name: priority fkcw8i98r8l4dsndogbr48n8lt7; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.priority
    ADD CONSTRAINT fkcw8i98r8l4dsndogbr48n8lt7 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: nationality fkd62o8lro0tqmk3igphwcb9qe5; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.nationality
    ADD CONSTRAINT fkd62o8lro0tqmk3igphwcb9qe5 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: status fkd9qn37uaaw1ovkp6hqapathx4; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.status
    ADD CONSTRAINT fkd9qn37uaaw1ovkp6hqapathx4 FOREIGN KEY (status_category_id) REFERENCES dictionary_schema.status_category(id);


--
-- Name: notification_template fkdd8bgvdp58lrm9o9fg3umqtm; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.notification_template
    ADD CONSTRAINT fkdd8bgvdp58lrm9o9fg3umqtm FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: week_day fkdert1h6nrmbc9w53ovre07qkr; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.week_day
    ADD CONSTRAINT fkdert1h6nrmbc9w53ovre07qkr FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: status fkdfgxuugw1cosvegie2xvo9m80; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.status
    ADD CONSTRAINT fkdfgxuugw1cosvegie2xvo9m80 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: gender fkfbabbrlhfpcge0qak10pvkn3k; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.gender
    ADD CONSTRAINT fkfbabbrlhfpcge0qak10pvkn3k FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: profile_attribute fkjb1vvumo8kehaqu8wp1p7xkyq; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.profile_attribute
    ADD CONSTRAINT fkjb1vvumo8kehaqu8wp1p7xkyq FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: entity_type fkjhrfynx5cv2xgpuhjwdqw2epa; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.entity_type
    ADD CONSTRAINT fkjhrfynx5cv2xgpuhjwdqw2epa FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: nationality fkkkh3nipii8lshje7x9mtrvwos; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.nationality
    ADD CONSTRAINT fkkkh3nipii8lshje7x9mtrvwos FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: profile_attribute fkm33393swpyo2ch5c0jdp278x1; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.profile_attribute
    ADD CONSTRAINT fkm33393swpyo2ch5c0jdp278x1 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: entity_type fkn5e8fh3fmigodflmm3n67vwwd; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.entity_type
    ADD CONSTRAINT fkn5e8fh3fmigodflmm3n67vwwd FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: status_category fknrjn4nrgn32pyui38e7iv0e4b; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.status_category
    ADD CONSTRAINT fknrjn4nrgn32pyui38e7iv0e4b FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: color fkon8d69le0cfp0uc95pfihqokr; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.color
    ADD CONSTRAINT fkon8d69le0cfp0uc95pfihqokr FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: status fkrcjlv19qxa2fv7d5gfhu56d74; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.status
    ADD CONSTRAINT fkrcjlv19qxa2fv7d5gfhu56d74 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: color fkri4odaxpfogqs7e6gqxgdb84; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.color
    ADD CONSTRAINT fkri4odaxpfogqs7e6gqxgdb84 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: status_category fkt5mnpkn0rsetqfv1eke2n5780; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.status_category
    ADD CONSTRAINT fkt5mnpkn0rsetqfv1eke2n5780 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: priority fkun6j2rgytvacmats39hieqwh; Type: FK CONSTRAINT; Schema: dictionary_schema; Owner: fractal
--

ALTER TABLE ONLY dictionary_schema.priority
    ADD CONSTRAINT fkun6j2rgytvacmats39hieqwh FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: education_type fk1i41pramnkarrbgnvju7v1tli; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education_type
    ADD CONSTRAINT fk1i41pramnkarrbgnvju7v1tli FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: education fk23y37u75qregx6obc8y907b87; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education
    ADD CONSTRAINT fk23y37u75qregx6obc8y907b87 FOREIGN KEY (education_document_type_id) REFERENCES education_schema.education_document_type(id);


--
-- Name: education fk2xt0s5mcujs2n7n7ipxo1ho07; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education
    ADD CONSTRAINT fk2xt0s5mcujs2n7n7ipxo1ho07 FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: education_resource fk3ioofgha55f9qsxf665fl76hv; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education_resource
    ADD CONSTRAINT fk3ioofgha55f9qsxf665fl76hv FOREIGN KEY (id) REFERENCES resource_schema.resource(id);


--
-- Name: accreditation_status fk53gqywq4nuwrnrcck11wv6b44; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.accreditation_status
    ADD CONSTRAINT fk53gqywq4nuwrnrcck11wv6b44 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: education fk8dpbwqpg0jd8gnmr94is1gbsb; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education
    ADD CONSTRAINT fk8dpbwqpg0jd8gnmr94is1gbsb FOREIGN KEY (accreditation_status_id) REFERENCES education_schema.accreditation_status(id);


--
-- Name: degree_type fk8ifhh9tkb0hpqhn2y65uuxpav; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.degree_type
    ADD CONSTRAINT fk8ifhh9tkb0hpqhn2y65uuxpav FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: grade_point_average fkb830fjxi2tf4antgy2r970pyy; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.grade_point_average
    ADD CONSTRAINT fkb830fjxi2tf4antgy2r970pyy FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: accreditation_status fkbrwbgditk56ui01dh4p61h6kh; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.accreditation_status
    ADD CONSTRAINT fkbrwbgditk56ui01dh4p61h6kh FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: education_resource fkc26yy5lxdhi5qmv777e2mpt6x; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education_resource
    ADD CONSTRAINT fkc26yy5lxdhi5qmv777e2mpt6x FOREIGN KEY (education_id) REFERENCES education_schema.education(id);


--
-- Name: education_document_type fkdqv0twdc3y2y68k8boarvdnn2; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education_document_type
    ADD CONSTRAINT fkdqv0twdc3y2y68k8boarvdnn2 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: education fkfkb4mxbsjpn17dykxmuoy1n9m; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education
    ADD CONSTRAINT fkfkb4mxbsjpn17dykxmuoy1n9m FOREIGN KEY (grade_point_average_id) REFERENCES education_schema.grade_point_average(id);


--
-- Name: education fkhkops45a1klf1mnpvg6rsdbxv; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education
    ADD CONSTRAINT fkhkops45a1klf1mnpvg6rsdbxv FOREIGN KEY (degree_type_id) REFERENCES education_schema.degree_type(id);


--
-- Name: grade_point_average fkibb94svl1rnxnrk5ta2pb11tc; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.grade_point_average
    ADD CONSTRAINT fkibb94svl1rnxnrk5ta2pb11tc FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: education fkid3099i5vcjl46o5m8mtea452; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education
    ADD CONSTRAINT fkid3099i5vcjl46o5m8mtea452 FOREIGN KEY (education_type_id) REFERENCES education_schema.education_type(id);


--
-- Name: education fkkhui07xo70funlw7srna0pph8; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education
    ADD CONSTRAINT fkkhui07xo70funlw7srna0pph8 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: education_type fkktgwip7bg4ly8sbwpelhg2ld3; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education_type
    ADD CONSTRAINT fkktgwip7bg4ly8sbwpelhg2ld3 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: education_document_type fko6r7h9nihgo3t0t1iccw0larx; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education_document_type
    ADD CONSTRAINT fko6r7h9nihgo3t0t1iccw0larx FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: degree_type fko83b04gpv0ncm0qn8by8g0sne; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.degree_type
    ADD CONSTRAINT fko83b04gpv0ncm0qn8by8g0sne FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: education fktohgygeab9v53147sbpg4cpdf; Type: FK CONSTRAINT; Schema: education_schema; Owner: fractal
--

ALTER TABLE ONLY education_schema.education
    ADD CONSTRAINT fktohgygeab9v53147sbpg4cpdf FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: business_trip fk123bn3famxxbqdrfm8to1eea4; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip
    ADD CONSTRAINT fk123bn3famxxbqdrfm8to1eea4 FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: business_trip fk13jgxiwa0x6a3gs90s2xeh5t3; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip
    ADD CONSTRAINT fk13jgxiwa0x6a3gs90s2xeh5t3 FOREIGN KEY (business_trip_type_id) REFERENCES employee_schema.business_trip_type(id);


--
-- Name: relative fk1i86k4h1124ajyihe83h20krc; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative
    ADD CONSTRAINT fk1i86k4h1124ajyihe83h20krc FOREIGN KEY (nationality_id) REFERENCES dictionary_schema.nationality(id);


--
-- Name: vacation fk1phnxx2yrergmehyviq52iiqq; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation
    ADD CONSTRAINT fk1phnxx2yrergmehyviq52iiqq FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: relative fk1ud9mei70evlnh6s7cqfkuqgw; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative
    ADD CONSTRAINT fk1ud9mei70evlnh6s7cqfkuqgw FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: relation_type fk27ug1n3sb8mr36rwx5btrtemv; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relation_type
    ADD CONSTRAINT fk27ug1n3sb8mr36rwx5btrtemv FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: employee fk299yew76o3gb0qx594rwi1rc8; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee
    ADD CONSTRAINT fk299yew76o3gb0qx594rwi1rc8 FOREIGN KEY (nationality_id) REFERENCES dictionary_schema.nationality(id);


--
-- Name: employee_contact fk2awbwh5itj2xs1bdr6oqt5kyl; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_contact
    ADD CONSTRAINT fk2awbwh5itj2xs1bdr6oqt5kyl FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: performance fk2e06qs6sbg17u12lqpf9o5ldv; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance
    ADD CONSTRAINT fk2e06qs6sbg17u12lqpf9o5ldv FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: improvement_area fk2j8nqlxl83c3p3eksw6tv5r58; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.improvement_area
    ADD CONSTRAINT fk2j8nqlxl83c3p3eksw6tv5r58 FOREIGN KEY (performance_id) REFERENCES employee_schema.performance(id);


--
-- Name: employment_history fk2jv1yu1f45j41s84odme64hdw; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employment_history
    ADD CONSTRAINT fk2jv1yu1f45j41s84odme64hdw FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: order_type fk2kf472n7qg5sdab8db5bs1qgu; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.order_type
    ADD CONSTRAINT fk2kf472n7qg5sdab8db5bs1qgu FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: employment_history fk2tpohs3mesy01gs25knyn6pwc; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employment_history
    ADD CONSTRAINT fk2tpohs3mesy01gs25knyn6pwc FOREIGN KEY (employment_type_id) REFERENCES employment_schema.employment_type(id);


--
-- Name: employee fk2wajl4v68k4qkwn7jehv3pnkx; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee
    ADD CONSTRAINT fk2wajl4v68k4qkwn7jehv3pnkx FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: business_trip fk3edawsglpqcg4mrfsafbkrr0c; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip
    ADD CONSTRAINT fk3edawsglpqcg4mrfsafbkrr0c FOREIGN KEY (approved_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: identification_document_resource fk3ly2q9a2n9xhwen9ncy517egr; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.identification_document_resource
    ADD CONSTRAINT fk3ly2q9a2n9xhwen9ncy517egr FOREIGN KEY (id) REFERENCES resource_schema.resource(id);


--
-- Name: relative fk47x6bpxatr3vgq25e8k8lvhrm; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative
    ADD CONSTRAINT fk47x6bpxatr3vgq25e8k8lvhrm FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: business_trip_order fk49qwfrux7u1wky6u1jjisyihb; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip_order
    ADD CONSTRAINT fk49qwfrux7u1wky6u1jjisyihb FOREIGN KEY (business_trip_id) REFERENCES employee_schema.business_trip(id);


--
-- Name: employee_citizenship fk4eoimi5t12nl2wlen7pe5u6jf; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_citizenship
    ADD CONSTRAINT fk4eoimi5t12nl2wlen7pe5u6jf FOREIGN KEY (id) REFERENCES citizenship_schema.citizenship(id);


--
-- Name: agreement_resource fk4jygosnp0b318rmclfieoq99x; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.agreement_resource
    ADD CONSTRAINT fk4jygosnp0b318rmclfieoq99x FOREIGN KEY (agreement_id) REFERENCES employee_schema.agreement(id);


--
-- Name: business_trip_resource fk4mnbrgl7u6cdksmh1c7cc5f6n; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip_resource
    ADD CONSTRAINT fk4mnbrgl7u6cdksmh1c7cc5f6n FOREIGN KEY (business_trip_id) REFERENCES employee_schema.business_trip(id);


--
-- Name: employee_identification_document fk58xiaqqm5d9v8h75efregooaw; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_identification_document
    ADD CONSTRAINT fk58xiaqqm5d9v8h75efregooaw FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: employee_citizenship fk5akmxr1o0nnuqtt169m7runrs; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_citizenship
    ADD CONSTRAINT fk5akmxr1o0nnuqtt169m7runrs FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: performance fk5at4q39xcv7b6tev61o9kcyut; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance
    ADD CONSTRAINT fk5at4q39xcv7b6tev61o9kcyut FOREIGN KEY (performance_type_id) REFERENCES employee_schema.performance_type(id);


--
-- Name: employee_contact fk5vnwbjaww7r4qftg55t0pnfa5; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_contact
    ADD CONSTRAINT fk5vnwbjaww7r4qftg55t0pnfa5 FOREIGN KEY (id) REFERENCES contact_schema.contact(id);


--
-- Name: order fk642l9mxkwhc8pltov3k06y5au; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema."order"
    ADD CONSTRAINT fk642l9mxkwhc8pltov3k06y5au FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: vacation_type fk6h4avme6cpaqypjrpfxobl24y; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation_type
    ADD CONSTRAINT fk6h4avme6cpaqypjrpfxobl24y FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: attendance fk6l2b048vktg11ycytv7qyfpby; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.attendance
    ADD CONSTRAINT fk6l2b048vktg11ycytv7qyfpby FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: performance fk6nbo3lsulmff7qvtartnl3ssy; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance
    ADD CONSTRAINT fk6nbo3lsulmff7qvtartnl3ssy FOREIGN KEY (reviewer_employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: employee_education fk6pm2cgawncfp6nw1ngw484wh4; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_education
    ADD CONSTRAINT fk6pm2cgawncfp6nw1ngw484wh4 FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: relative fk6pm6hmv15mp2i38xni03jjvdi; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative
    ADD CONSTRAINT fk6pm6hmv15mp2i38xni03jjvdi FOREIGN KEY (nationality_id) REFERENCES employee_schema.category(id);


--
-- Name: vacation fk6qrwq18c5kq468gvsmwm43cgp; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation
    ADD CONSTRAINT fk6qrwq18c5kq468gvsmwm43cgp FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: relative_address fk6yh8u2v7vu7u121of3sl6wg7t; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative_address
    ADD CONSTRAINT fk6yh8u2v7vu7u121of3sl6wg7t FOREIGN KEY (id) REFERENCES location_schema.address(id);


--
-- Name: order_resource fk73im11unqpmftex7i9xpjb5r5; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.order_resource
    ADD CONSTRAINT fk73im11unqpmftex7i9xpjb5r5 FOREIGN KEY (id) REFERENCES resource_schema.resource(id);


--
-- Name: employee_military_service fk7d5xig2y407ro3rt2gyoaev71; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_military_service
    ADD CONSTRAINT fk7d5xig2y407ro3rt2gyoaev71 FOREIGN KEY (id) REFERENCES military_schema.military_service(id);


--
-- Name: business_trip fk7q30ttgy35bri0luh16buap0x; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip
    ADD CONSTRAINT fk7q30ttgy35bri0luh16buap0x FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: agreement fk7t04a71205tk67nr8wle31yie; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.agreement
    ADD CONSTRAINT fk7t04a71205tk67nr8wle31yie FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: agreement fk7uujhe6vgm7ecsxfpfk4458et; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.agreement
    ADD CONSTRAINT fk7uujhe6vgm7ecsxfpfk4458et FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: employment_history fk7w85uihvou06y0cfh2tp7el6f; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employment_history
    ADD CONSTRAINT fk7w85uihvou06y0cfh2tp7el6f FOREIGN KEY (employment_type_id) REFERENCES employee_schema.category(id);


--
-- Name: performance fk80mkybbq6la2cys18jw7civ9v; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance
    ADD CONSTRAINT fk80mkybbq6la2cys18jw7civ9v FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: employment_history fk82jjwu4lybe98hl25tea0xer2; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employment_history
    ADD CONSTRAINT fk82jjwu4lybe98hl25tea0xer2 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: military_data fk8734ijjopberd1bpac1fikxwm; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.military_data
    ADD CONSTRAINT fk8734ijjopberd1bpac1fikxwm FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: degree_type fk8ifhh9tkb0hpqhn2y65uuxpav; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.degree_type
    ADD CONSTRAINT fk8ifhh9tkb0hpqhn2y65uuxpav FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: business_trip_type fk8rm730p0l1men89bhjqis9b8l; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip_type
    ADD CONSTRAINT fk8rm730p0l1men89bhjqis9b8l FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: performance fk8sam0gkv7e7nxo6xpnrcpjulc; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance
    ADD CONSTRAINT fk8sam0gkv7e7nxo6xpnrcpjulc FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: performance_type fk9k12kjjv31u786199080jycaq; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance_type
    ADD CONSTRAINT fk9k12kjjv31u786199080jycaq FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: employment_history fk9k4h43a85ahbrlpsyy0g6fj3l; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employment_history
    ADD CONSTRAINT fk9k4h43a85ahbrlpsyy0g6fj3l FOREIGN KEY (department_id) REFERENCES organization_schema.separationReason(id);


--
-- Name: vacation fk9qgqto1d9es54f009w5jo2qy; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation
    ADD CONSTRAINT fk9qgqto1d9es54f009w5jo2qy FOREIGN KEY (vacation_category_id) REFERENCES employee_schema.vacation_category(id);


--
-- Name: employment_history fk9t1s402yqjh2akjoyaeppj4cn; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employment_history
    ADD CONSTRAINT fk9t1s402yqjh2akjoyaeppj4cn FOREIGN KEY (organization_id) REFERENCES organization_schema.organization(id);


--
-- Name: subordinate fk9v5235xa0ydb8qu46775ajgw1; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.subordinate
    ADD CONSTRAINT fk9v5235xa0ydb8qu46775ajgw1 FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: employment_history fk9yde3w9jegikaprc73mlxcp8b; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employment_history
    ADD CONSTRAINT fk9yde3w9jegikaprc73mlxcp8b FOREIGN KEY (position_id) REFERENCES organization_schema."position"(id);


--
-- Name: order fka4uqahqcjwjxsk4ucxcn9oy99; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema."order"
    ADD CONSTRAINT fka4uqahqcjwjxsk4ucxcn9oy99 FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: performance_type fka5u1m88nu9yn6ma9siht9q2nk; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance_type
    ADD CONSTRAINT fka5u1m88nu9yn6ma9siht9q2nk FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: employee_resource fkaht6n9u5gar7haopj06i6flcv; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_resource
    ADD CONSTRAINT fkaht6n9u5gar7haopj06i6flcv FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: citizenship fkalap3rkkecpos5jlroxa9jdc5; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.citizenship
    ADD CONSTRAINT fkalap3rkkecpos5jlroxa9jdc5 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: absence_type fkb2t7j25knuv2qrawawgt508u5; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.absence_type
    ADD CONSTRAINT fkb2t7j25knuv2qrawawgt508u5 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: performance_goal fkb6t5f1vopjrquatvc59so1ksg; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance_goal
    ADD CONSTRAINT fkb6t5f1vopjrquatvc59so1ksg FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: subordinate_type fkbdiwayhfo3i0jrm9mdw2i08nf; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.subordinate_type
    ADD CONSTRAINT fkbdiwayhfo3i0jrm9mdw2i08nf FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: business_trip_type fkbf5an2bf8o2vk0f15n478ldep; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip_type
    ADD CONSTRAINT fkbf5an2bf8o2vk0f15n478ldep FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: order fkbjsajhuskpaln1n6mneqkqdu6; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema."order"
    ADD CONSTRAINT fkbjsajhuskpaln1n6mneqkqdu6 FOREIGN KEY (approved_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: military_data fkbwt7r1y7wo8w0pp6bxdoroqly; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.military_data
    ADD CONSTRAINT fkbwt7r1y7wo8w0pp6bxdoroqly FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: performance fkbxpydkcbdllta1uuowe3nq5iq; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance
    ADD CONSTRAINT fkbxpydkcbdllta1uuowe3nq5iq FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: subordinate fkc6qd0g5vf9p6lyyus3hw9yjc9; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.subordinate
    ADD CONSTRAINT fkc6qd0g5vf9p6lyyus3hw9yjc9 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: military_service_resource fkcjiubvp9d0qqqsk6fbw5x58db; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.military_service_resource
    ADD CONSTRAINT fkcjiubvp9d0qqqsk6fbw5x58db FOREIGN KEY (id) REFERENCES resource_schema.resource(id);


--
-- Name: business_trip fkcu3kttivfstkixbjv6jd85xh5; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip
    ADD CONSTRAINT fkcu3kttivfstkixbjv6jd85xh5 FOREIGN KEY (organization_id) REFERENCES organization_schema.organization(id);


--
-- Name: relative fkd2pdicn1g3bax7goxg7k6uldy; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative
    ADD CONSTRAINT fkd2pdicn1g3bax7goxg7k6uldy FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: relative_contact fkd3264n659hs7f2s7907rgbtv6; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative_contact
    ADD CONSTRAINT fkd3264n659hs7f2s7907rgbtv6 FOREIGN KEY (relative_id) REFERENCES employee_schema.relative(id);


--
-- Name: employee fkd4dvhrigl3oiod8nxp7hcdn3e; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee
    ADD CONSTRAINT fkd4dvhrigl3oiod8nxp7hcdn3e FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: absence fkddc6udkd4p67vplctc4qu37aa; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.absence
    ADD CONSTRAINT fkddc6udkd4p67vplctc4qu37aa FOREIGN KEY (absence_type_id) REFERENCES employee_schema.absence_type(id);


--
-- Name: order fkdm67dvre5lusgwkfemvmdmrr5; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema."order"
    ADD CONSTRAINT fkdm67dvre5lusgwkfemvmdmrr5 FOREIGN KEY (order_type_id) REFERENCES employee_schema.order_type(id);


--
-- Name: subordinate fke0hy3yc89oagsd6rb1m586luc; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.subordinate
    ADD CONSTRAINT fke0hy3yc89oagsd6rb1m586luc FOREIGN KEY (subordinate_employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: employee fke0w26qjedr99vwno4pqauw9i9; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee
    ADD CONSTRAINT fke0w26qjedr99vwno4pqauw9i9 FOREIGN KEY (gender_id) REFERENCES dictionary_schema.gender(id);


--
-- Name: employee_work_experience fke6lnhnup1ian68ra9lwmmvhsb; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_work_experience
    ADD CONSTRAINT fke6lnhnup1ian68ra9lwmmvhsb FOREIGN KEY (id) REFERENCES employment_schema.work_experience(id);


--
-- Name: employment_history fkeb8naot9e7psahmroikw8to9w; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employment_history
    ADD CONSTRAINT fkeb8naot9e7psahmroikw8to9w FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: military_data fkeejbqg3i5qxc7sn0u91s9xk5b; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.military_data
    ADD CONSTRAINT fkeejbqg3i5qxc7sn0u91s9xk5b FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: vacation_type fkefeebk0f9pklbbmmgkiilh968; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation_type
    ADD CONSTRAINT fkefeebk0f9pklbbmmgkiilh968 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: citizenship fkeqfwa7oobdr2jhxkxjp2bcexl; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.citizenship
    ADD CONSTRAINT fkeqfwa7oobdr2jhxkxjp2bcexl FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: employee fkf5rstedundygjfga5oke6vdy9; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee
    ADD CONSTRAINT fkf5rstedundygjfga5oke6vdy9 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: order_resource fkfdlsao7pbf7x7302bi7tyni5c; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.order_resource
    ADD CONSTRAINT fkfdlsao7pbf7x7302bi7tyni5c FOREIGN KEY (order_id) REFERENCES employee_schema."order"(id);


--
-- Name: category fkfifh1ya961x6bkfm1jcbhhwov; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.category
    ADD CONSTRAINT fkfifh1ya961x6bkfm1jcbhhwov FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: agreement fkfn0s7iuoe8tyvl9ds15sgeiwl; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.agreement
    ADD CONSTRAINT fkfn0s7iuoe8tyvl9ds15sgeiwl FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: employee_education fkfyb4ar5ff1h3j48qw18o11nn3; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_education
    ADD CONSTRAINT fkfyb4ar5ff1h3j48qw18o11nn3 FOREIGN KEY (id) REFERENCES education_schema.education(id);


--
-- Name: citizenship fkgboenhn57icfrd8w0pvwqngr6; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.citizenship
    ADD CONSTRAINT fkgboenhn57icfrd8w0pvwqngr6 FOREIGN KEY (country_id) REFERENCES location_schema.country(id);


--
-- Name: business_trip fkhe5liylefhedjyumib1q1pw7v; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip
    ADD CONSTRAINT fkhe5liylefhedjyumib1q1pw7v FOREIGN KEY (reviewed_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: employee_identification_document fkhnj043913cxj3mso5bfktqvmn; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_identification_document
    ADD CONSTRAINT fkhnj043913cxj3mso5bfktqvmn FOREIGN KEY (id) REFERENCES identification_schema.identification_document(id);


--
-- Name: category fkhoptdt843qsievuv3m63nyoa3; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.category
    ADD CONSTRAINT fkhoptdt843qsievuv3m63nyoa3 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: absence fkhpf918yxqjiy72ss2wng04ysb; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.absence
    ADD CONSTRAINT fkhpf918yxqjiy72ss2wng04ysb FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: attendance fki2ayggb7whphts7lo9s5hiabw; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.attendance
    ADD CONSTRAINT fki2ayggb7whphts7lo9s5hiabw FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: employment_history_order fki2pddq135usjdi5uoql51wa5l; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employment_history_order
    ADD CONSTRAINT fki2pddq135usjdi5uoql51wa5l FOREIGN KEY (id) REFERENCES employee_schema."order"(id);


--
-- Name: relative fkis2bmbjevbyykx3r3kwqennmo; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative
    ADD CONSTRAINT fkis2bmbjevbyykx3r3kwqennmo FOREIGN KEY (gender_id) REFERENCES dictionary_schema.gender(id);


--
-- Name: employee fkivtkrlfso4toqek7i2rul2ggy; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee
    ADD CONSTRAINT fkivtkrlfso4toqek7i2rul2ggy FOREIGN KEY (country_id) REFERENCES location_schema.country(id);


--
-- Name: subordinate fkiwl048p6d831ib9mu4s1tv3a6; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.subordinate
    ADD CONSTRAINT fkiwl048p6d831ib9mu4s1tv3a6 FOREIGN KEY (subordinate_type_id) REFERENCES employee_schema.subordinate_type(id);


--
-- Name: employee_resource fkjrythd5uaxcawronsqk1u8wql; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_resource
    ADD CONSTRAINT fkjrythd5uaxcawronsqk1u8wql FOREIGN KEY (id) REFERENCES resource_schema.resource(id);


--
-- Name: agreement fkkah6fs7sm3547pw8vsihgsr5o; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.agreement
    ADD CONSTRAINT fkkah6fs7sm3547pw8vsihgsr5o FOREIGN KEY (employment_history_id) REFERENCES employee_schema.employment_history(id);


--
-- Name: business_trip fkkb7gn0shpi8cr4k4hhdpgngbo; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip
    ADD CONSTRAINT fkkb7gn0shpi8cr4k4hhdpgngbo FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: vacation fkkbc6gbjn8cvjljc7bqlb6s042; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation
    ADD CONSTRAINT fkkbc6gbjn8cvjljc7bqlb6s042 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: relative fkke9n2cjsijuq4elpdq19syekl; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative
    ADD CONSTRAINT fkke9n2cjsijuq4elpdq19syekl FOREIGN KEY (relation_type_id) REFERENCES employee_schema.relation_type(id);


--
-- Name: employment_history_order fkkmwklwj0peywxitgk3uacxiu7; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employment_history_order
    ADD CONSTRAINT fkkmwklwj0peywxitgk3uacxiu7 FOREIGN KEY (employment_history_id) REFERENCES employee_schema.employment_history(id);


--
-- Name: vacation fkkoxdr5wib25f1wnu3s0ugbrgi; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation
    ADD CONSTRAINT fkkoxdr5wib25f1wnu3s0ugbrgi FOREIGN KEY (successor_employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: vacation fkktu32o290aypm00okdefy3dve; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation
    ADD CONSTRAINT fkktu32o290aypm00okdefy3dve FOREIGN KEY (vacation_type_id) REFERENCES employee_schema.vacation_type(id);


--
-- Name: performance_goal fkkxiqdb0rvrr4jnk6gykevlv46; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance_goal
    ADD CONSTRAINT fkkxiqdb0rvrr4jnk6gykevlv46 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: employee fklbe0535e0glnmfvhnucoa0deo; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee
    ADD CONSTRAINT fklbe0535e0glnmfvhnucoa0deo FOREIGN KEY (nationality_id) REFERENCES employee_schema.category(id);


--
-- Name: business_trip_order fkli0rm77kwgrwtntmrcano18ac; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip_order
    ADD CONSTRAINT fkli0rm77kwgrwtntmrcano18ac FOREIGN KEY (id) REFERENCES employee_schema."order"(id);


--
-- Name: agreement_resource fkllw3a5ojo4tdx1fy9nyc6a9u2; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.agreement_resource
    ADD CONSTRAINT fkllw3a5ojo4tdx1fy9nyc6a9u2 FOREIGN KEY (id) REFERENCES resource_schema.resource(id);


--
-- Name: subordinate fkmeqwlhltnv1awlfqp9wnou4q9; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.subordinate
    ADD CONSTRAINT fkmeqwlhltnv1awlfqp9wnou4q9 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: vacation_category fkmu4bcn9yk2ja1j6ojrxiwq5wf; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation_category
    ADD CONSTRAINT fkmu4bcn9yk2ja1j6ojrxiwq5wf FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: employment_history fkn4feh5ao76dqek4igc8embfjq; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employment_history
    ADD CONSTRAINT fkn4feh5ao76dqek4igc8embfjq FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: subordinate_type fknap7kqqqimw066gjfpotw3wil; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.subordinate_type
    ADD CONSTRAINT fknap7kqqqimw066gjfpotw3wil FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: identification_document_resource fknege5cbi5n8p5hrl4cd4kqw9i; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.identification_document_resource
    ADD CONSTRAINT fknege5cbi5n8p5hrl4cd4kqw9i FOREIGN KEY (identification_document_id) REFERENCES identification_schema.identification_document(id);


--
-- Name: subordinate fknh3ry00hstxxyokog99setjy8; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.subordinate
    ADD CONSTRAINT fknh3ry00hstxxyokog99setjy8 FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: improvement_area fknj775t885aqjq6828k9bixafe; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.improvement_area
    ADD CONSTRAINT fknj775t885aqjq6828k9bixafe FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: order_type fko231erfwetim3hygvwbn7p0nc; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.order_type
    ADD CONSTRAINT fko231erfwetim3hygvwbn7p0nc FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: degree_type fko83b04gpv0ncm0qn8by8g0sne; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.degree_type
    ADD CONSTRAINT fko83b04gpv0ncm0qn8by8g0sne FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: business_trip_resource fkoxyxgoyedwpyba0kkwv1im47w; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip_resource
    ADD CONSTRAINT fkoxyxgoyedwpyba0kkwv1im47w FOREIGN KEY (id) REFERENCES resource_schema.resource(id);


--
-- Name: relation_type fkph1kv7nx564arww8ewtv4phyg; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relation_type
    ADD CONSTRAINT fkph1kv7nx564arww8ewtv4phyg FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: attendance fkpnkxqq4luu1ayfdc72oeln9n0; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.attendance
    ADD CONSTRAINT fkpnkxqq4luu1ayfdc72oeln9n0 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: employee_work_experience fkpxaxef3g2rf9usfo164jdu8a7; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_work_experience
    ADD CONSTRAINT fkpxaxef3g2rf9usfo164jdu8a7 FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: military_service_resource fkpyb9svn2brm74lb2pk4lfuyv1; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.military_service_resource
    ADD CONSTRAINT fkpyb9svn2brm74lb2pk4lfuyv1 FOREIGN KEY (military_service_id) REFERENCES employee_schema.military_data(id);


--
-- Name: employee fkq03a9kqm5viib1a6r8rrvvoro; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee
    ADD CONSTRAINT fkq03a9kqm5viib1a6r8rrvvoro FOREIGN KEY (marital_status_id) REFERENCES dictionary_schema.marital_status(id);


--
-- Name: employee_address fkq100ul0qo7nuxdcbn7adypnyo; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_address
    ADD CONSTRAINT fkq100ul0qo7nuxdcbn7adypnyo FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: employee_military_service fkqnxmgrkp99418rhmu57oegqbk; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_military_service
    ADD CONSTRAINT fkqnxmgrkp99418rhmu57oegqbk FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: absence_type fkqprvpmhxvgda3pcrckm894w40; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.absence_type
    ADD CONSTRAINT fkqprvpmhxvgda3pcrckm894w40 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: vacation_category fkqq06p1cb4qbltmh9m4pdvs6jw; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation_category
    ADD CONSTRAINT fkqq06p1cb4qbltmh9m4pdvs6jw FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: employee fkqypxqtmngvkus1we3l8ae42ua; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee
    ADD CONSTRAINT fkqypxqtmngvkus1we3l8ae42ua FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: performance_goal fkr221pp58hhukybw4vpu1ptqey; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.performance_goal
    ADD CONSTRAINT fkr221pp58hhukybw4vpu1ptqey FOREIGN KEY (performance_id) REFERENCES employee_schema.performance(id);


--
-- Name: employee_address fkr4kbfcxh6balyjk6rldqg6nxc; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.employee_address
    ADD CONSTRAINT fkr4kbfcxh6balyjk6rldqg6nxc FOREIGN KEY (id) REFERENCES location_schema.address(id);


--
-- Name: order fkr5f1ndp5f1p4uhf3auwtg8661; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema."order"
    ADD CONSTRAINT fkr5f1ndp5f1p4uhf3auwtg8661 FOREIGN KEY (reviewed_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: attendance fkr7q0h8jfngkyybll6o9r3h9ua; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.attendance
    ADD CONSTRAINT fkr7q0h8jfngkyybll6o9r3h9ua FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: relative_contact fkraf65bt5n4pfvl8m0tl93yybp; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative_contact
    ADD CONSTRAINT fkraf65bt5n4pfvl8m0tl93yybp FOREIGN KEY (id) REFERENCES contact_schema.contact(id);


--
-- Name: business_trip fkrkc8arf37fve513pswgx90fbs; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.business_trip
    ADD CONSTRAINT fkrkc8arf37fve513pswgx90fbs FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: vacation fkrnc387fqpngthsvkbdqijdhtw; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.vacation
    ADD CONSTRAINT fkrnc387fqpngthsvkbdqijdhtw FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: absence fks69fc883x11wl5lkx9vjhf5ym; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.absence
    ADD CONSTRAINT fks69fc883x11wl5lkx9vjhf5ym FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: improvement_area fksaug9hol96j1l6su4efmch5j7; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.improvement_area
    ADD CONSTRAINT fksaug9hol96j1l6su4efmch5j7 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: relative fksfqj4j7u03tdufpj8runaihfc; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative
    ADD CONSTRAINT fksfqj4j7u03tdufpj8runaihfc FOREIGN KEY (marital_status_id) REFERENCES dictionary_schema.marital_status(id);


--
-- Name: improvement_area fkt5x9oc6sf6c2e1yywfc1odv68; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.improvement_area
    ADD CONSTRAINT fkt5x9oc6sf6c2e1yywfc1odv68 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: relative_address fktcgpo1j7lqjinbvnfc78rn8g; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.relative_address
    ADD CONSTRAINT fktcgpo1j7lqjinbvnfc78rn8g FOREIGN KEY (relative_id) REFERENCES employee_schema.relative(id);


--
-- Name: absence fktqui27l7rrtdt6d01rg3hxd1p; Type: FK CONSTRAINT; Schema: employee_schema; Owner: fractal
--

ALTER TABLE ONLY employee_schema.absence
    ADD CONSTRAINT fktqui27l7rrtdt6d01rg3hxd1p FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: employment_type fk90po97a46ctgfsogwdwicsykx; Type: FK CONSTRAINT; Schema: employment_schema; Owner: fractal
--

ALTER TABLE ONLY employment_schema.employment_type
    ADD CONSTRAINT fk90po97a46ctgfsogwdwicsykx FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: employment_type fkch68osg8ok4gelsutxaa9hdbk; Type: FK CONSTRAINT; Schema: employment_schema; Owner: fractal
--

ALTER TABLE ONLY employment_schema.employment_type
    ADD CONSTRAINT fkch68osg8ok4gelsutxaa9hdbk FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: work_experience fkdgrimu1wdrq6mwvq1pcis0tk4; Type: FK CONSTRAINT; Schema: employment_schema; Owner: fractal
--

ALTER TABLE ONLY employment_schema.work_experience
    ADD CONSTRAINT fkdgrimu1wdrq6mwvq1pcis0tk4 FOREIGN KEY (country_id) REFERENCES location_schema.country(id);


--
-- Name: work_experience fkguruas5qmx56ws1u6np10pao1; Type: FK CONSTRAINT; Schema: employment_schema; Owner: fractal
--

ALTER TABLE ONLY employment_schema.work_experience
    ADD CONSTRAINT fkguruas5qmx56ws1u6np10pao1 FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: work_experience fkjp8qgildg69x3vyoy2jtg1xlj; Type: FK CONSTRAINT; Schema: employment_schema; Owner: fractal
--

ALTER TABLE ONLY employment_schema.work_experience
    ADD CONSTRAINT fkjp8qgildg69x3vyoy2jtg1xlj FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: work_experience fkmoyuehlll0xvl2ea4hnd9wfm; Type: FK CONSTRAINT; Schema: employment_schema; Owner: fractal
--

ALTER TABLE ONLY employment_schema.work_experience
    ADD CONSTRAINT fkmoyuehlll0xvl2ea4hnd9wfm FOREIGN KEY (employment_type_id) REFERENCES employment_schema.employment_type(id);


--
-- Name: work_experience fkp6y99wr1rq35iatijh83te7y7; Type: FK CONSTRAINT; Schema: employment_schema; Owner: fractal
--

ALTER TABLE ONLY employment_schema.work_experience
    ADD CONSTRAINT fkp6y99wr1rq35iatijh83te7y7 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: identification_document_type fk3wrrux5ijujd14bkefa1j8xhc; Type: FK CONSTRAINT; Schema: identification_schema; Owner: fractal
--

ALTER TABLE ONLY identification_schema.identification_document_type
    ADD CONSTRAINT fk3wrrux5ijujd14bkefa1j8xhc FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: identification_document fk9fhx2j37s5l15ccoj7mjl9afd; Type: FK CONSTRAINT; Schema: identification_schema; Owner: fractal
--

ALTER TABLE ONLY identification_schema.identification_document
    ADD CONSTRAINT fk9fhx2j37s5l15ccoj7mjl9afd FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: identification_document fka09iqrithni1n9ngx9vwfhr81; Type: FK CONSTRAINT; Schema: identification_schema; Owner: fractal
--

ALTER TABLE ONLY identification_schema.identification_document
    ADD CONSTRAINT fka09iqrithni1n9ngx9vwfhr81 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: identification_document fkicxgrtk7s9lhqqs7mbld5w9ie; Type: FK CONSTRAINT; Schema: identification_schema; Owner: fractal
--

ALTER TABLE ONLY identification_schema.identification_document
    ADD CONSTRAINT fkicxgrtk7s9lhqqs7mbld5w9ie FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: identification_document_type fkjqgrau3xkgox0gvgax2dec0aw; Type: FK CONSTRAINT; Schema: identification_schema; Owner: fractal
--

ALTER TABLE ONLY identification_schema.identification_document_type
    ADD CONSTRAINT fkjqgrau3xkgox0gvgax2dec0aw FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: identification_document fkk33mn08bfsluu4b4udlwty3oe; Type: FK CONSTRAINT; Schema: identification_schema; Owner: fractal
--

ALTER TABLE ONLY identification_schema.identification_document
    ADD CONSTRAINT fkk33mn08bfsluu4b4udlwty3oe FOREIGN KEY (identification_type_id) REFERENCES identification_schema.identification_document_type(id);


--
-- Name: layout_label_detail fk371l7576vbee2p7flxhebf3d9; Type: FK CONSTRAINT; Schema: localization_schema; Owner: fractal
--

ALTER TABLE ONLY localization_schema.layout_label_detail
    ADD CONSTRAINT fk371l7576vbee2p7flxhebf3d9 FOREIGN KEY (language_id) REFERENCES localization_schema.language(id);


--
-- Name: language fk4nuxj3b1xosqqnlfvmymnk93x; Type: FK CONSTRAINT; Schema: localization_schema; Owner: fractal
--

ALTER TABLE ONLY localization_schema.language
    ADD CONSTRAINT fk4nuxj3b1xosqqnlfvmymnk93x FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: language fk9609nf8jd35ssnh62g8w8j8ju; Type: FK CONSTRAINT; Schema: localization_schema; Owner: fractal
--

ALTER TABLE ONLY localization_schema.language
    ADD CONSTRAINT fk9609nf8jd35ssnh62g8w8j8ju FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: layout_label fkb57jkw4jj0hf5es4bjow60rv1; Type: FK CONSTRAINT; Schema: localization_schema; Owner: fractal
--

ALTER TABLE ONLY localization_schema.layout_label
    ADD CONSTRAINT fkb57jkw4jj0hf5es4bjow60rv1 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: layout_label_detail fkfjdvrebibvynp7q8avus7h3tf; Type: FK CONSTRAINT; Schema: localization_schema; Owner: fractal
--

ALTER TABLE ONLY localization_schema.layout_label_detail
    ADD CONSTRAINT fkfjdvrebibvynp7q8avus7h3tf FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: layout_label fki6uo8wlcsjat59sntmo0bt3g9; Type: FK CONSTRAINT; Schema: localization_schema; Owner: fractal
--

ALTER TABLE ONLY localization_schema.layout_label
    ADD CONSTRAINT fki6uo8wlcsjat59sntmo0bt3g9 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: layout_label_detail fkiimy8s3mrn62tm28vm5u9i8p6; Type: FK CONSTRAINT; Schema: localization_schema; Owner: fractal
--

ALTER TABLE ONLY localization_schema.layout_label_detail
    ADD CONSTRAINT fkiimy8s3mrn62tm28vm5u9i8p6 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: layout_label_detail fkjqq3apele5st97kahqigmdjil; Type: FK CONSTRAINT; Schema: localization_schema; Owner: fractal
--

ALTER TABLE ONLY localization_schema.layout_label_detail
    ADD CONSTRAINT fkjqq3apele5st97kahqigmdjil FOREIGN KEY (layout_label_id) REFERENCES localization_schema.layout_label(id);


--
-- Name: district fk1q08nqsgy69cs1rq6xgyg7w96; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.district
    ADD CONSTRAINT fk1q08nqsgy69cs1rq6xgyg7w96 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: area_type fk1sre3vgjo29aqle423uxijp6c; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.area_type
    ADD CONSTRAINT fk1sre3vgjo29aqle423uxijp6c FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: country fk29qebdxc7vct81f8l37f8rjux; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.country
    ADD CONSTRAINT fk29qebdxc7vct81f8l37f8rjux FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: city fk2el58jr2ryiy4qico8h4fg7kl; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.city
    ADD CONSTRAINT fk2el58jr2ryiy4qico8h4fg7kl FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: city fk47nc6w4ttxijd5684upkcanuh; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.city
    ADD CONSTRAINT fk47nc6w4ttxijd5684upkcanuh FOREIGN KEY (area_type_id) REFERENCES location_schema.area_type(id);


--
-- Name: address fk4ljdc68rnke4txup1jlf1il4l; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.address
    ADD CONSTRAINT fk4ljdc68rnke4txup1jlf1il4l FOREIGN KEY (region_id) REFERENCES location_schema.region(id);


--
-- Name: region fk7vb2cqcnkr9391hfn72louxkq; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.region
    ADD CONSTRAINT fk7vb2cqcnkr9391hfn72louxkq FOREIGN KEY (country_id) REFERENCES location_schema.country(id);


--
-- Name: address fk9pnfumec02sjj7d06781ng2na; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.address
    ADD CONSTRAINT fk9pnfumec02sjj7d06781ng2na FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: address fke54x81nmccsk5569hsjg1a6ka; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.address
    ADD CONSTRAINT fke54x81nmccsk5569hsjg1a6ka FOREIGN KEY (country_id) REFERENCES location_schema.country(id);


--
-- Name: country fkgbqdd9y404natt5pjhpor00q1; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.country
    ADD CONSTRAINT fkgbqdd9y404natt5pjhpor00q1 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: city fkgogf8vj1ups4k75fvtcpi6r3g; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.city
    ADD CONSTRAINT fkgogf8vj1ups4k75fvtcpi6r3g FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: address_type fkgorq7n67dsr2hk2i84ci4j2rp; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.address_type
    ADD CONSTRAINT fkgorq7n67dsr2hk2i84ci4j2rp FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: address_type fkhr5q6sm2c4dqvsakyy5et6dit; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.address_type
    ADD CONSTRAINT fkhr5q6sm2c4dqvsakyy5et6dit FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: region fkj455xq4kwamwva7p9ov5erly7; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.region
    ADD CONSTRAINT fkj455xq4kwamwva7p9ov5erly7 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: region fkjlnmywhrkx37ldlpyrxobx2uq; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.region
    ADD CONSTRAINT fkjlnmywhrkx37ldlpyrxobx2uq FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: district fkjtoeoh4xkl9qfrge7oi6y0hah; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.district
    ADD CONSTRAINT fkjtoeoh4xkl9qfrge7oi6y0hah FOREIGN KEY (area_type_id) REFERENCES location_schema.area_type(id);


--
-- Name: address fkkkjn52mg1vha4yjpm0douso7f; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.address
    ADD CONSTRAINT fkkkjn52mg1vha4yjpm0douso7f FOREIGN KEY (address_type_id) REFERENCES location_schema.address_type(id);


--
-- Name: address fkm5kwvo986qy095784tqwutb45; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.address
    ADD CONSTRAINT fkm5kwvo986qy095784tqwutb45 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: area_type fknkt26vcn1vps4cb95ygnmrkf2; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.area_type
    ADD CONSTRAINT fknkt26vcn1vps4cb95ygnmrkf2 FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: district fkpjyu66maoe0h5uqfhle85e5vo; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.district
    ADD CONSTRAINT fkpjyu66maoe0h5uqfhle85e5vo FOREIGN KEY (region_id) REFERENCES location_schema.region(id);


--
-- Name: address fkpo044ng5x4gynb291cv24vtea; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.address
    ADD CONSTRAINT fkpo044ng5x4gynb291cv24vtea FOREIGN KEY (city_id) REFERENCES location_schema.city(id);


--
-- Name: address fkqbjwfi50pdenou8j14knnffrh; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.address
    ADD CONSTRAINT fkqbjwfi50pdenou8j14knnffrh FOREIGN KEY (district_id) REFERENCES location_schema.district(id);


--
-- Name: district fksgx09prp6sk2f0we38bf2dtal; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.district
    ADD CONSTRAINT fksgx09prp6sk2f0we38bf2dtal FOREIGN KEY (city_id) REFERENCES location_schema.city(id);


--
-- Name: city fksi0dkm9kk6dyuedmc0j18t770; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.city
    ADD CONSTRAINT fksi0dkm9kk6dyuedmc0j18t770 FOREIGN KEY (region_id) REFERENCES location_schema.region(id);


--
-- Name: district fktpfvl4al4538wfe5ric9j3xum; Type: FK CONSTRAINT; Schema: location_schema; Owner: fractal
--

ALTER TABLE ONLY location_schema.district
    ADD CONSTRAINT fktpfvl4al4538wfe5ric9j3xum FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: military_service fk8af24bjreoi8k673a1kgxn0qd; Type: FK CONSTRAINT; Schema: military_schema; Owner: fractal
--

ALTER TABLE ONLY military_schema.military_service
    ADD CONSTRAINT fk8af24bjreoi8k673a1kgxn0qd FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: military_service_resource fkcjiubvp9d0qqqsk6fbw5x58db; Type: FK CONSTRAINT; Schema: military_schema; Owner: fractal
--

ALTER TABLE ONLY military_schema.military_service_resource
    ADD CONSTRAINT fkcjiubvp9d0qqqsk6fbw5x58db FOREIGN KEY (id) REFERENCES resource_schema.resource(id);


--
-- Name: military_service fkmlbujp7itssen83clu6nbfl4l; Type: FK CONSTRAINT; Schema: military_schema; Owner: fractal
--

ALTER TABLE ONLY military_schema.military_service
    ADD CONSTRAINT fkmlbujp7itssen83clu6nbfl4l FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: military_service_resource fksbyprtgcd53vm548gbya4abm4; Type: FK CONSTRAINT; Schema: military_schema; Owner: fractal
--

ALTER TABLE ONLY military_schema.military_service_resource
    ADD CONSTRAINT fksbyprtgcd53vm548gbya4abm4 FOREIGN KEY (military_service_id) REFERENCES military_schema.military_service(id);


--
-- Name: menu_transition fk1djnn92vc7tcspn9jgfxrpb2x; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_transition
    ADD CONSTRAINT fk1djnn92vc7tcspn9jgfxrpb2x FOREIGN KEY (menu_id) REFERENCES navigation_schema.menu(id);


--
-- Name: menu_configuration fk1ofckfyl28omx70msjr8ft00n; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_configuration
    ADD CONSTRAINT fk1ofckfyl28omx70msjr8ft00n FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: action fk212uaoflbe9m6xh606d7anwv7; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action
    ADD CONSTRAINT fk212uaoflbe9m6xh606d7anwv7 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: menu_action_form_component fk2mmb3d3s5x1t6btnqio5em7qv; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action_form_component
    ADD CONSTRAINT fk2mmb3d3s5x1t6btnqio5em7qv FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: public_url fk2rhceer2swq0918tdv8d8m8ot; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.public_url
    ADD CONSTRAINT fk2rhceer2swq0918tdv8d8m8ot FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: configuration fk3r24iehk8bjdnii35meps87l6; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.configuration
    ADD CONSTRAINT fk3r24iehk8bjdnii35meps87l6 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: menu_transition fk46ka2sm0om1v7i3o6yg4mamyb; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_transition
    ADD CONSTRAINT fk46ka2sm0om1v7i3o6yg4mamyb FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: action fk5gb6d57cwh9sxqneo6i17xkj0; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action
    ADD CONSTRAINT fk5gb6d57cwh9sxqneo6i17xkj0 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: menu_action fk5uvjvyklimqf3vsy4b7i8bpxy; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action
    ADD CONSTRAINT fk5uvjvyklimqf3vsy4b7i8bpxy FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: menu_action_transition fk665kwdvf98bqgsl551pedmla2; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action_transition
    ADD CONSTRAINT fk665kwdvf98bqgsl551pedmla2 FOREIGN KEY (menu_action_id) REFERENCES navigation_schema.menu_action(id);


--
-- Name: form_components fk6aa91rjx7v1dnyu2vwqkjlqeq; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.form_components
    ADD CONSTRAINT fk6aa91rjx7v1dnyu2vwqkjlqeq FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: action_category fk71261v5k1uhkd2oow9ggsumfr; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action_category
    ADD CONSTRAINT fk71261v5k1uhkd2oow9ggsumfr FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: action fk7dauqaa033jldyrnyur8q87qw; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action
    ADD CONSTRAINT fk7dauqaa033jldyrnyur8q87qw FOREIGN KEY (action_type_id) REFERENCES navigation_schema.action_type(id);


--
-- Name: form_component_attributes fk7evhr508p9w32o48rhjffooes; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.form_component_attributes
    ADD CONSTRAINT fk7evhr508p9w32o48rhjffooes FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: menu fk7g5yjx6gptkwon18oo9rmrnl; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu
    ADD CONSTRAINT fk7g5yjx6gptkwon18oo9rmrnl FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: navigation_unit fk7o8osgapkyuvcba896p6neu0i; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.navigation_unit
    ADD CONSTRAINT fk7o8osgapkyuvcba896p6neu0i FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: configuration fk7ql49360vf19vhj13rh3hrk29; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.configuration
    ADD CONSTRAINT fk7ql49360vf19vhj13rh3hrk29 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: menu_action fk8otwg0y5xd1lphemm0keoks1; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action
    ADD CONSTRAINT fk8otwg0y5xd1lphemm0keoks1 FOREIGN KEY (action_id) REFERENCES navigation_schema.action(id);


--
-- Name: form_components fk992xbdp3e46h98jal5etaflc0; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.form_components
    ADD CONSTRAINT fk992xbdp3e46h98jal5etaflc0 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: menu_action_form_component fka4021gyr6r3cj2v3ei6vavifd; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action_form_component
    ADD CONSTRAINT fka4021gyr6r3cj2v3ei6vavifd FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: menu_action_form_component fkaiwvftsuv6mlssloswpgd9mdt; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action_form_component
    ADD CONSTRAINT fkaiwvftsuv6mlssloswpgd9mdt FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: menu_configuration fkbiaekwf06al9qfamy8lwjtxg5; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_configuration
    ADD CONSTRAINT fkbiaekwf06al9qfamy8lwjtxg5 FOREIGN KEY (configuration_id) REFERENCES navigation_schema.configuration(id);


--
-- Name: menu_action_form_component fkc0srox7qykeg2k8br4qebixqh; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action_form_component
    ADD CONSTRAINT fkc0srox7qykeg2k8br4qebixqh FOREIGN KEY (form_component_id) REFERENCES navigation_schema.form_components(id);


--
-- Name: menu fkcnkpup7yejhub2kygm33p5b4h; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu
    ADD CONSTRAINT fkcnkpup7yejhub2kygm33p5b4h FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: public_url fkd1ihp2m6p74mn9e1qruo6648h; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.public_url
    ADD CONSTRAINT fkd1ihp2m6p74mn9e1qruo6648h FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: action fkdvqlh9a1cst8hl7il6l2mkwjn; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action
    ADD CONSTRAINT fkdvqlh9a1cst8hl7il6l2mkwjn FOREIGN KEY (layout_label_id) REFERENCES localization_schema.layout_label(id);


--
-- Name: form_components fkdy5j2bidu30xddm6dp7o9wiwb; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.form_components
    ADD CONSTRAINT fkdy5j2bidu30xddm6dp7o9wiwb FOREIGN KEY (layout_label_id) REFERENCES localization_schema.layout_label(id);


--
-- Name: menu fkekqy9sl4ik55cttsdj8qmg1y; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu
    ADD CONSTRAINT fkekqy9sl4ik55cttsdj8qmg1y FOREIGN KEY (layout_label_id) REFERENCES localization_schema.layout_label(id);


--
-- Name: menu fkgeupubdqncc1lpgf2cn4fqwbc; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu
    ADD CONSTRAINT fkgeupubdqncc1lpgf2cn4fqwbc FOREIGN KEY (parent_id) REFERENCES navigation_schema.menu(id);


--
-- Name: menu_action_transition fkgnq5ucjp1oohaft7v9dskcauk; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action_transition
    ADD CONSTRAINT fkgnq5ucjp1oohaft7v9dskcauk FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: menu_action_form_component fkhpu8p92j7y7k7pktoijqcjiwy; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action_form_component
    ADD CONSTRAINT fkhpu8p92j7y7k7pktoijqcjiwy FOREIGN KEY (menu_action_id) REFERENCES navigation_schema.menu_action(id);


--
-- Name: form_component_attributes fki8wy0so3l282v9o27ewtt2v8; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.form_component_attributes
    ADD CONSTRAINT fki8wy0so3l282v9o27ewtt2v8 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: menu_configuration fkifvwi920ejmjq15f696trx3rl; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_configuration
    ADD CONSTRAINT fkifvwi920ejmjq15f696trx3rl FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: menu_transition fkjhlhtau9y9s1i1s3frp7s79c; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_transition
    ADD CONSTRAINT fkjhlhtau9y9s1i1s3frp7s79c FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: action_type fkk7dtr5waa6nud4shlq82id5e3; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action_type
    ADD CONSTRAINT fkk7dtr5waa6nud4shlq82id5e3 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: action_type fkkgxo5a7fky15908pibdmouacw; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action_type
    ADD CONSTRAINT fkkgxo5a7fky15908pibdmouacw FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: menu_action fklks23fy4rnbk829v92e9tnl77; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action
    ADD CONSTRAINT fklks23fy4rnbk829v92e9tnl77 FOREIGN KEY (menu_id) REFERENCES navigation_schema.menu(id);


--
-- Name: form_component_attributes fkmb2f61fuoj2rsc5bjvm77xh4o; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.form_component_attributes
    ADD CONSTRAINT fkmb2f61fuoj2rsc5bjvm77xh4o FOREIGN KEY (component_attribute_id) REFERENCES ui_schema.component_attributes(id);


--
-- Name: menu_configuration fkmlg5tdf0yrjofctkmmn94ae81; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_configuration
    ADD CONSTRAINT fkmlg5tdf0yrjofctkmmn94ae81 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: public_url fkmqcyrqxkqac7esmv7ewuj7w68; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.public_url
    ADD CONSTRAINT fkmqcyrqxkqac7esmv7ewuj7w68 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: menu_configuration fknijxka53lvc8x5oberk93nb30; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_configuration
    ADD CONSTRAINT fknijxka53lvc8x5oberk93nb30 FOREIGN KEY (menu_id) REFERENCES navigation_schema.menu(id);


--
-- Name: menu_action fknpsy07obtx150rs7rjejfm9y3; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action
    ADD CONSTRAINT fknpsy07obtx150rs7rjejfm9y3 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: menu_action_transition fknwg68jbi51n6r24ue8tiuq8ft; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action_transition
    ADD CONSTRAINT fknwg68jbi51n6r24ue8tiuq8ft FOREIGN KEY (menu_transition_id) REFERENCES navigation_schema.menu_transition(id);


--
-- Name: form_components fko4wtvqjxhrt8aqtvryxks0vi6; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.form_components
    ADD CONSTRAINT fko4wtvqjxhrt8aqtvryxks0vi6 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: form_components fkocuvuqnac8dpqwlhawkgcw0uo; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.form_components
    ADD CONSTRAINT fkocuvuqnac8dpqwlhawkgcw0uo FOREIGN KEY (component_id) REFERENCES ui_schema.component(id);


--
-- Name: menu_action fkoga0v1knnlukn9a3abrivo0pv; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action
    ADD CONSTRAINT fkoga0v1knnlukn9a3abrivo0pv FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: menu_transition fkojprs0jl3ieh3sxy5iugphir7; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_transition
    ADD CONSTRAINT fkojprs0jl3ieh3sxy5iugphir7 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: menu_action_transition fkp5yicewv25gchxamqa9jr599a; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action_transition
    ADD CONSTRAINT fkp5yicewv25gchxamqa9jr599a FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: navigation_unit fkpaxxibli3jom1o7p7wl4slcb3; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.navigation_unit
    ADD CONSTRAINT fkpaxxibli3jom1o7p7wl4slcb3 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: action fkpyh2pe21oxej3ae0d9is85mpq; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action
    ADD CONSTRAINT fkpyh2pe21oxej3ae0d9is85mpq FOREIGN KEY (action_category_id) REFERENCES navigation_schema.action_category(id);


--
-- Name: menu_transition fkq0mhg153agoc4htt8uo5hmo3a; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_transition
    ADD CONSTRAINT fkq0mhg153agoc4htt8uo5hmo3a FOREIGN KEY (entity_type_id) REFERENCES dictionary_schema.entity_type(id);


--
-- Name: form_component_attributes fkqhcsbra6phi8fateu7p3anin8; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.form_component_attributes
    ADD CONSTRAINT fkqhcsbra6phi8fateu7p3anin8 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: action_category fkqhfvfrt6s4lgr0dk2434al1ai; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.action_category
    ADD CONSTRAINT fkqhfvfrt6s4lgr0dk2434al1ai FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: menu_action_transition fkqpbr8enfrpaddt4q8tjjt06ak; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.menu_action_transition
    ADD CONSTRAINT fkqpbr8enfrpaddt4q8tjjt06ak FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: form_component_attributes fks199ajsh4vi0r9ah9yhg7dbyr; Type: FK CONSTRAINT; Schema: navigation_schema; Owner: fractal
--

ALTER TABLE ONLY navigation_schema.form_component_attributes
    ADD CONSTRAINT fks199ajsh4vi0r9ah9yhg7dbyr FOREIGN KEY (form_component_id) REFERENCES navigation_schema.form_components(id);


--
-- Name: accountability fk1guihvi3fb7rxseuu84bck8vw; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.accountability
    ADD CONSTRAINT fk1guihvi3fb7rxseuu84bck8vw FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: position fk2i1atjdpclcep7x7evw1akqwd; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema."position"
    ADD CONSTRAINT fk2i1atjdpclcep7x7evw1akqwd FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: grade_step fk3b1u7gcomwpjhdt6pcjpys3e7; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade_step
    ADD CONSTRAINT fk3b1u7gcomwpjhdt6pcjpys3e7 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: grade_level fk3bfio4yrisp4c4you6pbb1inv; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade_level
    ADD CONSTRAINT fk3bfio4yrisp4c4you6pbb1inv FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: accountability fk3yhcetalvpxeyscd4i2gbisce; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.accountability
    ADD CONSTRAINT fk3yhcetalvpxeyscd4i2gbisce FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: organization_address fk4bxk7tixquspybhj8mdi6vyhi; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization_address
    ADD CONSTRAINT fk4bxk7tixquspybhj8mdi6vyhi FOREIGN KEY (organization_id) REFERENCES organization_schema.organization(id);


--
-- Name: position fk4m4tca2i2jjfx6vydbs3l0ul2; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema."position"
    ADD CONSTRAINT fk4m4tca2i2jjfx6vydbs3l0ul2 FOREIGN KEY (grade_id) REFERENCES organization_schema.grade(id);


--
-- Name: separationReason fk5ptf7l6on51fsf8aa2jx9rnlf; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.separationReason
    ADD CONSTRAINT fk5ptf7l6on51fsf8aa2jx9rnlf FOREIGN KEY (organization_unit_id) REFERENCES organization_schema.organization_unit(id);


--
-- Name: job_description fk6aggivxmolyw8miurbqfkp2n4; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.job_description
    ADD CONSTRAINT fk6aggivxmolyw8miurbqfkp2n4 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: responsibility fk7plhr1v02ns1cbc0avfrxa5q0; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.responsibility
    ADD CONSTRAINT fk7plhr1v02ns1cbc0avfrxa5q0 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: accountability fk7xqcppjg3kworxvy4srmp01o3; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.accountability
    ADD CONSTRAINT fk7xqcppjg3kworxvy4srmp01o3 FOREIGN KEY (job_description_id) REFERENCES organization_schema.job_description(id);


--
-- Name: grade fk7xrcuu7nqcnfch3k0xjx5tpav; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade
    ADD CONSTRAINT fk7xrcuu7nqcnfch3k0xjx5tpav FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: qualification fk98lf0r7eue8pd0vajnjeyvliw; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.qualification
    ADD CONSTRAINT fk98lf0r7eue8pd0vajnjeyvliw FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: position fk9ffk1rsmxqm40un5pmmyxu501; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema."position"
    ADD CONSTRAINT fk9ffk1rsmxqm40un5pmmyxu501 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: required_experience fk9fmh2wvfv466gjmxxtk2yxlgb; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.required_experience
    ADD CONSTRAINT fk9fmh2wvfv466gjmxxtk2yxlgb FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: qualification fk9xgajp2u2mgu3x6f02wurskev; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.qualification
    ADD CONSTRAINT fk9xgajp2u2mgu3x6f02wurskev FOREIGN KEY (job_description_id) REFERENCES organization_schema.job_description(id);


--
-- Name: key_performance_indicator fka0jwlwqybkodsqgvxokeublyw; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.key_performance_indicator
    ADD CONSTRAINT fka0jwlwqybkodsqgvxokeublyw FOREIGN KEY (job_description_id) REFERENCES organization_schema.job_description(id);


--
-- Name: job_description fka29xefaot60o1i9me3jdnrbt0; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.job_description
    ADD CONSTRAINT fka29xefaot60o1i9me3jdnrbt0 FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: reporting_line fkbqg9gyw4jrfwdqwajnxe3584o; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.reporting_line
    ADD CONSTRAINT fkbqg9gyw4jrfwdqwajnxe3584o FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: qualification fkbxdu76uexo9vl2px2pik43ggj; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.qualification
    ADD CONSTRAINT fkbxdu76uexo9vl2px2pik43ggj FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: organization_unit fkc0yjou4eipgitkl7qt8i4bw9u; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization_unit
    ADD CONSTRAINT fkc0yjou4eipgitkl7qt8i4bw9u FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: organization fkc30yedjwp9qw1f3nn2ytda7tj; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization
    ADD CONSTRAINT fkc30yedjwp9qw1f3nn2ytda7tj FOREIGN KEY (parent_id) REFERENCES organization_schema.organization(id);


--
-- Name: reporting_line fkdmmo7w28s05d6605vpnmtx9bd; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.reporting_line
    ADD CONSTRAINT fkdmmo7w28s05d6605vpnmtx9bd FOREIGN KEY (job_description_id) REFERENCES organization_schema.job_description(id);


--
-- Name: reporting_line fkdo6papx163yyjx746qbnbqlgq; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.reporting_line
    ADD CONSTRAINT fkdo6papx163yyjx746qbnbqlgq FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: grade fkdprna7hy65wr3ngm14ryynsvu; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade
    ADD CONSTRAINT fkdprna7hy65wr3ngm14ryynsvu FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: position fkdw61fctruyml0gypg10jucjw9; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema."position"
    ADD CONSTRAINT fkdw61fctruyml0gypg10jucjw9 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: grade_level fkdwpgrcf9yf68h68gom8a7u5u7; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade_level
    ADD CONSTRAINT fkdwpgrcf9yf68h68gom8a7u5u7 FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: reporting_line fke8qg8x5p67jgx5f6llx9yadie; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.reporting_line
    ADD CONSTRAINT fke8qg8x5p67jgx5f6llx9yadie FOREIGN KEY (reporting_line_type_id) REFERENCES organization_schema.reporting_line_type(id);


--
-- Name: organization_address fkefggcvbaya8057e0tk0dq8edr; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization_address
    ADD CONSTRAINT fkefggcvbaya8057e0tk0dq8edr FOREIGN KEY (id) REFERENCES location_schema.address(id);


--
-- Name: key_performance_indicator fkeibmd61goas4hpm9oul965tnb; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.key_performance_indicator
    ADD CONSTRAINT fkeibmd61goas4hpm9oul965tnb FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: authority fkesexn44wmq0k58w2v6ayfbwlu; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.authority
    ADD CONSTRAINT fkesexn44wmq0k58w2v6ayfbwlu FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: grade_step fkfik8o7842uqxnu3y6w60m4av7; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade_step
    ADD CONSTRAINT fkfik8o7842uqxnu3y6w60m4av7 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: separationReason fkfqtv5nnif1gd3tjiey0mvcsqv; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.separationReason
    ADD CONSTRAINT fkfqtv5nnif1gd3tjiey0mvcsqv FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: responsibility fkg3vsmwqbvklt9127snmnvselc; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.responsibility
    ADD CONSTRAINT fkg3vsmwqbvklt9127snmnvselc FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: authority fkgm1gbyt6evane5dgvf4200jbs; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.authority
    ADD CONSTRAINT fkgm1gbyt6evane5dgvf4200jbs FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: grade fkhkm4gynm673v44jgryiy9odh2; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade
    ADD CONSTRAINT fkhkm4gynm673v44jgryiy9odh2 FOREIGN KEY (grade_level_id) REFERENCES organization_schema.grade_level(id);


--
-- Name: required_experience fkibbrxe6wnmbnyvy5yodlvt9wk; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.required_experience
    ADD CONSTRAINT fkibbrxe6wnmbnyvy5yodlvt9wk FOREIGN KEY (job_description_id) REFERENCES organization_schema.job_description(id);


--
-- Name: organization_contact fkisl50plaa1n7i1nkkpbulmfmc; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization_contact
    ADD CONSTRAINT fkisl50plaa1n7i1nkkpbulmfmc FOREIGN KEY (organization_id) REFERENCES organization_schema.organization(id);


--
-- Name: job_description fkj1b1tcb2n50g5vu4imq10ro3s; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.job_description
    ADD CONSTRAINT fkj1b1tcb2n50g5vu4imq10ro3s FOREIGN KEY (position_id) REFERENCES organization_schema."position"(id);


--
-- Name: grade fkj48n3kbwid0sjrngmyv7ukhm; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade
    ADD CONSTRAINT fkj48n3kbwid0sjrngmyv7ukhm FOREIGN KEY (currency_id) REFERENCES dictionary_schema.currency(id);


--
-- Name: grade fkjcfgalg5dl5bomjjplgsogcym; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade
    ADD CONSTRAINT fkjcfgalg5dl5bomjjplgsogcym FOREIGN KEY (parent_id) REFERENCES organization_schema.grade(id);


--
-- Name: grade fkjsr2foca5vwxc0tcd6xm5hoy0; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade
    ADD CONSTRAINT fkjsr2foca5vwxc0tcd6xm5hoy0 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: required_experience fkjttwo7qqsqwcu8tqbhlk7wbbh; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.required_experience
    ADD CONSTRAINT fkjttwo7qqsqwcu8tqbhlk7wbbh FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: reporting_line_type fkk3vjtyxlyht52idypy7lnrx0x; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.reporting_line_type
    ADD CONSTRAINT fkk3vjtyxlyht52idypy7lnrx0x FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: organization fkl215pwk5km2p99pi6m2yk55qj; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization
    ADD CONSTRAINT fkl215pwk5km2p99pi6m2yk55qj FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: job_description fkl5c84b66s1vutn7j1avntv8hn; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.job_description
    ADD CONSTRAINT fkl5c84b66s1vutn7j1avntv8hn FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: responsibility fkl5yqbxpqrssttjy8khn1s0va0; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.responsibility
    ADD CONSTRAINT fkl5yqbxpqrssttjy8khn1s0va0 FOREIGN KEY (job_description_id) REFERENCES organization_schema.job_description(id);


--
-- Name: work_schedule fklc197h6r7la0hehtvxj3nsfeb; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.work_schedule
    ADD CONSTRAINT fklc197h6r7la0hehtvxj3nsfeb FOREIGN KEY (id) REFERENCES work_schedule_schema.work_schedule(id);


--
-- Name: position fkm3sbyitwagg27v6n7kobokau5; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema."position"
    ADD CONSTRAINT fkm3sbyitwagg27v6n7kobokau5 FOREIGN KEY (department_id) REFERENCES organization_schema.separationReason(id);


--
-- Name: work_schedule fkm74jkkch72jh8o9x9owhjdh6v; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.work_schedule
    ADD CONSTRAINT fkm74jkkch72jh8o9x9owhjdh6v FOREIGN KEY (organization_id) REFERENCES organization_schema.organization(id);


--
-- Name: separationReason fkmgsnnmudxrwqidn4f64q8rp4o; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.separationReason
    ADD CONSTRAINT fkmgsnnmudxrwqidn4f64q8rp4o FOREIGN KEY (parent_id) REFERENCES organization_schema.separationReason(id);


--
-- Name: reporting_line fknug7san1s41lpsmtbp9j4v2nl; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.reporting_line
    ADD CONSTRAINT fknug7san1s41lpsmtbp9j4v2nl FOREIGN KEY (position_id) REFERENCES organization_schema."position"(id);


--
-- Name: grade_step fko0gt0b9re6s104ys5k8o1neno; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade_step
    ADD CONSTRAINT fko0gt0b9re6s104ys5k8o1neno FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: key_performance_indicator fkodjy4q0ojg5u9tirx6hcjswss; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.key_performance_indicator
    ADD CONSTRAINT fkodjy4q0ojg5u9tirx6hcjswss FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: separationReason fkovdg8bvkum4mh0ikrdr7q6rlm; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.separationReason
    ADD CONSTRAINT fkovdg8bvkum4mh0ikrdr7q6rlm FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: grade_step fkrd14k2gwjpwffpnpuy1puqdbv; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.grade_step
    ADD CONSTRAINT fkrd14k2gwjpwffpnpuy1puqdbv FOREIGN KEY (grade_id) REFERENCES organization_schema.grade(id);


--
-- Name: reporting_line_type fkrpfhg91rakqg4p48mse920f7w; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.reporting_line_type
    ADD CONSTRAINT fkrpfhg91rakqg4p48mse920f7w FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: organization_contact fkrxldtwyw0ewgd16nh1dbpk9on; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization_contact
    ADD CONSTRAINT fkrxldtwyw0ewgd16nh1dbpk9on FOREIGN KEY (id) REFERENCES contact_schema.contact(id);


--
-- Name: authority fkrxxda3cfyp3e4glgb5wx6r7je; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.authority
    ADD CONSTRAINT fkrxxda3cfyp3e4glgb5wx6r7je FOREIGN KEY (job_description_id) REFERENCES organization_schema.job_description(id);


--
-- Name: organization_unit fks84y3cn9levaa67l9lkm6r05e; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization_unit
    ADD CONSTRAINT fks84y3cn9levaa67l9lkm6r05e FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: separationReason fksj0beotu978kowumc6hklbl4c; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.separationReason
    ADD CONSTRAINT fksj0beotu978kowumc6hklbl4c FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: reporting_line fksj9u0slv7itvaqaslj6rq28j4; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.reporting_line
    ADD CONSTRAINT fksj9u0slv7itvaqaslj6rq28j4 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: organization fkstgsvhc6dn2t32td4knbssjky; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization
    ADD CONSTRAINT fkstgsvhc6dn2t32td4knbssjky FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: organization fkt4gf01gb3wep67ywcpfemqro3; Type: FK CONSTRAINT; Schema: organization_schema; Owner: fractal
--

ALTER TABLE ONLY organization_schema.organization
    ADD CONSTRAINT fkt4gf01gb3wep67ywcpfemqro3 FOREIGN KEY (organization_unit_id) REFERENCES organization_schema.organization_unit(id);


--
-- Name: interview_evaluation_section fk138icxaoj7yi6l2ripuemsb7o; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_section
    ADD CONSTRAINT fk138icxaoj7yi6l2ripuemsb7o FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: interview_evaluation_answer fk19xy9g3bi078w0a57vwcwihq5; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_answer
    ADD CONSTRAINT fk19xy9g3bi078w0a57vwcwihq5 FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: candidate_education fk1eu32qpinp2dh1pjtno7ku8mn; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_education
    ADD CONSTRAINT fk1eu32qpinp2dh1pjtno7ku8mn FOREIGN KEY (id) REFERENCES education_schema.education(id);


--
-- Name: interview_evaluation_answer fk2ccsnew7gpthcix49g8brv5ab; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_answer
    ADD CONSTRAINT fk2ccsnew7gpthcix49g8brv5ab FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: candidate_military_service fk32md2gwm76pk7opcybuxyxtme; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_military_service
    ADD CONSTRAINT fk32md2gwm76pk7opcybuxyxtme FOREIGN KEY (id) REFERENCES military_schema.military_service(id);


--
-- Name: interview_evaluation_answer fk3aw8vbgqu7n5fii8gk35kc7r9; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_answer
    ADD CONSTRAINT fk3aw8vbgqu7n5fii8gk35kc7r9 FOREIGN KEY (interview_evaluation_question_id) REFERENCES recruitment_schema.interview_evaluation_question(id);


--
-- Name: interview_evaluation fk3kqkw8norrctqyst0wannpln2; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation
    ADD CONSTRAINT fk3kqkw8norrctqyst0wannpln2 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: interview_evaluation_answer fk4lqfgorrql9ypd4h3jjtupni7; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_answer
    ADD CONSTRAINT fk4lqfgorrql9ypd4h3jjtupni7 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: candidate fk4sn940s55wnxxa7k1bmjjy00w; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate
    ADD CONSTRAINT fk4sn940s55wnxxa7k1bmjjy00w FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: interview_evaluation_question fk4yddusgnifpaxim7xgk76q743; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_question
    ADD CONSTRAINT fk4yddusgnifpaxim7xgk76q743 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: vacancy fk57dh2fsk2okd4j3hvv7w4skgd; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.vacancy
    ADD CONSTRAINT fk57dh2fsk2okd4j3hvv7w4skgd FOREIGN KEY (position_id) REFERENCES organization_schema."position"(id);


--
-- Name: interviewer fk5vnf59nnkrosyk1g9kbopoqg9; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interviewer
    ADD CONSTRAINT fk5vnf59nnkrosyk1g9kbopoqg9 FOREIGN KEY (employee_id) REFERENCES employee_schema.employee(id);


--
-- Name: candidate fk5y77gy4a4roeglaeh6t3nxw1n; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate
    ADD CONSTRAINT fk5y77gy4a4roeglaeh6t3nxw1n FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: experience fk6e77r5xga0xb11rh9s6mbrdmo; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.experience
    ADD CONSTRAINT fk6e77r5xga0xb11rh9s6mbrdmo FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: candidate fk6n8vqigjcpdk7ewjbsk4u8jeg; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate
    ADD CONSTRAINT fk6n8vqigjcpdk7ewjbsk4u8jeg FOREIGN KEY (vacancy_id) REFERENCES recruitment_schema.vacancy(id);


--
-- Name: interview_type fk7mfybmk038d20fmgj4cole72c; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_type
    ADD CONSTRAINT fk7mfybmk038d20fmgj4cole72c FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: interview fk7r8wldm1uh3yxtj6pinmv1cds; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview
    ADD CONSTRAINT fk7r8wldm1uh3yxtj6pinmv1cds FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: interview_evaluation fk83ut75dsjvq7yurmn0d59ew8p; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation
    ADD CONSTRAINT fk83ut75dsjvq7yurmn0d59ew8p FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: candidate fk8qq2abjbqj1dm9xp2cwsssj9n; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate
    ADD CONSTRAINT fk8qq2abjbqj1dm9xp2cwsssj9n FOREIGN KEY (marital_status_id) REFERENCES dictionary_schema.marital_status(id);


--
-- Name: candidate_work_experience fk93ais2r6nllbu2pk2idjyjrbh; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_work_experience
    ADD CONSTRAINT fk93ais2r6nllbu2pk2idjyjrbh FOREIGN KEY (candidate_id) REFERENCES recruitment_schema.candidate(id);


--
-- Name: candidate fk9858c1xjs56ll9b4lsmivcm9c; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate
    ADD CONSTRAINT fk9858c1xjs56ll9b4lsmivcm9c FOREIGN KEY (nationality_id) REFERENCES employee_schema.category(id);


--
-- Name: interviewer fk9d43vav95k8labptb5f5e5e2c; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interviewer
    ADD CONSTRAINT fk9d43vav95k8labptb5f5e5e2c FOREIGN KEY (interview_evaluation_id) REFERENCES recruitment_schema.interview_evaluation(id);


--
-- Name: interview fk9l043jrxwm2cw2nxbqxk1vulf; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview
    ADD CONSTRAINT fk9l043jrxwm2cw2nxbqxk1vulf FOREIGN KEY (interview_type_id) REFERENCES recruitment_schema.interview_type(id);


--
-- Name: interview_evaluation_section fk9ntil18gdwn0ootgkm064912x; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_section
    ADD CONSTRAINT fk9ntil18gdwn0ootgkm064912x FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: candidate fka7tpd1o83s61ky0g0c8d3q5m7; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate
    ADD CONSTRAINT fka7tpd1o83s61ky0g0c8d3q5m7 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: candidate fkb6fx7vwnkdjg8mb8cnr31f3y9; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate
    ADD CONSTRAINT fkb6fx7vwnkdjg8mb8cnr31f3y9 FOREIGN KEY (nationality_id) REFERENCES dictionary_schema.nationality(id);


--
-- Name: duty fkbe7e8bq7oun80ojpgcgbm1863; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.duty
    ADD CONSTRAINT fkbe7e8bq7oun80ojpgcgbm1863 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: interviewer fkbla397qtjxlgbhpueta67osk0; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interviewer
    ADD CONSTRAINT fkbla397qtjxlgbhpueta67osk0 FOREIGN KEY (interview_id) REFERENCES recruitment_schema.interview(id);


--
-- Name: candidate_address fkbnmt1ufxb0y726ump4ttfgsd6; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_address
    ADD CONSTRAINT fkbnmt1ufxb0y726ump4ttfgsd6 FOREIGN KEY (id) REFERENCES location_schema.address(id);


--
-- Name: interview_evaluation_section fkc6a0b2534gcr8j2j5wm2hoj16; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_section
    ADD CONSTRAINT fkc6a0b2534gcr8j2j5wm2hoj16 FOREIGN KEY (interview_evaluation_id) REFERENCES recruitment_schema.interview_evaluation(id);


--
-- Name: interview_evaluation_question fkcte1ucfbb9hpujgv6bs5m7bsv; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_question
    ADD CONSTRAINT fkcte1ucfbb9hpujgv6bs5m7bsv FOREIGN KEY (interview_evaluation_section_id) REFERENCES recruitment_schema.interview_evaluation_section(id);


--
-- Name: interview_evaluation_section fkdyw8aducvgms4wgcjpbd3n5hy; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_section
    ADD CONSTRAINT fkdyw8aducvgms4wgcjpbd3n5hy FOREIGN KEY (parent_id) REFERENCES recruitment_schema.interview_evaluation_section(id);


--
-- Name: interviewee fke3xkt5saq6gksju122e0tch7h; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interviewee
    ADD CONSTRAINT fke3xkt5saq6gksju122e0tch7h FOREIGN KEY (candidate_id) REFERENCES recruitment_schema.candidate(id);


--
-- Name: interviewer fkej785e8f0yivx50xu8bgwpwgq; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interviewer
    ADD CONSTRAINT fkej785e8f0yivx50xu8bgwpwgq FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: skill fketvgi9xi8ywtau4ajqsafwjli; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.skill
    ADD CONSTRAINT fketvgi9xi8ywtau4ajqsafwjli FOREIGN KEY (vacancy_id) REFERENCES recruitment_schema.vacancy(id);


--
-- Name: vacancy fkf48sb61yr0bwkea2q5brcum23; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.vacancy
    ADD CONSTRAINT fkf48sb61yr0bwkea2q5brcum23 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: interview_evaluation fkfb4luj2r908uqxwarwk61p0x; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation
    ADD CONSTRAINT fkfb4luj2r908uqxwarwk61p0x FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: interview_evaluation fkfbg77obj7u5o9cuc62nk0lqpb; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation
    ADD CONSTRAINT fkfbg77obj7u5o9cuc62nk0lqpb FOREIGN KEY (reviewed_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: candidate_identification_document fkfr2xnc1hu773vy305aub7csxo; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_identification_document
    ADD CONSTRAINT fkfr2xnc1hu773vy305aub7csxo FOREIGN KEY (id) REFERENCES identification_schema.identification_document(id);


--
-- Name: vacancy fkgfrfgpwn1pk36j3i1ik67lu8y; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.vacancy
    ADD CONSTRAINT fkgfrfgpwn1pk36j3i1ik67lu8y FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: interviewee fkgpj3flxur881wrgbv15faa7ey; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interviewee
    ADD CONSTRAINT fkgpj3flxur881wrgbv15faa7ey FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: interviewer fkgquicn1pci524ikjdebudn58j; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interviewer
    ADD CONSTRAINT fkgquicn1pci524ikjdebudn58j FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: candidate_citizenship fkgskf1mqa9868hnmg8vthw2ca0; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_citizenship
    ADD CONSTRAINT fkgskf1mqa9868hnmg8vthw2ca0 FOREIGN KEY (id) REFERENCES citizenship_schema.citizenship(id);


--
-- Name: interviewee fkgxgohftaafug2u9prpyaxmysw; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interviewee
    ADD CONSTRAINT fkgxgohftaafug2u9prpyaxmysw FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: candidate_education fkhw87pfd8o09yvwivyfe3r5vep; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_education
    ADD CONSTRAINT fkhw87pfd8o09yvwivyfe3r5vep FOREIGN KEY (candidate_id) REFERENCES recruitment_schema.candidate(id);


--
-- Name: experience fkihcqf9h7ixwuv3qytcojqjban; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.experience
    ADD CONSTRAINT fkihcqf9h7ixwuv3qytcojqjban FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: candidate_resource fkjjtw4fegri7aac6s4ps8gc3j2; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_resource
    ADD CONSTRAINT fkjjtw4fegri7aac6s4ps8gc3j2 FOREIGN KEY (candidate_id) REFERENCES recruitment_schema.candidate(id);


--
-- Name: interview_type fkjmamlwrg2tv8fi74ctn302xxs; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_type
    ADD CONSTRAINT fkjmamlwrg2tv8fi74ctn302xxs FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: interviewee fkjxqkw7b2kpvoyw3mc59tqekrx; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interviewee
    ADD CONSTRAINT fkjxqkw7b2kpvoyw3mc59tqekrx FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: interview_evaluation_question fkkgun5deh39jfehfdnamfo4vdd; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_question
    ADD CONSTRAINT fkkgun5deh39jfehfdnamfo4vdd FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: duty fkkqjjvhwqugp4l6xb4ohw0pyiv; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.duty
    ADD CONSTRAINT fkkqjjvhwqugp4l6xb4ohw0pyiv FOREIGN KEY (vacancy_id) REFERENCES recruitment_schema.vacancy(id);


--
-- Name: candidate fkl3y9fhd8h6cy4c0y120c0j3hx; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate
    ADD CONSTRAINT fkl3y9fhd8h6cy4c0y120c0j3hx FOREIGN KEY (gender_id) REFERENCES dictionary_schema.gender(id);


--
-- Name: candidate_resource fkl5kt6pdi79jwvxjtc62kb89ri; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_resource
    ADD CONSTRAINT fkl5kt6pdi79jwvxjtc62kb89ri FOREIGN KEY (id) REFERENCES resource_schema.resource(id);


--
-- Name: interviewer fklbc4n6qvobstvypfyig7kjlpu; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interviewer
    ADD CONSTRAINT fklbc4n6qvobstvypfyig7kjlpu FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: candidate_resource_type fklnxmra0uu5gcbxjboiytx8syj; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_resource_type
    ADD CONSTRAINT fklnxmra0uu5gcbxjboiytx8syj FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: candidate_address fkmk95ujrhbelgtvn22uk96e3hs; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_address
    ADD CONSTRAINT fkmk95ujrhbelgtvn22uk96e3hs FOREIGN KEY (candidate_id) REFERENCES recruitment_schema.candidate(id);


--
-- Name: interview_evaluation_section fkmx31gcxx0ahoj5k1pt0e6okrw; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_section
    ADD CONSTRAINT fkmx31gcxx0ahoj5k1pt0e6okrw FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: skill fkn2ryquo3yn7r6uifypqia221h; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.skill
    ADD CONSTRAINT fkn2ryquo3yn7r6uifypqia221h FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: interview fknvejb31tcs8k0yhvv4eskd04k; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview
    ADD CONSTRAINT fknvejb31tcs8k0yhvv4eskd04k FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: candidate_military_service fko3cv6dlmp5pb6khlnmno0ed3b; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_military_service
    ADD CONSTRAINT fko3cv6dlmp5pb6khlnmno0ed3b FOREIGN KEY (candidate_id) REFERENCES recruitment_schema.candidate(id);


--
-- Name: interview_evaluation fko48fe8da59op2pe6sxb13ip8o; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation
    ADD CONSTRAINT fko48fe8da59op2pe6sxb13ip8o FOREIGN KEY (approved_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: interviewee fko9vt7v772vyke2j8k23v8bxke; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interviewee
    ADD CONSTRAINT fko9vt7v772vyke2j8k23v8bxke FOREIGN KEY (interview_id) REFERENCES recruitment_schema.interview(id);


--
-- Name: candidate_citizenship fkovkfrsv3e4uc0f4yctmc99gyu; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_citizenship
    ADD CONSTRAINT fkovkfrsv3e4uc0f4yctmc99gyu FOREIGN KEY (candidate_id) REFERENCES recruitment_schema.candidate(id);


--
-- Name: skill fkpe98orxyaphvln2312o0uhqa5; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.skill
    ADD CONSTRAINT fkpe98orxyaphvln2312o0uhqa5 FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: vacancy fkpnjacakc5yi7nanlwm1qsce8w; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.vacancy
    ADD CONSTRAINT fkpnjacakc5yi7nanlwm1qsce8w FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: candidate_identification_document fkptff4vpcw1wdvjuhcwd68t7eh; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_identification_document
    ADD CONSTRAINT fkptff4vpcw1wdvjuhcwd68t7eh FOREIGN KEY (candidate_id) REFERENCES recruitment_schema.candidate(id);


--
-- Name: experience fkq10t4hdjdqtan5am9l3bjpi2k; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.experience
    ADD CONSTRAINT fkq10t4hdjdqtan5am9l3bjpi2k FOREIGN KEY (vacancy_id) REFERENCES recruitment_schema.vacancy(id);


--
-- Name: interview_evaluation_question fkqdygprwrqqqu6r4ar1pdhil8x; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_question
    ADD CONSTRAINT fkqdygprwrqqqu6r4ar1pdhil8x FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: interview_evaluation_question fkqk81pfkix5om5h8kcift9ta07; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview_evaluation_question
    ADD CONSTRAINT fkqk81pfkix5om5h8kcift9ta07 FOREIGN KEY (question_type_id) REFERENCES testing_schema.question_type(id);


--
-- Name: candidate_contact fkr1lhfj7k3u8a2ls2g1vnmbxq0; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_contact
    ADD CONSTRAINT fkr1lhfj7k3u8a2ls2g1vnmbxq0 FOREIGN KEY (candidate_id) REFERENCES recruitment_schema.candidate(id);


--
-- Name: vacancy fkr9h5i5vkjj6mbdukayxcf1vr5; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.vacancy
    ADD CONSTRAINT fkr9h5i5vkjj6mbdukayxcf1vr5 FOREIGN KEY (organization_id) REFERENCES organization_schema.organization(id);


--
-- Name: candidate_work_experience fkrnpw9gjtcg7fci9wgn00meifm; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_work_experience
    ADD CONSTRAINT fkrnpw9gjtcg7fci9wgn00meifm FOREIGN KEY (id) REFERENCES employment_schema.work_experience(id);


--
-- Name: candidate_contact fkru03udupj8gl68n5igpkw7nkv; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_contact
    ADD CONSTRAINT fkru03udupj8gl68n5igpkw7nkv FOREIGN KEY (id) REFERENCES contact_schema.contact(id);


--
-- Name: candidate_resource_type fks4h14hx3lp6m6ig8nbtkianye; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_resource_type
    ADD CONSTRAINT fks4h14hx3lp6m6ig8nbtkianye FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: interview fksj1gb59aqdk26pj22mxql8c3l; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.interview
    ADD CONSTRAINT fksj1gb59aqdk26pj22mxql8c3l FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: candidate_resource fksvbyfiraa0gvelhw5n7d0jblo; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.candidate_resource
    ADD CONSTRAINT fksvbyfiraa0gvelhw5n7d0jblo FOREIGN KEY (candidate_resource_type_id) REFERENCES recruitment_schema.candidate_resource_type(id);


--
-- Name: duty fkxl10d3c04vvfx62aw7xul31j; Type: FK CONSTRAINT; Schema: recruitment_schema; Owner: fractal
--

ALTER TABLE ONLY recruitment_schema.duty
    ADD CONSTRAINT fkxl10d3c04vvfx62aw7xul31j FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: resource fke59fj9nq6jexsy60tx6jbed4w; Type: FK CONSTRAINT; Schema: resource_schema; Owner: fractal
--

ALTER TABLE ONLY resource_schema.resource
    ADD CONSTRAINT fke59fj9nq6jexsy60tx6jbed4w FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: resource fkrl5vfjisd7ysacg4niry6m6w; Type: FK CONSTRAINT; Schema: resource_schema; Owner: fractal
--

ALTER TABLE ONLY resource_schema.resource
    ADD CONSTRAINT fkrl5vfjisd7ysacg4niry6m6w FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: entity_state fk5ajb4wry6c88nid6mxxj9424v; Type: FK CONSTRAINT; Schema: state_schema; Owner: fractal
--

ALTER TABLE ONLY state_schema.entity_state
    ADD CONSTRAINT fk5ajb4wry6c88nid6mxxj9424v FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: entity_state fkbb60rv5kt5cgr2dll7nepy61v; Type: FK CONSTRAINT; Schema: state_schema; Owner: fractal
--

ALTER TABLE ONLY state_schema.entity_state
    ADD CONSTRAINT fkbb60rv5kt5cgr2dll7nepy61v FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: entity_state fkontagti85jl7b02rkm5qek6do; Type: FK CONSTRAINT; Schema: state_schema; Owner: fractal
--

ALTER TABLE ONLY state_schema.entity_state
    ADD CONSTRAINT fkontagti85jl7b02rkm5qek6do FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: notification fk3x921lcnkybqyh7pqeg9u2x7j; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.notification
    ADD CONSTRAINT fk3x921lcnkybqyh7pqeg9u2x7j FOREIGN KEY (notification_type_id) REFERENCES system_schema.notification_type(id);


--
-- Name: notification fk5tak5s7d8v964omfb11iogqun; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.notification
    ADD CONSTRAINT fk5tak5s7d8v964omfb11iogqun FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: message_type fk6qtcciph5mb452eafe7xwhb2m; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.message_type
    ADD CONSTRAINT fk6qtcciph5mb452eafe7xwhb2m FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: notification fk92legs77bpmt4090l2q1nrehl; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.notification
    ADD CONSTRAINT fk92legs77bpmt4090l2q1nrehl FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: service_provider fkbii4gvsfy4rbaqncor8eit6mf; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.service_provider
    ADD CONSTRAINT fkbii4gvsfy4rbaqncor8eit6mf FOREIGN KEY (service_provider_id) REFERENCES system_schema.service_provider_type(id);


--
-- Name: message fkcxya4b4pfe7f6fcevjygj9usd; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.message
    ADD CONSTRAINT fkcxya4b4pfe7f6fcevjygj9usd FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: service_provider_type fkcytew89nxg4retf1dmyr6yci6; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.service_provider_type
    ADD CONSTRAINT fkcytew89nxg4retf1dmyr6yci6 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: notification_type fkdlaywwgoe1cx6cwy48cmflw6c; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.notification_type
    ADD CONSTRAINT fkdlaywwgoe1cx6cwy48cmflw6c FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: notification fkeemmsu5f01d28gdskoj0w2po0; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.notification
    ADD CONSTRAINT fkeemmsu5f01d28gdskoj0w2po0 FOREIGN KEY (service_provider_id) REFERENCES system_schema.service_provider(id);


--
-- Name: message fkf2n7om2r7rytyj9cl1psd1fxu; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.message
    ADD CONSTRAINT fkf2n7om2r7rytyj9cl1psd1fxu FOREIGN KEY (language_id) REFERENCES localization_schema.language(id);


--
-- Name: message fkfd439ioq6ug3lbeu6noxe2cl4; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.message
    ADD CONSTRAINT fkfd439ioq6ug3lbeu6noxe2cl4 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: environment_variable fkgchh78lg5j2k412j78435323h; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.environment_variable
    ADD CONSTRAINT fkgchh78lg5j2k412j78435323h FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: service_provider fkhwogjfs1ng78am1yjqfgo5pmi; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.service_provider
    ADD CONSTRAINT fkhwogjfs1ng78am1yjqfgo5pmi FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: service_provider fkjdp7sbilroobq0t9mo4gl932w; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.service_provider
    ADD CONSTRAINT fkjdp7sbilroobq0t9mo4gl932w FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: message_type fkl3h5bgih5onu4mkc0h163jep0; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.message_type
    ADD CONSTRAINT fkl3h5bgih5onu4mkc0h163jep0 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: environment_variable fkm99wh0rrl3qt72tdk4yk0elqm; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.environment_variable
    ADD CONSTRAINT fkm99wh0rrl3qt72tdk4yk0elqm FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: notification_type fkoq2jwj37yaf9sthv0qdc3vvvv; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.notification_type
    ADD CONSTRAINT fkoq2jwj37yaf9sthv0qdc3vvvv FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: service_provider_type fkpy3awohqh1gu7gf2c6b9srqk6; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.service_provider_type
    ADD CONSTRAINT fkpy3awohqh1gu7gf2c6b9srqk6 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: message fkq249ulieu4wad09sq6geyo5fi; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.message
    ADD CONSTRAINT fkq249ulieu4wad09sq6geyo5fi FOREIGN KEY (message_type_id) REFERENCES system_schema.message_type(id);


--
-- Name: notification fkqe9350162wsyfwba7ypksptxy; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.notification
    ADD CONSTRAINT fkqe9350162wsyfwba7ypksptxy FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: service_provider fktru4vagqafrm2enw3ixkm49vx; Type: FK CONSTRAINT; Schema: system_schema; Owner: fractal
--

ALTER TABLE ONLY system_schema.service_provider
    ADD CONSTRAINT fktru4vagqafrm2enw3ixkm49vx FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: selected_answer fk1b7y734nqi4srwm6uwwwml4dg; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.selected_answer
    ADD CONSTRAINT fk1b7y734nqi4srwm6uwwwml4dg FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: selected_answer fk2cgt8o2m7fr4od0jfwu7p1qa0; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.selected_answer
    ADD CONSTRAINT fk2cgt8o2m7fr4od0jfwu7p1qa0 FOREIGN KEY (approved_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: selected_answer fk2qc8o3pvb1q7b73j5x24yp8m0; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.selected_answer
    ADD CONSTRAINT fk2qc8o3pvb1q7b73j5x24yp8m0 FOREIGN KEY (answer_submission_id) REFERENCES testing_schema.answer_submission(id);


--
-- Name: selected_answer fk3mr8c6i6jnnds1y2i1dyv4jht; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.selected_answer
    ADD CONSTRAINT fk3mr8c6i6jnnds1y2i1dyv4jht FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: test_session fk42kp884nu38qvylfkxa76evuj; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test_session
    ADD CONSTRAINT fk42kp884nu38qvylfkxa76evuj FOREIGN KEY (test_id) REFERENCES testing_schema.test(id);


--
-- Name: answer_submission fk4rol0t47bkou4mrostdxldjel; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.answer_submission
    ADD CONSTRAINT fk4rol0t47bkou4mrostdxldjel FOREIGN KEY (question_id) REFERENCES testing_schema.question(id);


--
-- Name: test fk5bb7ma72lj1fhp7x0jbb0peim; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test
    ADD CONSTRAINT fk5bb7ma72lj1fhp7x0jbb0peim FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: question fk5cike7u36rpj3o7melmsga9xo; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.question
    ADD CONSTRAINT fk5cike7u36rpj3o7melmsga9xo FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: answer_submission fk5drbo3r7nammrmj5xdynimfso; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.answer_submission
    ADD CONSTRAINT fk5drbo3r7nammrmj5xdynimfso FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: answer_submission fk5ryo4cllkcxwr664iv7r13dq0; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.answer_submission
    ADD CONSTRAINT fk5ryo4cllkcxwr664iv7r13dq0 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: question fk6e9te6j9nvngv9ndvrtt25kd; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.question
    ADD CONSTRAINT fk6e9te6j9nvngv9ndvrtt25kd FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: test fk6n9a04fkvgp72bc01354sa8cn; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test
    ADD CONSTRAINT fk6n9a04fkvgp72bc01354sa8cn FOREIGN KEY (reviewed_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: question fk7svspov4rexjawqdvi2jni81u; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.question
    ADD CONSTRAINT fk7svspov4rexjawqdvi2jni81u FOREIGN KEY (question_type_id) REFERENCES testing_schema.question_type(id);


--
-- Name: answer_submission fk873bn33h42yxrwbh95qeljv2o; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.answer_submission
    ADD CONSTRAINT fk873bn33h42yxrwbh95qeljv2o FOREIGN KEY (test_session_id) REFERENCES testing_schema.test_session(id);


--
-- Name: selectedAnswer fk8frr4bcabmmeyyu60qt7iiblo; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.selectedAnswer
    ADD CONSTRAINT fk8frr4bcabmmeyyu60qt7iiblo FOREIGN KEY (question_id) REFERENCES testing_schema.question(id);


--
-- Name: question fk8hejcpbbiq1qje11346akp3uj; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.question
    ADD CONSTRAINT fk8hejcpbbiq1qje11346akp3uj FOREIGN KEY (test_id) REFERENCES testing_schema.test(id);


--
-- Name: question fk9ypfwi38va5u5u22d95lc6rw7; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.question
    ADD CONSTRAINT fk9ypfwi38va5u5u22d95lc6rw7 FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: selectedAnswer fkbbuf3p3qngi2qtqu5n9civqgf; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.selectedAnswer
    ADD CONSTRAINT fkbbuf3p3qngi2qtqu5n9civqgf FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: test fkcfsqecxjr6vitg231cl4guck8; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test
    ADD CONSTRAINT fkcfsqecxjr6vitg231cl4guck8 FOREIGN KEY (approved_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: answer_submission fkd52kmu0cg4eeuxu1x3332m7bb; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.answer_submission
    ADD CONSTRAINT fkd52kmu0cg4eeuxu1x3332m7bb FOREIGN KEY (approved_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: test_session fkdrel5tjgjktri0qyo92bcb0s2; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test_session
    ADD CONSTRAINT fkdrel5tjgjktri0qyo92bcb0s2 FOREIGN KEY (reviewed_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: selectedAnswer fkdy3myy5le8pbhue6178c6swrn; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.selectedAnswer
    ADD CONSTRAINT fkdy3myy5le8pbhue6178c6swrn FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: test fkdy4veaakwulqxkm9ffbnivqa1; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test
    ADD CONSTRAINT fkdy4veaakwulqxkm9ffbnivqa1 FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: selected_answer fkekvxn39ai6od1i39vgtpko96j; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.selected_answer
    ADD CONSTRAINT fkekvxn39ai6od1i39vgtpko96j FOREIGN KEY (answer_id) REFERENCES testing_schema.selectedAnswer(id);


--
-- Name: answer_submission fkelbfxfjab82ywu83blabtjr8i; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.answer_submission
    ADD CONSTRAINT fkelbfxfjab82ywu83blabtjr8i FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: test fket9b55yu7wvongn1kcncwp9kp; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test
    ADD CONSTRAINT fket9b55yu7wvongn1kcncwp9kp FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: selected_answer fkgnuqu8ii6d63lp306s0s91yml; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.selected_answer
    ADD CONSTRAINT fkgnuqu8ii6d63lp306s0s91yml FOREIGN KEY (reviewed_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: question fkjnivhuqvrqq9f1wlss478gcay; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.question
    ADD CONSTRAINT fkjnivhuqvrqq9f1wlss478gcay FOREIGN KEY (question_type_id) REFERENCES location_schema.address_type(id);


--
-- Name: test_session fkkh1ht4vg34ydhaostpy3s521n; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test_session
    ADD CONSTRAINT fkkh1ht4vg34ydhaostpy3s521n FOREIGN KEY (user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: test_session fkkl4i44nynqodqm7kwb7pe06dy; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test_session
    ADD CONSTRAINT fkkl4i44nynqodqm7kwb7pe06dy FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: question_type fko0hkdkvvyoll4tntb0g9587oe; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.question_type
    ADD CONSTRAINT fko0hkdkvvyoll4tntb0g9587oe FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: test_session fkojxb34our7h79p4p5g9oy2w8v; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test_session
    ADD CONSTRAINT fkojxb34our7h79p4p5g9oy2w8v FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: answer_submission fkpmsj79uodj5e1drncvrnpvmd7; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.answer_submission
    ADD CONSTRAINT fkpmsj79uodj5e1drncvrnpvmd7 FOREIGN KEY (reviewed_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: test_session fkqgfs6dunmy1s4q65hxkgj1fmg; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test_session
    ADD CONSTRAINT fkqgfs6dunmy1s4q65hxkgj1fmg FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: question_type fkqxecsv1enfdpkxaf1bqapf4so; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.question_type
    ADD CONSTRAINT fkqxecsv1enfdpkxaf1bqapf4so FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: test_session fkv1av0fyndo6j3vbce6itxm31; Type: FK CONSTRAINT; Schema: testing_schema; Owner: fractal
--

ALTER TABLE ONLY testing_schema.test_session
    ADD CONSTRAINT fkv1av0fyndo6j3vbce6itxm31 FOREIGN KEY (approved_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: component fk6m4oc31hgyt35vpyof218b547; Type: FK CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.component
    ADD CONSTRAINT fk6m4oc31hgyt35vpyof218b547 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: component fkbvcb60qhl4mx348r3x82vcp71; Type: FK CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.component
    ADD CONSTRAINT fkbvcb60qhl4mx348r3x82vcp71 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: component_attributes fkevomwpha5r897dh41g76k3tnn; Type: FK CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.component_attributes
    ADD CONSTRAINT fkevomwpha5r897dh41g76k3tnn FOREIGN KEY (component_id) REFERENCES ui_schema.component(id);


--
-- Name: component_attributes fkghev9yiljhqvvg6umw7fcq2nv; Type: FK CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.component_attributes
    ADD CONSTRAINT fkghev9yiljhqvvg6umw7fcq2nv FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: attribute fkl32wh5igf8c2tjtdqblkhk7hp; Type: FK CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.attribute
    ADD CONSTRAINT fkl32wh5igf8c2tjtdqblkhk7hp FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: component_attributes fkmd5hwk9wc88fh0xnnttejbuv4; Type: FK CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.component_attributes
    ADD CONSTRAINT fkmd5hwk9wc88fh0xnnttejbuv4 FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: component_attributes fkmojp7mllnkkf91qiaq90dh33j; Type: FK CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.component_attributes
    ADD CONSTRAINT fkmojp7mllnkkf91qiaq90dh33j FOREIGN KEY (attribute_id) REFERENCES ui_schema.attribute(id);


--
-- Name: attribute fkn4964gqnapf8bvv0youyj7qf8; Type: FK CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.attribute
    ADD CONSTRAINT fkn4964gqnapf8bvv0youyj7qf8 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: component_attributes fkp5339s8lqrrmusc0bqlna84t4; Type: FK CONSTRAINT; Schema: ui_schema; Owner: fractal
--

ALTER TABLE ONLY ui_schema.component_attributes
    ADD CONSTRAINT fkp5339s8lqrrmusc0bqlna84t4 FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: authentication fk9xt16jflwvobkox5d9j9uesp3; Type: FK CONSTRAINT; Schema: user_schema; Owner: fractal
--

ALTER TABLE ONLY user_schema.authentication
    ADD CONSTRAINT fk9xt16jflwvobkox5d9j9uesp3 FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: profile fkae2yd89np7xx5kfphsq4osgkn; Type: FK CONSTRAINT; Schema: user_schema; Owner: fractal
--

ALTER TABLE ONLY user_schema.profile
    ADD CONSTRAINT fkae2yd89np7xx5kfphsq4osgkn FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: authentication fkaqx19vg6d80b0kfsds35mttui; Type: FK CONSTRAINT; Schema: user_schema; Owner: fractal
--

ALTER TABLE ONLY user_schema.authentication
    ADD CONSTRAINT fkaqx19vg6d80b0kfsds35mttui FOREIGN KEY (user_id) REFERENCES user_schema."user"(id);


--
-- Name: profile fkawh070wpue34wqvytjqr4hj5e; Type: FK CONSTRAINT; Schema: user_schema; Owner: fractal
--

ALTER TABLE ONLY user_schema.profile
    ADD CONSTRAINT fkawh070wpue34wqvytjqr4hj5e FOREIGN KEY (user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: profile fkdediqdt2rpmb5bicw7upyusjy; Type: FK CONSTRAINT; Schema: user_schema; Owner: fractal
--

ALTER TABLE ONLY user_schema.profile
    ADD CONSTRAINT fkdediqdt2rpmb5bicw7upyusjy FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: user fkhnncm3gx8plxt0kxg73vb9xdl; Type: FK CONSTRAINT; Schema: user_schema; Owner: fractal
--

ALTER TABLE ONLY user_schema."user"
    ADD CONSTRAINT fkhnncm3gx8plxt0kxg73vb9xdl FOREIGN KEY (created_user_id) REFERENCES user_schema."user"(id);


--
-- Name: profile fki5u47g47odeweeaug77ku10d; Type: FK CONSTRAINT; Schema: user_schema; Owner: fractal
--

ALTER TABLE ONLY user_schema.profile
    ADD CONSTRAINT fki5u47g47odeweeaug77ku10d FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: profile fkjqs063xycojkvoknskljcvpig; Type: FK CONSTRAINT; Schema: user_schema; Owner: fractal
--

ALTER TABLE ONLY user_schema.profile
    ADD CONSTRAINT fkjqs063xycojkvoknskljcvpig FOREIGN KEY (profile_attribute_id) REFERENCES dictionary_schema.profile_attribute(id);


--
-- Name: user fkpm7nbf6vwm8j4iooot5u2l2im; Type: FK CONSTRAINT; Schema: user_schema; Owner: fractal
--

ALTER TABLE ONLY user_schema."user"
    ADD CONSTRAINT fkpm7nbf6vwm8j4iooot5u2l2im FOREIGN KEY (updated_user_id) REFERENCES user_schema."user"(id);


--
-- Name: work_schedule fk9hbbg1ay81q4wvp9htnwk1sq7; Type: FK CONSTRAINT; Schema: work_schedule_schema; Owner: fractal
--

ALTER TABLE ONLY work_schedule_schema.work_schedule
    ADD CONSTRAINT fk9hbbg1ay81q4wvp9htnwk1sq7 FOREIGN KEY (updated_user_id) REFERENCES authorization_schema."user"(id);


--
-- Name: work_schedule fkgs7xosqe71roi8nmh14u7jh2k; Type: FK CONSTRAINT; Schema: work_schedule_schema; Owner: fractal
--

ALTER TABLE ONLY work_schedule_schema.work_schedule
    ADD CONSTRAINT fkgs7xosqe71roi8nmh14u7jh2k FOREIGN KEY (status_id) REFERENCES dictionary_schema.status(id);


--
-- Name: work_schedule fkobkvrmvmt3b6y4g9thmilankm; Type: FK CONSTRAINT; Schema: work_schedule_schema; Owner: fractal
--

ALTER TABLE ONLY work_schedule_schema.work_schedule
    ADD CONSTRAINT fkobkvrmvmt3b6y4g9thmilankm FOREIGN KEY (week_day_id) REFERENCES dictionary_schema.week_day(id);


--
-- Name: work_schedule fkofddl68hnstvtu6mt59b3o21y; Type: FK CONSTRAINT; Schema: work_schedule_schema; Owner: fractal
--

ALTER TABLE ONLY work_schedule_schema.work_schedule
    ADD CONSTRAINT fkofddl68hnstvtu6mt59b3o21y FOREIGN KEY (created_user_id) REFERENCES authorization_schema."user"(id);


--
-- PostgreSQL database dump complete
--

