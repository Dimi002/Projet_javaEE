<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<nav>
    <label for="menu-mob" class="menu-mob">Menu</label>
    <input type="checkbox" name="" id="menu-mob" role="button">
    <ul>

        <li class="menu-html"> <a href="?action=index">Acceuil</a></li>
        <li class="menu-cours"> <a href="">cours</a>
            <ul class="submenu">
            <li> <a href="?action=cours&&classe=6EME&&matiere=1"> sixieme (6eme)</a></li>
                <li> <a href="?action=cours&&classe=5EME&&matiere=1"> cinquieme (5eme)</a></li>
                <li> <a href="?action=cours&&classe=4EME&&matiere=1"> quatrieme (4eme)</a></li>
                <li> <a href="?action=cours&&classe=3EME&&matiere=1"> troisieme (3eme)</a></li>
                <li> <a href="?action=cours&&classe=SECONDE&&matiere=1"> seconde (2nde)</a></li>
                <li> <a href="?action=cours&&classe=PREMIERE&&matiere=1"> premiere (1ere)</a></li>
                <li> <a href="?action=cours&&classe=TERMINALE&&matiere=1"> terminale (Tle)</a></li>
            </ul>
        </li>
        <li class="menu-epreuves"> <a href="">epreuves</a>
            <ul class="submenu">
            <li> <a href="?action=epreuves&&classe=6EME&&matiere=1"> sixieme (6eme)</a></li>
                <li> <a href="?action=epreuves&&classe=5EME&&matiere=1"> cinquieme (5eme)</a></li>
                <li> <a href="?action=epreuves&&classe=4EME&&matiere=1"> quatrieme (4eme)</a></li>
                <li> <a href="?action=epreuves&&classe=3EME&&matiere=1"> troisieme (3eme)</a></li>
                <li> <a href="?action=epreuves&&classe=SECONDE&&matiere=1"> seconde (2nde)</a></li>
                <li> <a href="?action=epreuves&&classe=PREMIERE&&matiere=1"> premiere (1ere)</a></li>
                <li> <a href="?action=epreuves&&classe=TERMINALE&&matiere=1"> terminale (Tle)</a></li>
            </ul>
        </li>
        <li class="menu-propos"> <a href="?action=index">a propos</a></li>
    </ul>
    <a href="?action=inscription" class="I_btn">inscription</a>
</nav>
    
    