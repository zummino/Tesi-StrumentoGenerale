Strumento Generale sviluppato nella tesi di laurea.

Per configurarlo su di una propria applicazione web, seguire i seguenti passi:

1) Creare il virtual environment “envForGithubActions” 

2) Inserire le seguenti 8 variabili d'ambiente, customizzando i valori di esempio qui riportati in base al proprio caso d'uso:
BRANCH_NAME: master
EMAIL_ACCOUNT_GITHUB: t*********@gmail.com
NOME_ACCOUNT_GITHUB: g*********
PASSWORD_ACCOUNT_GITHUB: *********
GRAMMAR_TYPE: angularjs
NUMERO_SPLIT: 1
MIN_EXE_TEST: 5

3) Inserire all'interno della directory "insert-here-yuor-web-app" la cartella contenente il progetto della propria applicazione web.

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

5) Customizzare il file hookInjection.sh

Ecco qui dei valori di esempio:

node main.js inject-hooks /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/rootWebApp/file1.html --grammar ${{ secrets.GRAMMAR_TYPE }}
node main.js inject-hooks /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/rootWebApp/file2.html --grammar ${{ secrets.GRAMMAR_TYPE }}
node main.js inject-hooks /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/rootWebApp/innerDirectory/file3.html --grammar ${{ secrets.GRAMMAR_TYPE }}

bisogna quindi ripetere il comando "node main.js inject-hooks" n volte (dove n è il numero di file che si desidera instrumentare) specificando volta per volta la directory di dove si trova il file che si desidera instrumentare.


6) Andare nel tab "Actions" ed attivare i "Workflows" cliccando sul button "I understand my workflows, go ahead and enable them".

7) Registrare casi di test con Katalon Recorder ed esportarli in modalita (JUnit + WebDriver)

8) Si otterrà un file zip, estrarre il contenuto del file e pushare solamente i file di test (con estensione .java) estratti
all'interno della directory ./project-test-headless/src/test/java/com/example/TesiIntegrazioneProgettoEsterno/
