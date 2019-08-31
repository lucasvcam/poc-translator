(function () {
    'use strict';

    App.controller('TranslatorController', function ($scope, TranslatorService, LanguageService) {

        $scope.fetchAllTranslators = function () {
        	if($scope.currentPage && $scope.currentPage >= 0){
        		$scope.loading = true;
        		if (($scope.currentPage - 1) > Math.round($scope.translators.totalElements / $scope.pageSize)) {
        			$scope.currentPage = Math.round($scope.translators.totalElements / $scope.pageSize);
        		}
        		TranslatorService.fetchAllTranslators($scope.currentPage - 1, $scope.pageSize, $scope.orderType, $scope.sortKey)
        		.then(function (response) {
        			$scope.translators = response;
        			$scope.loading = false;
        		})
        		.catch(function () {
        			alert('Error while fetching Translator');
        			$scope.loading = false;
        		});
        	}else{
        		$scope.currentPage = "";        		
        	}
        };

        $scope.fetchAllLanguages = function () {
            $scope.loading = true;
            LanguageService.fetchAllLanguages()
                .then(function (response) {
                    $scope.languages = response;
                    $scope.loading = false;
                })
                .catch(function () {
                    alert('Error while fetching Translator');
                    $scope.loading = false;
                });
        };

        $scope.init = function () {
            $scope.loading = false;
            $scope.currentPage = 1;
            $scope.pageSizes = [10, 20, 50, 100];
            $scope.pageSize = 10;
            $scope.sortKey = '';
            $scope.orderType = '';
            $scope.languages = [];
            $scope.translators = [];
            $scope.currentTranslator = {};
            $scope.fetchAllLanguages();
            $scope.fetchAllTranslators();
        };

        $scope.init();

        $scope.createTranslator = function (translator) {
            $scope.loading = true;
            TranslatorService.createTranslator(translator)
                .then(function () {
                    $scope.fetchAllTranslators();
                    $('#modal').modal('hide');
                })
                .catch(function () {
                    alert('Error while creating Translator');
                    $scope.loading = false;
                });
        };

        $scope.updateTranslator = function (translator) {
            $scope.loading = true;
            TranslatorService.updateTranslator(translator)
                .then(function () {
                    $scope.fetchAllTranslators();
                    $('#modal').modal('hide');
                })
                .catch(function () {
                    alert('Error while updating Translator');
                    $scope.loading = false;
                });
        };

        $scope.removeTranslator = function (translator) {
            $scope.loading = true;
            TranslatorService.deleteTranslator(translator.id)
                .then(function () {
                    $scope.fetchAllTranslators();
                    $('#modal').modal('hide');
                })
                .catch(function () {
                    alert('Error while deleting Translator');
                    $scope.loading = false;
                });
            $scope.currentTranslator = {};
        };

        $scope.submit = function (translator) {
            switch ($scope.modalAction) {
                case 'register':
                    $scope.createTranslator(translator);
                    break;
                case 'edit':
                    $scope.updateTranslator(translator);
                    break;
                case 'delete':
                    $scope.removeTranslator(translator);
                    break;
            }
        };

        $scope.openModal = function (translator, action) {
            $scope.modalAction = action;
            $scope.currentTranslator = { ...translator };
            switch ($scope.modalAction) {
                case 'register':
                    $scope.modalTitle = 'Register Translator';
                    break;
                case 'edit':
                    $scope.modalTitle = 'Edit Translator';
                    break;
                case 'delete':
                    $scope.modalTitle = 'Delete Translator';
                    break;
            }
            $('#modal').modal('show');
        };

        $scope.sort = function (keyname) {
            $scope.sortKey = keyname;
            $scope.reverse = !$scope.reverse;
            $scope.orderType = $scope.reverse ? 'DESC' : 'ASC';
            $scope.fetchAllTranslators();
        };

        $scope.paginator = function (page) {
            $scope.currentPage = page;
            $scope.fetchAllTranslators();
        };

        $('#modal').on('hidden.bs.modal', function () {
            $scope.currentTranslator = {};
        });

    });
})();




