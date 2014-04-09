﻿--
-- Name: recipes; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE recipes (
    id integer PRIMARY KEY,
    title character varying(100) NOT NULL,
    description character varying(255) NOT NULL,
    content text NOT NULL,
    preparation_endurance integer NOT NULL,
    total_endurance integer NOT NULL,
    creation timestamp without time zone NOT NULL
);


ALTER TABLE public.recipes OWNER TO username;

--
-- Add sequence and user rights for id increment
--
CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 100000;
  
grant usage on sequence hibernate_sequence to username;

create table images (
  id		integer primary key,
  path		varchar(255) not null,
  description		varchar(255) not null,
  recipe_id	integer,
  foreign key (recipe_id) references recipes (id)
);

grant select,insert,update,delete on images to username;

--
-- Data for Name: recipes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (1, 'K�se - Lauch - Suppe mit Lachs', 'schmeckt wonach es klingt', '<b>

200 g 	Kartoffel(n)<br>

250 g 	Porree<br>

1  	Zwiebel(n)<br>

25 g 	Butter<br>

500 ml 	H�hnerbr�he<br>

200 g 	Schmelzk�se<br>

100 g 	Lachs, ger�ucherter<br>

4 EL 	Cr�me fra�che<br>

  	Salz und Pfeffer <br>

</b><br><br><br>

Die Kartoffeln sch�len, waschen und w�rfeln. Den Porree abbrausen, putzen und in Ringe schneiden. Die Zwiebeln sch�len und fein w�rfeln.<br>

<br>

Butter in einem Topf erhitzen und alles darin anbraten. Br�he angie�en, kurz aufkochen lassen und bei mittlerer Hitze etwa 20 Minuten k�cheln lassen. Die Suppe mit dem Mixstab p�rieren. Den Schmelzk�se hineingeben und unter R�hren nochmals erhitzen. Mit Salz und Pfeffer abschmecken.<br>



Den Lachs in Streifen schneiden. Die Suppe in Tellern anrichten und in die Mitte jeweils einen EL Cr�me fra�che geben und die Lachsstreifen hinzuf�gen. ', 30, 60, '2013-12-10 09:20:42.313');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (0, 'Kartoffelauflauf', 'einfacher leckerer Auflauf', '<b>500gr Kartoffeln</b><br><br><br>Die Kartoffeln kochen, pellen und in gleichm��ige Scheiben schneiden. Die Auflaufform mit der Knoblauchzehe einreiben und anschlie�end mit der Butter einfetten. <br>

Den Rest der Zehe in kleine St�cke hacken und zusammen mit den Zwiebelringen in einer Pfanne anbraten. Die Kartoffelscheiben, die Zwiebeln und den K�se abwechselnd aufschichten und mit Salz und Pfeffer nach jeder Schicht w�rzen. Mit K�se abschlie�en, Sahne und Kr�uter vermengen und �ber das Gratin geben. Den Auflauf 20-30 Minuten im vorgeheizten Backofen bei 170 Grad �berbacken.

<br>

Dazu passen Bratw�rstchen oder man f�gt noch eine Schicht Thunfisch hinzu. Durchgezogen schmeckt das Gratin noch besser. <br>', 35, 45, '2013-12-10 09:15:23.974');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (2, 'Echte Gulaschsuppe', 'herzhafte Gulaschsuppe - ungarisch', '<b>

12  	Zwiebel(n)<br>

500 g 	Rindfleisch<br>

1 Liter 	Fleischbr�he<br>

100 g 	Schweineschmalz<br>

1 EL 	Paprikapulver, scharf<br>

2 EL 	Paprikapulver, edels�ss<br>

1 TL 	K�mmel, zerstossen<br>

1/2 TL 	Majoran, gerebbelt<br>

1 TL 	Salz<br>

2  	Kartoffel(n), gesch�lt und gew�rfelt<br>

2  	Paprikaschote(n), gr�n, enth�utet, in Streifen geschnitten<br>

4  	Tomate(n), gesch�lt und gew�rfelt<br>

1 Zehe/n 	Knoblauch, gepresst<br>

100 ml 	Wein, rot<br>

  	saure Sahne <br>

</b>

<br><br><br>

Die Zwiebel sch�len und in W�rfel schneiden. Das Fleisch in kleine W�rfel schneiden und dabei alle Sehnen und H�utchen entfernen. Das Schmalz im Topf zerlassen und die Zwiebelw�rfel darin von allen Seiten goldbraun anbraten. Die Fleischw�rfel zugeben und 5 Min. unter st�ndigem Umwenden im Fett r�sten.

Das Paprikapulver, K�mmel, Majoran und das Salz zugeben, mit der Fleischbr�he auff�llen und alles 1 Std. zugedeckt bei milder Hitze garen. Die Kartoffelw�rfel, die Paprikastreifen und die Tomatenw�rfel mit dem Knoblauch in die Suppe r�hren und weitere

25 Min. kochen lassen. Die Suppe vom Herd nehmen und den Rotwein darunter r�hren. Mit einem Klecks saurer Sahne servieren.', 30, 90, '2013-12-10 14:44:59.541');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (3, 'Feine Linsensuppe', 'Linsensuppe mit Gem&uuml;se', '<b>

200 g 	Linsen (braune Champagne-Linsen)<br>

300 g 	Kartoffel(n)<br>

100 g 	M�hre(n)<br>

100 g 	Knollensellerie<br>

100 g 	Lauch<br>

500 ml 	Gem�sebr�he<br>

500 ml 	Rinderbr�he<br>

1 EL 	Butter<br>

3 EL 	Balsamico bianco<br>

  	Petersilie, glatte oder Schnittlauch <br></b>

<br><br><br>

 M�hre, Sellerie und Lauch in klitzekleine W�rfel schneiden. Kartoffeln in W�rfel mit einer Kantenl�nge nicht �ber 5 mm schneiden.<br>

Linsen waschen, abtropfen lassen und mit der Gem�sebr�he 30 Minuten k�cheln lassen.<br>

<br>

In einem zweiten Topf die Butter schmelzen und das Gem�se mit den Kartoffeln kurz anschwitzen. Mit der Rinderbr�he abl�schen und 5 Minuten k�cheln lassen. Die Linsen dazugeben und alles gut mischen. Mit dem Essig abschmecken.<br>

<br>

Petersilie oder Schnittlauch fein hacken und die gef�llten Teller damit garnieren.<br>

<br>

Dies ist eine feine Variante f�r den Wochenanfang, wenn man am Wochenende viel Fleisch verzehrt hat.<br>

<br>

Deftiger, aber auch kalorienreicher wird die Suppe durch Zugabe von klein geschnittenem Bauchspeck oder ger�ucherten Mettenden.<br>

			<br>', 50, 20, '2013-12-10 14:51:57.149');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (4, 'Mokka-Cupcakes', 'schokoladiges Backvergn&uuml;gen', '<b>

F�r den Teig:<br>

250 g 	Mehl<br>

50 g 	Kakaopulver<br>

50 g 	Zucker, brauner<br>

100 g 	Zucker<br>

1 EL 	Backpulver<br>

5 EL 	Kaffeepulver, (Espressopulver), instant<br>

1/2 TL 	Salz<br>

100 g 	Butter<br>

250 g 	saure Sahne<br>

200 g 	Sahne<br>

2  	Ei(er)<br>

150 g 	Kuvert�re, (Zartbitterkuvert�re), gehackt<br>

<br>

  	F�r die Creme:<br>

400 g 	Puderzucker<br>

250 g 	Kuvert�re, (Zartbitterkuvert�re)<br>

125 g 	Butter<br>

80 g 	Sahne, bei Bedarf mehr<br>

 etwas 	Salz<br>

<br>

  	F�r die Dekoration: (optional)<br>

 etwas 	Kakaopulver<br>

 etwas 	Puderzucker<br>

 n. B. 	Schokolade, (Mokkabohnen) <br>

</b><br><br><br>

Den Ofen auf 200�C vorheizen.<br>

<br>

F�r den Teig Mehl, Kakao, Zucker, Backpulver, Kaffeepulver und Salz in einer Sch�ssel mischen. Die Butter zerlassen und mit der Sahne und den Eiern cremig schlagen. Anschlie�end unter die trockenen Zutaten r�hren. Zum Schluss die gehackte Zartbitterschokolade unterheben.<br>

<br>

Muffinformen zu 2/3 mit Teig f�llen und 20-25 Minuten im vorgeheizten Ofen backen.<br>



F�r die Creme die Butter zusammen mit 200g Kuvert�re schmelzen und kurz abk�hlen lassen. Die restlichen 50g ebenfalls schmelzen und anschlie�end unterr�hren. Sahne und Salz unterr�hren und in eine Sch�ssel mit dem Puderzucker geben. Die Masse glatt r�hren und ggf. noch Sahne hinzuf�gen. Die Creme mit einem Spritzbeutel auf die abgek�hlten Muffins auftragen und nach Belieben dekorieren. ', 35, 60, '2013-12-10 14:56:01.419');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (5, 'Russischer Hackfleischtopf', 'Hackfleisch-Eintopf der einfachen Art', '<b>

2 gro�e 	Zwiebel(n)<br>

1 EL 	�l<br>

1 EL 	Butter<br>

500 g 	Gehacktes (Rind)<br>

1 Stange/n 	Porree<br>

5 EL 	Tomate(n) - P�ree<br>

250 ml 	Br�he<br>

1 EL 	Senf<br>

1 TL 	Paprikapulver, mild<br>

1 TL 	Salz<br>

250 ml 	saure Sahne <br>

</b><br><br><br>

Die gehackten Zwiebeln kurz in �l und Butter in einem Brattopf d�nsten. Dann die Hitze erh�hen, das Hackfleisch in den Topf geben und mit einer Holzgabel r�hren, bis das Fleisch leicht braun ist.<br>

Bei schwacher Hitze den geputzten, in Streifen geschnittenen Lauch, Tomatenp�ree, Bouillon, Senf und Gew�rze nach Geschmack zugeben.<br>

Etwa 15 Minuten bei schwacher Hitze d�nsten, h�ufig umr�hren. Die saure Sahne kurz vor dem Servieren dar�ber gie�en. Hei� servieren mit gekochten Nudeln oder Reis.<br>

<br>

<b>Tipp:</b> Gut geeignet zum Einfrieren: Saure Sahne erst nach dem Auftauen und Erw�rmen zugeben.<br>

<br>

Getr�nkevorschlag: Bier, Rotwein-Schorle, Joghurt-Mixgetr�nk ', 15, 30, '2013-12-10 14:58:35.243');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (6, 'Gef�llte Paprika', 'ungarisches Rezept', '<b>

10  	Paprikaschote(n) (Spitzpaprika), gelbe, je nach Gr��e evtl. mehr<br>

500 g 	Hackfleisch, gemischt<br>

1  	Zwiebel(n)<br>

1 Zehe/n 	Knoblauch<br>

  	Salz und Pfeffer, schwarzer aus der M�hle<br>

  	Paprikapulver<br>

100 g 	Reis, gekochter<br>

1  	Ei(er)<br>

1 kl. Dose/n 	Tomatenmark<br>

500 ml 	Gem�sebr�he<br>

 etwas 	Zucker<br>

1 EL 	Butter<br>

1 EL 	Mehl <br>

</b><br><br><br>

Aus Hackfleisch, Reis, Ei, Zwiebel und Knoblauch einen Hackfleischteig herstellen und mit den Gew�rzen abschmecken. In die Paprikaschoten f�llen und aus dem Rest Hackfleischb�llchen formen. Die Butter in einem Topf schmelzen, das Mehl dazugeben und etwas anr�sten. Mit Gem�sebr�he abl�schen, das Tomatenmark dazugeben und aufkochen lassen. Mit Salz, Pfeffer und etwas Zucker abschmecken. Die gef�llten Paprikaschoten und die B�llchen in die So�e geben und entweder auf dem Herd oder im Backofen 30-40 min schmoren lassen.<br>

Dazu gibt es Reis. Alternativ kann man auch Tomatenp�ree statt des Tomatenmarks verwenden. Dann etwas weniger Br�he verwenden.<br>

Die Mengenangaben sind nat�rlich etwas vage, meine Uri hat immer "nach Gef�hl" gekocht. Ich habe versucht, das Rezept so gut wie m�glich nachzuvollziehen!<br>', 40, 70, '2013-12-10 15:02:21.894');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (7, 'Omas Kohlrouladen', 'schmeckt wie fr&uuml;her', '<b>

1  	Wirsing oder Wei�kohl)<br>

