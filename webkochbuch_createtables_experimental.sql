--
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

INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (1, 'Käse - Lauch - Suppe mit Lachs', 'schmeckt wonach es klingt', '<b>

200 g 	Kartoffel(n)<br>

250 g 	Porree<br>

1  	Zwiebel(n)<br>

25 g 	Butter<br>

500 ml 	Hühnerbrühe<br>

200 g 	Schmelzkäse<br>

100 g 	Lachs, geräucherter<br>

4 EL 	Crème fraîche<br>

  	Salz und Pfeffer <br>

</b><br><br><br>

Die Kartoffeln schälen, waschen und würfeln. Den Porree abbrausen, putzen und in Ringe schneiden. Die Zwiebeln schälen und fein würfeln.<br>

<br>

Butter in einem Topf erhitzen und alles darin anbraten. Brühe angießen, kurz aufkochen lassen und bei mittlerer Hitze etwa 20 Minuten köcheln lassen. Die Suppe mit dem Mixstab pürieren. Den Schmelzkäse hineingeben und unter Rühren nochmals erhitzen. Mit Salz und Pfeffer abschmecken.<br>



Den Lachs in Streifen schneiden. Die Suppe in Tellern anrichten und in die Mitte jeweils einen EL Crème fraîche geben und die Lachsstreifen hinzufügen. ', 30, 60, '2013-12-10 09:20:42.313');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (0, 'Kartoffelauflauf', 'einfacher leckerer Auflauf', '<b>500gr Kartoffeln</b><br><br><br>Die Kartoffeln kochen, pellen und in gleichmäßige Scheiben schneiden. Die Auflaufform mit der Knoblauchzehe einreiben und anschließend mit der Butter einfetten. <br>

Den Rest der Zehe in kleine Stücke hacken und zusammen mit den Zwiebelringen in einer Pfanne anbraten. Die Kartoffelscheiben, die Zwiebeln und den Käse abwechselnd aufschichten und mit Salz und Pfeffer nach jeder Schicht würzen. Mit Käse abschließen, Sahne und Kräuter vermengen und über das Gratin geben. Den Auflauf 20-30 Minuten im vorgeheizten Backofen bei 170 Grad überbacken.

<br>

Dazu passen Bratwürstchen oder man fügt noch eine Schicht Thunfisch hinzu. Durchgezogen schmeckt das Gratin noch besser. <br>', 35, 45, '2013-12-10 09:15:23.974');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (2, 'Echte Gulaschsuppe', 'herzhafte Gulaschsuppe - ungarisch', '<b>

12  	Zwiebel(n)<br>

500 g 	Rindfleisch<br>

1 Liter 	Fleischbrühe<br>

100 g 	Schweineschmalz<br>

1 EL 	Paprikapulver, scharf<br>

2 EL 	Paprikapulver, edelsüss<br>

1 TL 	Kümmel, zerstossen<br>

1/2 TL 	Majoran, gerebbelt<br>

1 TL 	Salz<br>

2  	Kartoffel(n), geschält und gewürfelt<br>

2  	Paprikaschote(n), grün, enthäutet, in Streifen geschnitten<br>

4  	Tomate(n), geschält und gewürfelt<br>

1 Zehe/n 	Knoblauch, gepresst<br>

100 ml 	Wein, rot<br>

  	saure Sahne <br>

</b>

<br><br><br>

Die Zwiebel schälen und in Würfel schneiden. Das Fleisch in kleine Würfel schneiden und dabei alle Sehnen und Häutchen entfernen. Das Schmalz im Topf zerlassen und die Zwiebelwürfel darin von allen Seiten goldbraun anbraten. Die Fleischwürfel zugeben und 5 Min. unter ständigem Umwenden im Fett rösten.

Das Paprikapulver, Kümmel, Majoran und das Salz zugeben, mit der Fleischbrühe auffüllen und alles 1 Std. zugedeckt bei milder Hitze garen. Die Kartoffelwürfel, die Paprikastreifen und die Tomatenwürfel mit dem Knoblauch in die Suppe rühren und weitere

25 Min. kochen lassen. Die Suppe vom Herd nehmen und den Rotwein darunter rühren. Mit einem Klecks saurer Sahne servieren.', 30, 90, '2013-12-10 14:44:59.541');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (3, 'Feine Linsensuppe', 'Linsensuppe mit Gem&uuml;se', '<b>

200 g 	Linsen (braune Champagne-Linsen)<br>

300 g 	Kartoffel(n)<br>

100 g 	Möhre(n)<br>

100 g 	Knollensellerie<br>

100 g 	Lauch<br>

500 ml 	Gemüsebrühe<br>

500 ml 	Rinderbrühe<br>

1 EL 	Butter<br>

3 EL 	Balsamico bianco<br>

  	Petersilie, glatte oder Schnittlauch <br></b>

<br><br><br>

 Möhre, Sellerie und Lauch in klitzekleine Würfel schneiden. Kartoffeln in Würfel mit einer Kantenlänge nicht über 5 mm schneiden.<br>

Linsen waschen, abtropfen lassen und mit der Gemüsebrühe 30 Minuten köcheln lassen.<br>

<br>

In einem zweiten Topf die Butter schmelzen und das Gemüse mit den Kartoffeln kurz anschwitzen. Mit der Rinderbrühe ablöschen und 5 Minuten köcheln lassen. Die Linsen dazugeben und alles gut mischen. Mit dem Essig abschmecken.<br>

<br>

Petersilie oder Schnittlauch fein hacken und die gefüllten Teller damit garnieren.<br>

<br>

Dies ist eine feine Variante für den Wochenanfang, wenn man am Wochenende viel Fleisch verzehrt hat.<br>

<br>

Deftiger, aber auch kalorienreicher wird die Suppe durch Zugabe von klein geschnittenem Bauchspeck oder geräucherten Mettenden.<br>

			<br>', 50, 20, '2013-12-10 14:51:57.149');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (4, 'Mokka-Cupcakes', 'schokoladiges Backvergn&uuml;gen', '<b>

Für den Teig:<br>

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

150 g 	Kuvertüre, (Zartbitterkuvertüre), gehackt<br>

<br>

  	Für die Creme:<br>

400 g 	Puderzucker<br>

250 g 	Kuvertüre, (Zartbitterkuvertüre)<br>

125 g 	Butter<br>

80 g 	Sahne, bei Bedarf mehr<br>

 etwas 	Salz<br>

<br>

  	Für die Dekoration: (optional)<br>

 etwas 	Kakaopulver<br>

 etwas 	Puderzucker<br>

 n. B. 	Schokolade, (Mokkabohnen) <br>

</b><br><br><br>

Den Ofen auf 200°C vorheizen.<br>

<br>

Für den Teig Mehl, Kakao, Zucker, Backpulver, Kaffeepulver und Salz in einer Schüssel mischen. Die Butter zerlassen und mit der Sahne und den Eiern cremig schlagen. Anschließend unter die trockenen Zutaten rühren. Zum Schluss die gehackte Zartbitterschokolade unterheben.<br>

<br>

Muffinformen zu 2/3 mit Teig füllen und 20-25 Minuten im vorgeheizten Ofen backen.<br>



Für die Creme die Butter zusammen mit 200g Kuvertüre schmelzen und kurz abkühlen lassen. Die restlichen 50g ebenfalls schmelzen und anschließend unterrühren. Sahne und Salz unterrühren und in eine Schüssel mit dem Puderzucker geben. Die Masse glatt rühren und ggf. noch Sahne hinzufügen. Die Creme mit einem Spritzbeutel auf die abgekühlten Muffins auftragen und nach Belieben dekorieren. ', 35, 60, '2013-12-10 14:56:01.419');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (5, 'Russischer Hackfleischtopf', 'Hackfleisch-Eintopf der einfachen Art', '<b>

2 große 	Zwiebel(n)<br>

1 EL 	Öl<br>

1 EL 	Butter<br>

500 g 	Gehacktes (Rind)<br>

1 Stange/n 	Porree<br>

5 EL 	Tomate(n) - Püree<br>

250 ml 	Brühe<br>

1 EL 	Senf<br>

1 TL 	Paprikapulver, mild<br>

1 TL 	Salz<br>

250 ml 	saure Sahne <br>

</b><br><br><br>

Die gehackten Zwiebeln kurz in Öl und Butter in einem Brattopf dünsten. Dann die Hitze erhöhen, das Hackfleisch in den Topf geben und mit einer Holzgabel rühren, bis das Fleisch leicht braun ist.<br>

Bei schwacher Hitze den geputzten, in Streifen geschnittenen Lauch, Tomatenpüree, Bouillon, Senf und Gewürze nach Geschmack zugeben.<br>

Etwa 15 Minuten bei schwacher Hitze dünsten, häufig umrühren. Die saure Sahne kurz vor dem Servieren darüber gießen. Heiß servieren mit gekochten Nudeln oder Reis.<br>

<br>

<b>Tipp:</b> Gut geeignet zum Einfrieren: Saure Sahne erst nach dem Auftauen und Erwärmen zugeben.<br>

<br>

Getränkevorschlag: Bier, Rotwein-Schorle, Joghurt-Mixgetränk ', 15, 30, '2013-12-10 14:58:35.243');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (6, 'Gefüllte Paprika', 'ungarisches Rezept', '<b>

10  	Paprikaschote(n) (Spitzpaprika), gelbe, je nach Größe evtl. mehr<br>

500 g 	Hackfleisch, gemischt<br>

1  	Zwiebel(n)<br>

1 Zehe/n 	Knoblauch<br>

  	Salz und Pfeffer, schwarzer aus der Mühle<br>

  	Paprikapulver<br>

100 g 	Reis, gekochter<br>

1  	Ei(er)<br>

1 kl. Dose/n 	Tomatenmark<br>

500 ml 	Gemüsebrühe<br>

 etwas 	Zucker<br>

1 EL 	Butter<br>

1 EL 	Mehl <br>

</b><br><br><br>

Aus Hackfleisch, Reis, Ei, Zwiebel und Knoblauch einen Hackfleischteig herstellen und mit den Gewürzen abschmecken. In die Paprikaschoten füllen und aus dem Rest Hackfleischbällchen formen. Die Butter in einem Topf schmelzen, das Mehl dazugeben und etwas anrösten. Mit Gemüsebrühe ablöschen, das Tomatenmark dazugeben und aufkochen lassen. Mit Salz, Pfeffer und etwas Zucker abschmecken. Die gefüllten Paprikaschoten und die Bällchen in die Soße geben und entweder auf dem Herd oder im Backofen 30-40 min schmoren lassen.<br>

Dazu gibt es Reis. Alternativ kann man auch Tomatenpüree statt des Tomatenmarks verwenden. Dann etwas weniger Brühe verwenden.<br>

Die Mengenangaben sind natürlich etwas vage, meine Uri hat immer "nach Gefühl" gekocht. Ich habe versucht, das Rezept so gut wie möglich nachzuvollziehen!<br>', 40, 70, '2013-12-10 15:02:21.894');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (7, 'Omas Kohlrouladen', 'schmeckt wie fr&uuml;her', '<b>

1  	Wirsing oder Weißkohl)<br>

