#Requires AutoHotkey v2.0

F2::
{
    ; Vide le presse-papiers
    origClipboard := A_Clipboard
    A_Clipboard := ""
    Send "^c"
    
    if !ClipWait(1)
    {
        MsgBox "Erreur : Aucun texte sélectionné ou la copie a échoué."
        return
    }

    inputText := A_Clipboard

    ; === Traitement global ===
    ; Remplace deux sauts de ligne ou plus par un seul
    ; Compatible avec \n ou \r\n (Unix ou Windows)
    cleaned := RegExReplace(inputText, "(\r?\n){2,}", "`r`n")

    ; Met le résultat dans le presse-papiers
    A_Clipboard := cleaned

    ; Message rapide
    TrayTip "AutoHotkey", "Sauts de ligne multiples remplacés.", 2000
}