500 g 	Hackfleisch, gemischt<br>

1  	Zwiebel(n)<br>

1  	Br�tchen, altbacken<br>

1  	Ei(er)<br>

100 g 	Speck, gew�rfelt<br>

500 ml 	Br�he<br>

200 ml 	Sahne<br>

  	Salz und Pfeffer<br>

1 EL 	Senf, evtl. mehr<br>

  	Paprikapulver, scharf<br>

  	Majoran <br>

</b>

<br><br><br>

Acht sch�ne Bl�tter vom Kohl abl�sen und blanchieren. In Eiswasser abschrecken und mit einem K�chentuch etwas trocknen. Den Hackfleischteig wie folgt zubereiten: hinein geh�rt ein Ei, ein eingeweichtes und ausgedr�cktes Br�tchen, 1-2 EL Senf, eine fein gew�rfelte Zwiebel, ordentlich Salz, Pfeffer und scharfes Paprikapulver. Zum Schluss nach Belieben noch getrockneten Majoran hineinstreuen. Das Ganze vermengen. Kleine H�ufchen auf die ausgelegten Kohlbl�tter verteilen, zusammenrollen und mit einem K�chengarn zusammenbinden. Die Kohlrouladen in einer hohen Pfanne anbraten, sodass sie Farbe bekommen. Dabei auch einige Speckw�rfel mit auslassen. Haben die Kohlrouladen etwas Farbe angenommen, das Ganze mit gek�rnter Br�he aufgie�en. Zugedeckt eine halbe Stunde schmoren lassen. Zum Schluss die Rouladen herausnehmen und die Fl�ssigkeit mit Sahne aufgie�en, etwas einkochen lassen oder evtl. leicht abbinden. Das Ganze mit wenig Salz und Pfeffer abschmecken und die So�e zu den Kohlrouladen servieren. ', 50, 70, '2013-12-10 15:03:36.618');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (8, 'Lasagne', 'wie beim Italiener', '<b>