500 g 	Hackfleisch, gemischt<br>

1  	Zwiebel(n)<br>

1  	Brötchen, altbacken<br>

1  	Ei(er)<br>

100 g 	Speck, gewürfelt<br>

500 ml 	Brühe<br>

200 ml 	Sahne<br>

  	Salz und Pfeffer<br>

1 EL 	Senf, evtl. mehr<br>

  	Paprikapulver, scharf<br>

  	Majoran <br>

</b>

<br><br><br>

Acht schöne Blätter vom Kohl ablösen und blanchieren. In Eiswasser abschrecken und mit einem Küchentuch etwas trocknen. Den Hackfleischteig wie folgt zubereiten: hinein gehört ein Ei, ein eingeweichtes und ausgedrücktes Brötchen, 1-2 EL Senf, eine fein gewürfelte Zwiebel, ordentlich Salz, Pfeffer und scharfes Paprikapulver. Zum Schluss nach Belieben noch getrockneten Majoran hineinstreuen. Das Ganze vermengen. Kleine Häufchen auf die ausgelegten Kohlblätter verteilen, zusammenrollen und mit einem Küchengarn zusammenbinden. Die Kohlrouladen in einer hohen Pfanne anbraten, sodass sie Farbe bekommen. Dabei auch einige Speckwürfel mit auslassen. Haben die Kohlrouladen etwas Farbe angenommen, das Ganze mit gekörnter Brühe aufgießen. Zugedeckt eine halbe Stunde schmoren lassen. Zum Schluss die Rouladen herausnehmen und die Flüssigkeit mit Sahne aufgießen, etwas einkochen lassen oder evtl. leicht abbinden. Das Ganze mit wenig Salz und Pfeffer abschmecken und die Soße zu den Kohlrouladen servieren. ', 50, 70, '2013-12-10 15:03:36.618');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (8, 'Lasagne', 'wie beim Italiener', '<b>

