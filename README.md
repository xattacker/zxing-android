# zxing-android
<br><br>
此專案修正了 open source android project zxing 一直不正常的直向掃瞄畫面狀況, 
並增加了可一次帶入多種掃瞄code類型的機制,<br>
如:<br>
CaptureActivity.showActivity(this, Intents.Scan.TWO_D_CODE_FORMATS, REQUEST_CODE);<br>
// TWO_D_CODE_FORMATS 為 2維條碼種類集合("QR_CODE", "DATA_MATRIX", "PDF_417", "AZTEC")
<br><br>
引用此專案時 請 import module zxing 即可