500 g 	Hackfleisch<br>

1  	Zwiebel(n)<br>

2  	Knoblauchzehe(n)<br>

1 Bund 	Petersilie oder TK<br>

1 EL 	Tomatenmark<br>

1 Dose 	Tomate(n), gesch�lte<br>

1/2 Liter 	Milch<br>

30 g 	Butter<br>

40 g 	Mehl<br>

  	Salz und Pfeffer<br>

  	Oliven�l<br>

300 g 	Lasagneplatte(n)<br>

  	Muskat<br>

  	Wein, rot<br>

  	K�se, gerieben<br>

  	Butter, in Fl�ckchen <br>

</b><br><br><br>

Ragout Bolognese:<br>

In einem Topf das Oliven�l erhitzen, das Hackfleisch darin rundherum anbraten und die gehackten Zwiebeln und die Petersilie dazugeben. Knoblauchscheiben und Tomatenmark dazu r�hren und mitbraten. Mit den Dosentomaten aufgie�en, salzen und pfeffern. Rotwein nach Belieben beif�gen. Das Ragout mindestens eine halbe Stunde lang bei ge�ffnetem Topf einkochen lassen.<br>

<br>

Bechamelsauce:<br>

Butter in einem kleinen Topf schmelzen und das Mehl mit dem Schneebesen dazuarbeiten. Die Milch nun dazugie�en und die Sauce glatt r�hren. Wer zu langsam ger�hrt hat und Kl�mpchen in der Sauce findet, kann die Sauce durch ein feines Haarsieb passieren und dann weiterkochen lassen. Die Sauce sollte fast eine halbe Stunde lang auf kleiner Flamme k�cheln, damit sie den Mehlgeschmack verliert. Mit Salz, Pfeffer und Zitronensaft sowie etwas Muskatnuss abschmecken.<br>

