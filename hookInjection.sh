echo "Compilare il seguente script con i comandi per effettaure l'injection per ognuno dei file di FE che si vuole instrumentare. Di sotto degli esempi stampati a video tramite il comando echo:"

echo "node main.js inject-hooks /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/rootDirectory/file1.html --grammar ${{ secrets.GRAMMAR_TYPE }}"
echo "node main.js inject-hooks /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/rootDirectory/file2.html --grammar ${{ secrets.GRAMMAR_TYPE }}"
echo "node main.js inject-hooks /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/rootDirectory/innerDirectory/file3.html --grammar ${{ secrets.GRAMMAR_TYPE }}"

