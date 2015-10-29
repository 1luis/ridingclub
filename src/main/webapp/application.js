var app = angular.module('ridingClub', ['ngRoute']);


app.config(['$routeProvider', function ($routeProvider) {


    $routeProvider.when('/Members', {
        templateUrl: "Members.html",
        controller: "MemberController"
    });

    $routeProvider.when('/createMember', {
        templateUrl: "createMember.html",
        controller: "NewMemberController"
    });
    /*
     $routeProvider.when('/deleteMember',{
     templateUrl: "deleteMember.html",
     controller: "delMemberController"
     });*/

    $routeProvider.when('/searchMember', {
        templateUrl: "searchMember.html",
        controller: "searchController"
    });

    $routeProvider.otherwise({
        redirectTo: '/Members'
    });


}]);

//*******************************************************************************************************
//*Shows all members in a list
//*******************************************************************************************************

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

//*******************************************************************************************************
//*Adds a new member
//*******************************************************************************************************


app.controller('NewMemberController', ['$scope', "$log", '$http', function ($scope, $log, $http) {


    $scope.member = {
        name1: "",
        surname: "",
        address: "",
        city: "",
        zipcode: "",
        entryDate: "",
        memberType: ""
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

//*******************************************************************************************************
//*Deletes an existing member
//*******************************************************************************************************

app.controller("delMemberController", ["$scope", '$log', '$http', function ($scope, $log, $http) {


    $scope.todelete = {
        name: "",
        surname: ""
    };

    $scope.delete = function () {
        $scope.todelete.name = "zu löschender vorname";
        $scope.todelete.surname = "zu löschender nachname";
    };


    var config = {
        method: "DELETE",
        url: "http://localhost:8080/rest/member/"
    };

    var response = $http(config);

    response.success(function (data, status, headers, config) {
        alert("Das Mitglied wurde gelöscht:" + status);
    });

    response.error(function (data, status, headers, config) {
        alert("Ungültige Anfrage (Bad Request). HTTP-Status:" + status);
    });

}]);

//*******************************************************************************************************
//*Search Members
//*******************************************************************************************************

app.controller("searchController", ["$scope", '$http', function ($scope, $http) {

    $scope.search = {
        name: "",
        surname: ""
    };

    $scope.search = function () {



        var config = {
            method: "GET",
            url: "rest/member",
            data: $scope.member
        };

        var response = $http(config);

        response.success(function (data, status, headers, config) {
            alert("Mitglieder erfolgreich gesucht:" + status);
        });

        response.error(function (data, status, headers, config) {
            alert("Fehler bei Mitgliedersuche:" + status);
        });

    };



}]);

