cd /home/runner/work/Tesi-integrazioneProgettoEsterno/Tesi-integrazioneProgettoEsterno/angular-java-example-master
mvn clean install
cd /home/runner/work/Tesi-integrazioneProgettoEsterno/Tesi-integrazioneProgettoEsterno/angular-java-example-master/target
echo "Vediamo quali file jar si trovano in cartella target"
ls -a
echo "Proviamo ad eseguire ${{ secrets.NOME_JAR_WEBAPP }}.jar"
java -jar users-0.0.1-SNAPSHOT.jar