#Requires AutoHotkey v2.0

F2::
{
    Send "^c"
    if !ClipWait(1)
        return

    A_Clipboard := RegExReplace(A_Clipboard, "(\r?\n){2,}", "`r`n")
}
