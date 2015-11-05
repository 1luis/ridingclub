/**
 * @author Marc & Luis
 */

var app = angular.module('ridingClub', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/members', {
        templateUrl: "members.html",
        controller: "MemberController"
    });

    $routeProvider.when('/createMember', {
        templateUrl: "createMember.html",
        controller: "NewMemberController"
    });

    $routeProvider.when('/searchMember', {
        templateUrl: "searchMember.html",
        controller: "searchController"
    });

    $routeProvider.when('/payments/:member_id', {
        templateUrl: "payments.html",
        controller: "paymentsController"
    });

    $routeProvider.when('/payments', {
        templateUrl: "payments.html",
        controller: "paymentsController"
    });

    $routeProvider.otherwise({
        redirectTo: '/members'
    });

}]);

/**
 * Zeigt alle Mitglieder in einer Übersicht
 */

app.controller("MemberController", ["$scope", 'memberService', function ($scope, memberService) {

    $scope.model = {
        members: []
    };

    memberService.listMembers()
        .success(function (data) {
            $scope.model.members = data;
        })
        .error(function () {
            alert('Fehler beim Laden der Mitgliederliste')
        });

}]);

app.service('memberService', ['$http', function ($http) {
    this.listMembers = function () {
        return $http.get('rest/members');
    }
}]);


/**
 * Fügt ein neues Mitglied hinzu
 */

app.controller('NewMemberController', ['$scope', '$http', function ($scope, $http) {

    $scope.member = {
        name: "",
        surname: "",
        address: "",
        city: "",
        memberType: "",
        birthday: "",
        zipcode: "",
        iban: "",
        entryDate: "",
        //  noticeDate:"",
        //  exitDate:""

    };

    $scope.anlegen = function () {

        var config = {
            method: "PUT",
            url: "rest/member",
            data: $scope.member
        };

        var response = $http(config);

        response.success(function (data, status, headers, config) {
            alert("Mitglied erfolgreich angelegt:" + status);
        });

        response.error(function (data, status, headers, config) {
            alert("Fehler beim Anlegen des Mitglieds:" + status);
        });

    };

}]);


/**
 * Sucht ein Mitglied anhand seines Vor- und Nachnamens
 */

app.controller("searchController", ["$scope", '$http', function ($scope, $http) {

    $scope.search = {
        name: "",
        surname: ""
    };

    $scope.model = {
        results: []
    };

    $scope.suchen = function () {

        var url;

        if (0 === $scope.search.name.length) {
            url = "rest/searchSurname/" + $scope.search.surname;
        } else if (0 === $scope.search.surname.length) {
            url = "rest/searchName/" + $scope.search.name;
        } else {
            url = "rest/search/" + $scope.search.name + "/" + $scope.search.surname;
        }

        var config = {
            method: "GET",
            url: url
        };

        var response = $http(config);

        response.success(function (data) {
            $scope.model.results = data;
        });
        response.error(function (data, status, headers, config) {
            alert("Fehler bei Mitgliederersuche:" + status);
        });

    };
}]);

/**
 * Zeigt die Zahlungen eines Mitglieds bzw. alle Zahlungen an
 */

app.controller("paymentsController", ["$scope", "$routeParams", "$http", function ($scope, $routeParams, $http) {

    $scope.member_id = $routeParams.member_id;

    $scope.model = {
        payments: {
            payment_id: "",
            amount: "",
            year: "",
            status: "",
            memberType: "",
            member_id: ""
        }
    };

    //zeigt die Zahlungen aller Mitglieder an, wenn keine member_id übergeben wird
    var url;

   if($scope.member_id.isUndefined){
        url = "rest/payments";

    }else{
        url = "rest/payments/" + $scope.member_id;
    }

    var config = {
        method: "GET",
        url: url
    };

    var response = $http(config);

    response.success(function (data, status, headers, config) {
        $scope.model.payments = data;
    });

    response.error(function (data, status, headers, config) {
        alert("Fehler beim Anzeigen der Zahlungen. HTTP-Statuscode:" + status);
    });
}]);

/**
 * Fügt eine Zahlung hinzu
 */

app.controller('addPaymentController', ['$scope', "$routeParams", '$http', function ($scope, $routeParams, $http) {

    $scope.member_id = $routeParams.member_id;

}]);