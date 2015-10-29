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


app.controller('NewMemberController', ['$scope', '$http', function ($scope, $http) {


    $scope.member = {
        name: "",
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
//*Search Members
//*******************************************************************************************************

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

        if ($scope.name == ""){
            url = "rest/searchSurname/"+ $scope.search.surname;
        }else if($scope.surname === ""){
            url = "rest/searchName/"+ $scope.search.name;
        }else{
            url = "rest/search/"+ $scope.search.name + "/"+ $scope.search.surname;
        }

        var config = {
            method: "GET",
            url: url
        };

        var response = $http(config);

        response.success(function (data){
            $scope.model.results = data;
        });
        response.error(function (data, status, headers, config) {
            alert("Fehler bei Mitgliederersuche:" + status);
        });

    };

}]);