500 g 	Hackfleisch<br>

1  	Zwiebel(n)<br>

2  	Knoblauchzehe(n)<br>

1 Bund 	Petersilie oder TK<br>

1 EL 	Tomatenmark<br>

1 Dose 	Tomate(n), geschälte<br>

1/2 Liter 	Milch<br>

30 g 	Butter<br>

40 g 	Mehl<br>

  	Salz und Pfeffer<br>

  	Olivenöl<br>

300 g 	Lasagneplatte(n)<br>

  	Muskat<br>

  	Wein, rot<br>

  	Käse, gerieben<br>

  	Butter, in Flöckchen <br>

</b><br><br><br>

Ragout Bolognese:<br>

In einem Topf das Olivenöl erhitzen, das Hackfleisch darin rundherum anbraten und die gehackten Zwiebeln und die Petersilie dazugeben. Knoblauchscheiben und Tomatenmark dazu rühren und mitbraten. Mit den Dosentomaten aufgießen, salzen und pfeffern. Rotwein nach Belieben beifügen. Das Ragout mindestens eine halbe Stunde lang bei geöffnetem Topf einkochen lassen.<br>

<br>

Bechamelsauce:<br>

Butter in einem kleinen Topf schmelzen und das Mehl mit dem Schneebesen dazuarbeiten. Die Milch nun dazugießen und die Sauce glatt rühren. Wer zu langsam gerührt hat und Klümpchen in der Sauce findet, kann die Sauce durch ein feines Haarsieb passieren und dann weiterkochen lassen. Die Sauce sollte fast eine halbe Stunde lang auf kleiner Flamme köcheln, damit sie den Mehlgeschmack verliert. Mit Salz, Pfeffer und Zitronensaft sowie etwas Muskatnuss abschmecken.<br>