<br>

Zubereitung der Lasagne:<br>

In einer gebutterten, feuerfesten Form etwas Ragout bolognese verteilen, eine Schicht Lasagnenudeln darauf legen, die Nudelschicht wieder mit Ragu und dann mit einer Bechamelsaucenschicht bedecken. Anschlie�end wieder eine Schicht Nudeln, Ragu und Bechamel. So Schicht f�r Schicht die Form f�llen.<br>

Die letzte Schicht sollte die Bechamelsauce bilden. Dick mit geriebenen K�se bestreuen, Butterfl�ckchen darauf setzen . Die Lasagne bei 180�C im Ofen �berbacken, bis die Kruste goldbraun ist.<br>

<br>

Die Lasagne kann man auch gut einen Tag vorher vorbereiten und im K�hlschrank ziehen lassen!<br>

<br>

Empfehlung Vorspeise: Honigmelone mit Parmaschinken<br>

Empfehlung Nachspeise: Beerenmix an Quark-Joghurt-Sahne-Creme mit brauner Zuckerkruste! <br>', 60, 100, '2013-12-10 15:06:24.42');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (9, 'Gnocchi Auflauf', 'Mix aus Auflauf, Nudeln und Kl&ouml;se', '<b>

200 g 	Schinken, gekochter, gew�rfelt<br>

