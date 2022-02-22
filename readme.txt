Strumento Generale sviluppato nella tesi di laurea.

Per configurarlo su di una propria applicazione web, seguire i seguenti passi:

1) Creare il virtual environment “envForGithubActions” 

2) Inserire le seguenti 6 variabili d'ambiente, customizzando i valori di esempio qui riportati in base al proprio caso d'uso:
BRANCH_NAME: master
EMAIL_ACCOUNT_GITHUB: t*********@gmail.com
NOME_ACCOUNT_GITHUB: g*********
PASSWORD_ACCOUNT_GITHUB: *********
NUMERO_SPLIT: 1
MIN_EXE_TEST: 5
FE_EXTENSION_TYPE: .html
GRAMMAR_TYPE: angularjs
DIR_FILE_FE: /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/root-web-app

3) Inserire all'interno della directory "insert-here-yuor-web-app" la cartella contenente il progetto della propria applicazione web.

4) Customizzare i file startBackEnd.sh e startFrontEnd.sh, in base al proprio caso d'uso.
Vediamo degli esempi, 

startBackEnd.sh:
cd /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/angular-java-example-master
mvn clean install
cd /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/angular-java-example-master/target
echo "Vediamo quali file jar si trovano in cartella target"
ls -a
echo "Proviamo ad eseguire ${{ secrets.NOME_JAR_WEBAPP }}.jar"
java -jar users-0.0.1-SNAPSHOT.jar

startFrontEnd.sh:
cd /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/angular-java-example-master/src/main/ui
echo "Siamo nella directory FE, proviamo a lanciarlo in esecuzione"
npm install
echo "Installazione npm effettuata, prossimo comando: npm start"
npm start

5) Andare nel tab "Actions" ed attivare i "Workflows" cliccando sul button "I understand my workflows, go ahead and enable them".

6) Registrare casi di test con Katalon Recorder ed esportarli in modalita (JUnit + WebDriver)

7) Si otterrà un file zip, estrarre il contenuto del file e pushare solamente i file di test (con estensione .java) estratti
all'interno della directory ./project-test-headless/src/test/java/com/example/TesiIntegrazioneProgettoEsterno/


NB: Quando si crea un tag se si vuole che vengano iniettati gli hooks,, bisogna far terminare il nome del tag
con i seguenti 6 caratteri "-Hooks", per esempio un nome valido potrebbe essere "v1_0-Hooks".
NB: Non bisogna inserire metacaratteri nel nome di un tag, come per esempio il punto "."
usare quindi tag del tipo "v1_0-Hooks" e non tag come "v1.0-Hooks"
