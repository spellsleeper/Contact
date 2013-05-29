//jdbc:h2:C:/DB/contact

CREATE TABLE kontakt
(
id IDENTITY PRIMARY KEY,
name VARCHAR(50),
vorname VARCHAR(50),
titel VARCHAR(50),
kuerzel VARCHAR(50),
mail1 VARCHAR(50),
mail2 VARCHAR(50),
tel VARCHAR(30),
handy VARCHAR(30),
privatTel VARCHAR(30),
icq VARCHAR(50),
ortid INT,
adresse VARCHAR(50),
FOREIGN KEY(ortid) REFERENCES ort(id)
);



INSERT INTO kontakt VALUES(null,'Ritter','Daniel','Anwendungsentwickler',null,'ritda@gmx.de',null,null,
'01631619142','06455759085',null,1,'Wesestr.18');

INSERT INTO kontakt(id,name,vorname,titel,kuerzel,mail1,mail2,tel,handy,privattel,icq,ortid,adresse)  VALUES
(null,'Ritter','Daniel','Anwendungsentwickler',null,'ritda@gmx.de',null,null,'01631619142','06455759085',null,1,'Wesestr.18');

ALTER TABLE kontakt ADD FOREIGN KEY (ortid) REFERENCES ort(id); 

SELECT * FROM kontakte;

CREATE TABLE ort
(
id IDENTITY PRIMARY KEY,
name VARCHAR(50),
plz VARCHAR(10),
)

INSERT INTO ort VALUES(null,'Haina/Löhlbach','35114');



CREATE TABLE look
(
id IDENTITY PRIMARY KEY,
name VARCHAR(80)
);

INSERT INTO look VALUES(null,'com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel');

Create Table record
(
id IDENTITY PRIMARY KEY,
recid INT 
);

INSERT INTO record VALUES(null,1);