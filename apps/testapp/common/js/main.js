function wlCommonInit(){

}

function openExternalApp() {
	var QUESTION_LINK = $(".question_link").attr("href");
	cordova.exec(onSuccess, onFailure, "OpenExternalAppPlugin", "openApp", [QUESTION_LINK]);
}

function onSuccess() {
	WL.Logger.debug("*** Plug-in executed successfully.");
}

function onFailure() {
	WL.Logger.debug("*** Plug-in failed to execute.");
}