<br>

Zubereitung der Lasagne:<br>

In einer gebutterten, feuerfesten Form etwas Ragout bolognese verteilen, eine Schicht Lasagnenudeln darauf legen, die Nudelschicht wieder mit Ragu und dann mit einer Bechamelsaucenschicht bedecken. Anschließend wieder eine Schicht Nudeln, Ragu und Bechamel. So Schicht für Schicht die Form füllen.<br>

Die letzte Schicht sollte die Bechamelsauce bilden. Dick mit geriebenen Käse bestreuen, Butterflöckchen darauf setzen . Die Lasagne bei 180°C im Ofen überbacken, bis die Kruste goldbraun ist.<br>

<br>

Die Lasagne kann man auch gut einen Tag vorher vorbereiten und im Kühlschrank ziehen lassen!<br>

<br>

Empfehlung Vorspeise: Honigmelone mit Parmaschinken<br>

Empfehlung Nachspeise: Beerenmix an Quark-Joghurt-Sahne-Creme mit brauner Zuckerkruste! <br>', 60, 100, '2013-12-10 15:06:24.42');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (9, 'Gnocchi Auflauf', 'Mix aus Auflauf, Nudeln und Kl&ouml;se', '<b>

200 g 	Schinken, gekochter, gewürfelt<br>

