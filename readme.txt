Strumento Generale sviluppato nella tesi di laurea.

Per configurarlo su di una propria applicazione web, seguire i seguenti passi:

1) Creare il virtual environment “envForGithubActions” 

2) Inserire le seguenti 10 variabili d'ambiente, customizzando i valori di esempio qui riportati in base al proprio caso d'uso:
BRANCH_NAME: master
DIR_FILE_FE: /home/runner/work/Tesi-AngularProject/Tesi-AngularProject/WebAppHooks/angular-java-example-master/src/main/ui/src/app/*.html
EMAIL_ACCOUNT_GITHUB: t*********@gmail.com
NOME_ACCOUNT_GITHUB: g*********
PASSWORD_ACCOUNT_GITHUB: *********
GRAMMAR_TYPE: angularjs
NUMERO_SPLIT: 1
PATH_REPOSITORY: /home/runner/work/Tesi-AngularProject/Tesi-AngularProject
MIN_EXE_TEST: 5

3) Sostituire la directory "inserisci-qui-la-tua-web-app" con una cartella contenente il progetto della propria applicazione web

4) Customizzare i file startBackEnd.sh e startFrontEnd.sh, in base al proprio caso d'uso.
Vediamo degli esempi, 

startBackEnd.sh:
cd /home/runner/work/Tesi-integrazioneProgettoEsterno/Tesi-integrazioneProgettoEsterno/angular-java-example-master
mvn clean install
cd /home/runner/work/Tesi-integrazioneProgettoEsterno/Tesi-integrazioneProgettoEsterno/angular-java-example-master/target
echo "Vediamo quali file jar si trovano in cartella target"
ls -a
echo "Proviamo ad eseguire ${{ secrets.NOME_JAR_WEBAPP }}.jar"
java -jar users-0.0.1-SNAPSHOT.jar

startFrontEnd.sh:
cd /home/runner/work/Tesi-integrazioneProgettoEsterno/Tesi-integrazioneProgettoEsterno/angular-java-example-master/src/main/ui
echo "Siamo nella directory FE, proviamo a lanciarlo in esecuzione"
npm install
echo "Installazione npm effettuata, prossimo comando: npm start"
npm start



N.B. I file di test che si vogliono eseguire in modalità headless all'interno del container, devono
essere storicizzati all'interno della directory:
/home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/project-test-headless/src/test/java/com/example/TesiIntegrazioneProgettoEsterno/
