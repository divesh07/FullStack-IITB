waitForAngular = function() {
    window.angularFinished = false;
    var flag = document.querySelector('body');
    var callback = (function() {window.angularFinished=true});
    if (typeof angular == 'undefined') {
        window.angularFinished = true;
    } else {
        angular.element(flag).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);
    }
};
waitForAngular();