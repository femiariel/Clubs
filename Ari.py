#Requires AutoHotkey v2.0

; Touche de déclenchement — ici F2, tu peux changer
F2::
{
    ; Sauvegarde du contenu actuel du presse-papiers
    origClipboard := A_Clipboard
    A_Clipboard := ""  ; Vide le presse-papiers pour éviter les erreurs
    Send "^c"          ; Simule Ctrl+C pour copier la sélection
    ClipWait 1         ; Attendre que le presse-papiers soit rempli (1 seconde max)
    
    if !ClipWait(1)
    {
        MsgBox "Erreur : Aucun texte sélectionné ou copie échouée."
        return
    }

    ; Le texte copié
    inputText := A_Clipboard

    ; Paramètres de recherche/remplacement (à adapter à ton besoin)
    pattern := "foo"             ; Mot ou regex à chercher
    replacement := "bar"         ; Remplacement à faire

    ; Traitement ligne par ligne
    lines := StrSplit(inputText, "`n")
    newLines := []

    for line in lines
    {
        ; Supprime les retours chariot Windows (\r)
        cleanLine := StrReplace(line, "`r", "")
        ; Applique la regex
        newLine := RegExReplace(cleanLine, pattern, replacement)
        newLines.Push(newLine)
    }

    ; Recompose le texte transformé
    result := StrJoin(newLines, "`r`n")

    ; Remet dans le presse-papiers
    A_Clipboard := result

    ; Message de confirmation
    TrayTip "AutoHotkey", "Texte modifié et copié dans le presse-papiers.", 2000
}
