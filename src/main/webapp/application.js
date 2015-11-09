/**
 * @author Luis & Marc
 */

var app = angular.module('ridingClub', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {

   /* Unterscheidliche routes: jeder eine funktionalität und ein HTML + controller zugeordnet*/

    $routeProvider.when('/members', {
        templateUrl: "members.html",
        controller: "MemberController"
    });

    $routeProvider.when('/createMember', {
        templateUrl: "createMember.html",
        controller: "NewMemberController"
    });

    $routeProvider.when('/editMember/:member_id', {
        templateUrl: "editMember.html",
        controller: "editMemberController"
    });

    $routeProvider.when('/searchMember', {
        templateUrl: "searchMember.html",
        controller: "searchController"
    });

    $routeProvider.when('/payments/:member_id', {
        templateUrl: "payments.html",
        controller: "paymentsController"
    });

    $routeProvider.otherwise({
        redirectTo: '/members'
    });

}]);

/**
 * Zeigt alle Mitglieder in einer Uebersicht
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
            alert("Fehler beim Laden der Mitgliederliste")
        });

}]);

app.service('memberService', ['$http', function ($http) {
    this.listMembers = function () {
        return $http.get('rest/members');
    }
}]);


/**
 * Fuegt ein neues Mitglied hinzu
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
        familyMember: ""
    };

    $scope.anlegen = function () {

        var config = {
            method: "PUT",
            url: "rest/member",
            data: $scope.member
        };

        var response = $http(config);

        response.success(function () {
            alert("Mitglied erfolgreich angelegt!");
        });

        response.error(function (data, status, headers, config) {
            alert("Bitte fuellen Sie alle Pflichtfelder (*) aus!");
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
            alert("Fehler bei Mitgliederersuche: " + status);
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
            memberType: ""
        }
    };

    var getData = function(){
        //zeigt die Zahlungen aller Mitglieder an, wenn keine member_id uebergeben wird
        var url;

        if (0 == $scope.member_id) {
            url = "rest/payments";
            $scope.member_id= "Alle Mitglieder";
        }else{
            url = "rest/payments/" + $scope.member_id;
        }

        var config = {
            method: "GET",
            url: url
        };

        var response = $http(config);

        response.success(function (data) {
            $scope.model.payments = data;
        });

        response.error(function (data, status) {
            alert("Fehler beim Anzeigen der Zahlungen. HTTP-Statuscode: " + status);
        });

    };

    getData();

    /**
     * Veraenderung des Zahlungsstatus in der Zahlungsuebersicht
     * @param payment_id
     */
    $scope.changeStatus = function (payment_id) {

        var config = {
            method: "GET",
            url: "rest/payment/changeStatus/" + payment_id
        };
        var response = $http(config);

        response.success(function () {
           alert("Status erfolgreich geaendert!");
            getData();
        });
        response.error(function () {
            alert("Fehler bei Statusaenderung!");
        });

    };



}]);

/**
 * Bearbeitung der Stammdaten
 */

app.controller("editMemberController", ["$scope", "$routeParams", "$http", function ($scope, $routeParams, $http) {

    $scope.member_id = $routeParams.member_id;

    $scope.member = {
        member_id: "",
        name: "",
        surname: "",
        address: "",
        city: "",
        memberType: "",
        birthday: "",
        zipcode: "",
        iban: "",
        entryDate: "",
        noticeDate:"",
        exitDate:"",
        familyMember: ""
    };

    var config = {
        method: "GET",
        url: "/rest/member/" + $routeParams.member_id
    };
    var response = $http(config);

    response.success(function (data) {
        $scope.member = data;
    });

    /**
     * Speichern einer Stammdatenaenderung
     */
    $scope.speichern = function(){

        var config = {
            method: "PUT",
            url: "rest/member",
            data: $scope.member
        };

        var response = $http(config);

        response.success(function (data, status, headers, config) {
            alert("Mitglied erfolgreich gespeichert: " + status);
        });

        response.error(function (data, status, headers, config) {
            alert("Fehler beim Speichern des Mitglieds: " + status);
        });

    }

}]);


/**
 * Hinzufuegen einer Zahlung
 */

app.controller('addPaymentController', ['$scope', "$routeParams", '$http', function ($scope, $routeParams, $http) {

    $scope.member_id = $routeParams.member_id;

}]);