300 g 	Champignons, kleine aus der Dose, halbiert<br>

250 g 	Kirschtomate(n), m�glichst fest, halbiert<br>

1  	Zwiebel(n), gew�rfelt<br>

3  	Knoblauchzehe(n), gepresst<br>

3 EL 	�l<br>

3 EL 	Tomatenmark<br>

1 EL 	Mehl<br>

400 g 	Sahne<br>

1000 g 	Gnocchi, (aus der K�hltheke)<br>

  	Fett, f�r die Auflaufform<br>

200 g 	Mozzarella, gew�rfelt<br>

200 g 	K�se (Gouda), gerieben<br>

1 EL 	Kr�uter, italienische , z.B. gefroren<br>

  	Salz und Pfeffer, nach Geschmack <br>

</b>

<br><br><br>

Die Tomaten in 1 El hei�em �l kurz anbraten. Mit Salz und Pfeffer w�rzen, herausnehmen und kurz beiseite stellen.<br>

2 EL �l in der gleichen Pfanne erhitzen und die Zwiebel mit dem Knoblauch glasig d�nsten.<br>

Die Pilze dazugeben und anbraten. Dann den Schinken zugeben und kurz mitbraten.<br>

Das Tomatenmark hineingeben und kurz anr�sten, damit sich das Tomatenaroma besser entfalten kann. Das Mehl dr�ber streuen, kurz verr�hren und anschwitzen.<br>

Anschlie�end mit der Sahne abl�schen. Nun die Kr�uter untermischen und das ganze ca. 5 Minuten leicht k�cheln lassen.<br>

Tomatenh�lften wieder zugeben und mit Salz und Pfeffer abschmecken.<br>

<br>

Gnocchi nach Packungsanleitung garen, abtropfen und in die gro�e gefettete Auflaufform geben. Die Tomaten-Sahne-Sauce dar�ber gie�en.<br>

Nun die Mozzarella-W�rfel dar�ber streuen, anschlie�end den geriebenen Gouda dar�ber verteilen.<br>

<br>

Nun f�r 20-30 Minuten bei 200� C im vorgeheizten Ofen �berbacken.<br>



Um das ganze Essen kalorientechnisch zu entsch�rfen, bin ich auf Milch mit 1 Becher Creme leger statt Sahne und bei den K�sesorten auf Light-Produkte ausgewichen ', 30, 80, '2013-12-10 15:10:04.667');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (10, 'Tortellini alla panna', 'Schinken-Sahnesauce wie beim Italiener', '<b>

500 g 	Tortellini, aus dem Frischeregal<br>

600 ml 	Sahne<br>

200 g 	Schinken, gekochter, gew�rfelt<br>

2  	Eigelb<br>

4 EL 	Parmesan, frisch geriebener<br>

1 TL 	Muskat<br>

1 TL 	Salz<br>

1 EL 	Butter <br>

</b><br><br><br>

Die Tortellinis nach Packungsanweisung kochen.<br>

Den gekochten Schinken in einer tiefen Pfanne mit Butter kurz anbraten, dann 400ml von der Sahne hineingeben und auf kleiner Stufe k�cheln lassen. Wenn die Tortellini gar sind, in die Pfanne zur Schinkensahne geben und weiter k�cheln lassen.<br>

In der Zwischenzeit in einer kleinen Sch�ssel das Eigelb, den Parmesan, Muskatnuss, Salz und die restliche 200 ml Sahne verr�hren, dann in die Pfanne zu den Tortellinis geben und so lange k�cheln lassen, bis die So�e dickfl�ssig wird. Sofort servieren.<br>

Sehr gehaltvoll, aber der Geschmack ist fantastisch. Ab und zu kann man sich�s mal g�nnen. <br>', 20, 30, '2013-12-10 15:11:45.826');