300 g 	Champignons, kleine aus der Dose, halbiert<br>

250 g 	Kirschtomate(n), möglichst fest, halbiert<br>

1  	Zwiebel(n), gewürfelt<br>

3  	Knoblauchzehe(n), gepresst<br>

3 EL 	Öl<br>

3 EL 	Tomatenmark<br>

1 EL 	Mehl<br>

400 g 	Sahne<br>

1000 g 	Gnocchi, (aus der Kühltheke)<br>

  	Fett, für die Auflaufform<br>

200 g 	Mozzarella, gewürfelt<br>

200 g 	Käse (Gouda), gerieben<br>

1 EL 	Kräuter, italienische , z.B. gefroren<br>

  	Salz und Pfeffer, nach Geschmack <br>

</b>

<br><br><br>

Die Tomaten in 1 El heißem Öl kurz anbraten. Mit Salz und Pfeffer würzen, herausnehmen und kurz beiseite stellen.<br>

2 EL Öl in der gleichen Pfanne erhitzen und die Zwiebel mit dem Knoblauch glasig dünsten.<br>

Die Pilze dazugeben und anbraten. Dann den Schinken zugeben und kurz mitbraten.<br>

Das Tomatenmark hineingeben und kurz anrösten, damit sich das Tomatenaroma besser entfalten kann. Das Mehl drüber streuen, kurz verrühren und anschwitzen.<br>

Anschließend mit der Sahne ablöschen. Nun die Kräuter untermischen und das ganze ca. 5 Minuten leicht köcheln lassen.<br>

Tomatenhälften wieder zugeben und mit Salz und Pfeffer abschmecken.<br>

<br>

Gnocchi nach Packungsanleitung garen, abtropfen und in die große gefettete Auflaufform geben. Die Tomaten-Sahne-Sauce darüber gießen.<br>

Nun die Mozzarella-Würfel darüber streuen, anschließend den geriebenen Gouda darüber verteilen.<br>

<br>

Nun für 20-30 Minuten bei 200° C im vorgeheizten Ofen überbacken.<br>



Um das ganze Essen kalorientechnisch zu entschärfen, bin ich auf Milch mit 1 Becher Creme leger statt Sahne und bei den Käsesorten auf Light-Produkte ausgewichen ', 30, 80, '2013-12-10 15:10:04.667');
INSERT INTO recipes (id, title, description, content, preparation_endurance, total_endurance, creation) VALUES (10, 'Tortellini alla panna', 'Schinken-Sahnesauce wie beim Italiener', '<b>

500 g 	Tortellini, aus dem Frischeregal<br>

600 ml 	Sahne<br>

200 g 	Schinken, gekochter, gewürfelt<br>

2  	Eigelb<br>

4 EL 	Parmesan, frisch geriebener<br>

1 TL 	Muskat<br>

1 TL 	Salz<br>

1 EL 	Butter <br>

</b><br><br><br>

Die Tortellinis nach Packungsanweisung kochen.<br>

Den gekochten Schinken in einer tiefen Pfanne mit Butter kurz anbraten, dann 400ml von der Sahne hineingeben und auf kleiner Stufe köcheln lassen. Wenn die Tortellini gar sind, in die Pfanne zur Schinkensahne geben und weiter köcheln lassen.<br>

In der Zwischenzeit in einer kleinen Schüssel das Eigelb, den Parmesan, Muskatnuss, Salz und die restliche 200 ml Sahne verrühren, dann in die Pfanne zu den Tortellinis geben und so lange köcheln lassen, bis die Soße dickflüssig wird. Sofort servieren.<br>

Sehr gehaltvoll, aber der Geschmack ist fantastisch. Ab und zu kann man sich´s mal gönnen. <br>', 20, 30, '2013-12-10 15:11:45.826');



