// Include gulp
var gulp = require('gulp');
// Include plugins
var del = require('del');
var uglify = require('gulp-uglify');
var usemin = require('gulp-usemin');
var minifyHtml = require('gulp-minify-html');
var rev = require('gulp-rev');
var concat = require('gulp-concat');
var rename = require('gulp-rename');
var sass = require('gulp-sass');
var browserSync = require('browser-sync').create();
var livereload = require('gulp-livereload');
var gutil = require('gulp-util');
var sourcemaps = require('gulp-sourcemaps');
var rimraf = require('rimraf');
var inject = require('gulp-inject');
var embedTemplates = require('gulp-angular-embed-templates');
var mainBowerFiles = require('main-bower-files');
var wiredep = require( 'wiredep' ).stream;
var runSequence = require('gulp-run-sequence');
var angularTemplateCache = require('gulp-angular-templatecache');
var addStream = require('add-stream');


var prepareTemplates = function() {
    return gulp.src('app/**/*.html')
    //.pipe(minify and preprocess the template html here)
    .pipe(angularTemplateCache());
};

gulp.task('browser-sync', function() {
    browserSync.reload();
});

gulp.task('default', ['build-clean']);

gulp.task('build-clean', function() {
    runSequence('clean', ['build-js','build-vendor-js','build-index']);
});

gulp.task('build-index', function() {
    gulp.src('./app/index.html')
    .pipe(gulp.dest('dist'));
});

gulp.task('build-clean-js', function() {
    del('dist/bundle.min.js');
    gulp.start('build-js');
});

gulp.task('build-js', function() {
    gulp.src('./app/**/*.js')
    .pipe(sourcemaps.init({debug : true}))
    //.pipe(embedTemplates())
    .pipe(addStream.obj(prepareTemplates()))
    .pipe(concat('bundle.min.js'))
    .pipe(uglify())
    .pipe(sourcemaps.write('./'))
    .pipe(gulp.dest('dist'));
});

gulp.task('build-clean-vendor-js', function () {
    del('dist/vendor.min.js');
    gulp.start('build-vendor-js');
});

// inject bower components
gulp.task('build-vendor-js', function () {
    gulp.src(mainBowerFiles())
    .pipe(concat('vendor.min.js'))
    .pipe(uglify())
    .pipe(gulp.dest("./dist"));
});

gulp.task("clean", function (cb) {
    rimraf('dist', cb);
});

gulp.task('watch', function() {
    gulp.watch(['./app/**/*.js','./app/**/*.html'], function() {
        runSequence('build-clean-js','browser-sync');
    });
});

// Compile sass into CSS & auto-inject into browsers
gulp.task('sass', function() {
    return gulp.src("src/main/resources/scss/*.scss")
        .pipe(sass())
        .pipe(gulp.dest("./dist/css"))
        .pipe(browserSync.stream());
});

// watch files for changes and reload
gulp.task('serve', ['build-clean','watch'],function() {
    browserSync.init({
        server: './dist',
        port: 3000
    });
    //gulp.watch("src/main/resources/scss/*.scss", ['sass']);
});



