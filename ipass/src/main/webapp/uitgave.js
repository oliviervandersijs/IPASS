

var categorieRepeatDiv = '<div class="repeatDivCategorie">';
categorieRepeatDiv +=         '<div id="uitgaveRepeatButton" class="repeat"><button type="button" class="button-add"></button></div>';
categorieRepeatDiv +=         '<div id="uitgaveRepeatOmschrijving" class="repeat"><input id="omschrijving" type="text" name="Omschrijving"></div>';
categorieRepeatDiv +=         '<div id="uitgaveRepeatPrijs" class="repeat"><label for="Prijs">\u20ac</label><input id="Prijs" type="number" name="Prijs"> </div></div>';


function addUitgave(oms,date,cat,bedrag) {
    document.getElementById('uitgaveObjecten').insertAdjacentHTML('beforeend', uitgaveRepeatDiv);
}

function addCategorie() {
    document.getElementById('categorieObjecten').insertAdjacentHTML('beforeend',categorieRepeatDiv);
}




function openTab(tabName) {
    var i;
    var x = document.getElementsByClassName("tab");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";
    }

    document.getElementById(tabName).style.display = "block";
}
