# zxing-android

此專案修正了 zxing 一直不正常的直向掃瞄畫面狀況, 
並增加了可一次帶入多種掃瞄code類型的機制, 如:
CaptureActivity.showActivity(this, Intents.Scan.TWO_D_CODE_FORMATS, REQUEST_CODE);
// TWO_D_CODE_FORMATS 為 2維條碼種類集合("QR_CODE", "DATA_MATRIX", "PDF_417", "AZTEC")

引用此專案時 請 import module zxing 即可
