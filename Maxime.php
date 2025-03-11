<?php


use DAO\EtudiantDAO;
use DAO\Bilan1DAO;
use DAO\Bilan2DAO;


require_once __DIR__."/../Model/DAO/Bilan2DAO.php";
require_once __DIR__."/../Model/DAO/Bilan1DAO.php";
require_once __DIR__."/../Model/DAO/EtudiantDAO.php";
require_once __DIR__."/../Model/BDDManager.php";




header('Content-Type: application/json');


if(isset($_POST['login']) && isset($_POST['mdp'])){
    $user = $_POST['login'];
    $mdp = $_POST['mdp'];

    $info = verif_send($user, $mdp);
    
    echo json_encode($info);
}else{
    echo json_encode(["error" => "Parametre manquant"]);
}

function verif_send($login, $mdp) {

    $bdd = initialiseConnexionBDD();

    $etuDAO = new EtudiantDAO($bdd);
    $etudiant = $etuDAO->auth($login, $mdp);

    if ($etudiant) {

        $bilan1Array = [] ;
        $bilan2Array = [] ;

        foreach ($etudiant->getMesBilan1() as $bilan) {
            $bilan1Array[] = [
                'libBil1'      => $bilan?->getLibBil() ?? "vide",
                'notBil1'      => $bilan?->getNotBil() ?? -1,
                'remarqueBil1' => $bilan?->getRemBil() ?? "vide",
                'noteEntBil1'  => $bilan?->getNotEnt() ?? -1,
                'noteOralBil1' => $bilan?->getNotOra() ?? -1,
                'dateBil1'     => $bilan?->getDatVisEnt()->format("d/m/Y") ?? "vide",
            ];   
        }
        foreach ($etudiant->getMesBilan2() as $bilan) {
              $bilan2Array[] = [
                'libBil2'      => $bilan?->getLibBil() ?? "vide",
                'noteBil2'     => $bilan?->getNotBil() ?? -1,
                'noteOralBil2' => $bilan?->getNotOra() ?? -1,
                'sujMemoire'   => $bilan?->getSujBil() ?? "vide",
                'dateBil2'     => $bilan?->getDatBil2()->format("d/m/Y") ?? "vide",
            ];    
        }

        $tableau = [
        'id' => $etudiant->getIdUti() ?? "vide",
        'nomUti' => $etudiant->getNomUti() ?? "vide",
        'prenomUti' => $etudiant->getPreUti() ?? "vide",
        'adresseUti' => $etudiant->getAdrUti() ?? "vide",
        'mailUti' => $etudiant->getMailUti() ?? "vide",
        'nomMA' => $etudiant->getMonMaitreAp()?->getNomMai() ?? "vide",
        'prenomMA' => $etudiant->getMonMaitreAp()?->getPreMai() ?? "vide",
        'telMA' => $etudiant->getMonMaitreAp()?->getTelMai() ?? "vide",
        'mailMA' => $etudiant->getMonMaitreAp()?->getMailMai() ?? "vide",
        'nomEnt' => $etudiant->getMonEnt()?->getNomEnt() ?? "vide",
        'adresseEnt' => $etudiant->getMonEnt()?->getAdrEnt() ?? "vide",
        'telEnt' => $etudiant->getMonEnt()?->getTelEnt() ?? "vide",
        'mailEnt' => $etudiant->getMonEnt()?->getMailEnt() ?? "vide",
        'bilan1'       => $bilan1Array,
        'bilan2'       => $bilan2Array
        ];

        return $tableau;
         } else {
        return ["error" => "Authentification échouée"];
    }

}



?>