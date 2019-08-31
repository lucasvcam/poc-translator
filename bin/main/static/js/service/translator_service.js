'use strict';

App.factory('TranslatorService', ['$http', '$q', function ($http, $q) {

    var REST_SERVICE_URI = 'http://localhost:8080/api/v1/translators/';

    var factory = {
        fetchAllTranslators: fetchAllTranslators,
        createTranslator: createTranslator,
        updateTranslator: updateTranslator,
        deleteTranslator: deleteTranslator
    };

    return factory;

    function fetchAllTranslators(page, linesPerPage, direction, orderBy) {
        var deferred = $q.defer();
        var config = {
            params: { page, linesPerPage, direction, orderBy }
        };
        $http.get(REST_SERVICE_URI, config)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    alert('Error while fetching Translators');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function createTranslator(translator) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, translator)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    alert('Error while creating Translator');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }


    function updateTranslator(translator) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + translator.id, translator)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    alert('Error while updating Translator');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function deleteTranslator(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    alert('Error while deleting Translator');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);