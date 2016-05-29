var gulp = require('gulp');
var less = require('gulp-less');
var path = require('path');
var LessAutoprefix = require('less-plugin-autoprefix');
var autoprefix = new LessAutoprefix({ browsers: ['last 2 versions'] });

var stylesFolder = './src/main/webapp/client-resources/application/styles';

gulp.task('less', function () {
    return gulp.src(path.join(stylesFolder, 'less', 'index.less'))
        .pipe(less({
            plugins: [autoprefix]
        }))
        .pipe(gulp.dest(path.join(stylesFolder, 'css')));
});

gulp.task('watch', function() {
    gulp.watch(path.join(stylesFolder, 'less/**/*.less'), ['less']);
});

// The default task (called when you run `gulp` from cli)
gulp.task('default', ['less', 'watch']);