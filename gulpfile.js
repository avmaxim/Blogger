var gulp = require('gulp');
var less = require('gulp-less');
var path = require('path');
var LessAutoprefix = require('less-plugin-autoprefix');
var autoprefix = new LessAutoprefix({browsers: ['last 2 versions']});
var ngAnnotate = require('gulp-ng-annotate');
var browserify = require('gulp-browserify');
var concatCss = require('gulp-concat-css');
var order = require('gulp-order');
var concat = require('gulp-concat');
var mainBowerFiles = require('gulp-main-bower-files');
var gulpFilter = require('gulp-filter');


var PATHS = function () {
    var appFolder = './src/main/webapp/client-resources/app';
    var dist = './src/main/webapp/client-resources/dist';

    return {
        appFolder: appFolder,
        dist: dist,
        lessMask: path.join(appFolder, '**/*.less'),
        angularApp: path.join(appFolder, 'app.module.js'),
        angularModules: path.join(appFolder, '**/*.module.js'),
        js: path.join(appFolder, '**/*!(module).js')
    }
}();

gulp.task('less', function () {
    return gulp.src(path.join(PATHS.appFolder, '**/*.less'))
        .pipe(less({
            plugins: [autoprefix]
        }))
        .pipe(concatCss("bundle.css"))
        .pipe(gulp.dest(PATHS.dist));
});

gulp.task('scripts', function () {
    // Single entry point to browserify
    gulp.src([PATHS.angularModules, PATHS.js])
        .pipe(ngAnnotate())
        .pipe(concat('bundle.js'))
        .pipe(gulp.dest(PATHS.dist))
});

gulp.task('vendor', function () {
    var filterJS = gulpFilter('**/*.js');
    return gulp.src('./bower.json')
        .pipe(mainBowerFiles())
        .pipe(filterJS)
        .pipe(concat('vendor.js'))
        .pipe(gulp.dest(PATHS.dist));
});

gulp.task('watch', function () {
    gulp.watch(PATHS.lessMask, ['less']);
});


// The default task (called when you run `gulp` from cli)
gulp.task('default', ['less','vendor', 'scripts']);