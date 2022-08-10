echo "inserisci qui i comandi per lo starting del Front-End della tua applciazione web"
echo "Inizio comandi installazione precondizioni"
cd /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale
curl -sL https://deb.nodesource.com/setup_12.x -o nodesource_setup.sh
cat nodesource_setup.sh
sudo bash nodesource_setup.sh
sudo apt install nodejs
echo "versione di node installata"
node -v
echo "Installazione di npm"
sudo apt install npm
echo "Fine comandi installazione Node"

echo "Inizio comandi esecuzione Frontend"
cd /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/angular-spotify-main/angular-spotify-main
echo "Siamo nella directory FE, proviamo a lanciarlo in esecuzione"
npm install
echo "Installazione npm effettuata, prossimo comando: npm start"
echo "npm start"
npm start > /dev/null 2>&1 &
