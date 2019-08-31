'use strict';

App.factory('LanguageService', ['$http', '$q', function ($http, $q) {

    var REST_SERVICE_URI = 'http://localhost:8080/api/v1/languages';

    var factory = {
        fetchAllLanguages: fetchAllLanguages,
    };

    return factory;

    function fetchAllLanguages() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    alert('Error while fetching Languages');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
}]);