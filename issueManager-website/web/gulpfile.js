// Include gulp
var gulp = require('gulp');
// Include plugins
var del = require('del');
var uglify = require('gulp-uglify');
var usemin = require('gulp-usemin');
var minifyHtml = require('gulp-minify-html');
var minifycss = require('gulp-minify-css');
var rev = require('gulp-rev');
var concat = require('gulp-concat');
var rename = require('gulp-rename');
var sass = require('gulp-sass')
var less = require('gulp-less');
var browserSync = require('browser-sync').create();
var livereload = require('gulp-livereload');
var gutil = require('gulp-util');
var sourcemaps = require('gulp-sourcemaps');
var rimraf = require('rimraf');
var inject = require('gulp-inject');
var embedTemplates = require('gulp-angular-embed-templates');
var mainBowerFiles = require('main-bower-files');
var gulpFilter = require('gulp-filter');
var wiredep = require( 'wiredep' ).stream;
var runSequence = require('gulp-run-sequence');
var angularTemplateCache = require('gulp-angular-templatecache');
var addStream = require('add-stream');
var notify = require("gulp-notify");
var order = require('gulp-order');
var concatCss = require('gulp-concat-css');
var flatten = require('gulp-flatten');


var prepareTemplates = function() {
    return gulp.src('app/**/*.html')
    //.pipe(minify and preprocess the template html here)
    .pipe(angularTemplateCache());
};

gulp.task('browser-sync', function() {
    browserSync.reload();
});

gulp.task('build-less', function() {
    var filterLess = gulpFilter('**/*.less');
    del('dist/css/test.css');
    return gulp.src(mainBowerFiles())
    .pipe(filterLess)
    .pipe(less())
    .pipe(concat('test.css'))
    .pipe(gulp.dest("./dist/css"));
});

var onError = function (err) {  
  console.log(err);
};

gulp.task('build-sass', function() {
    var filterScss = gulpFilter('**/*.scss');
    del('dist/css/test.css');
    return gulp.src(mainBowerFiles('**/*.scss'))
    //.pipe(filterScss)
    .pipe(sass())
    .pipe(concat('test.css'))
    .pipe(gulp.dest("./dist/css"));
});

gulp.task('default', ['build-clean']);

gulp.task('build-clean', function() {
    runSequence('clean', ['build-js','build-vendor-js', 'build-vendor-css', 'build-fonts', 'build-images', 'build-index']);
});

gulp.task('build-fonts', function() {
    del('dist/fonts');
    return gulp.src(mainBowerFiles('**/*.{eot,svg,ttf,woff,woff2,otf}'))
    .pipe(flatten())
    .pipe(gulp.dest('dist/fonts/'));
});

gulp.task('build-images', function() {
    del('dist/images');
    return gulp.src(mainBowerFiles('**/*.{png}'))
    .pipe(flatten())
    .pipe(gulp.dest('dist/images/'));
});

gulp.task('build-index', function() {
    return gulp.src('./app/index.html')
    .pipe(gulp.dest('dist'));
});

gulp.task('build-clean-js', function() {
    //del('dist/js/bundle.min.js');
    //del('dist/js/bundle.min.js.map');
    return gulp.start('build-js');
});

gulp.task('build-js', function() {
    return gulp.src('./app/**/*.js')
    .pipe(sourcemaps.init())
    .pipe(order(['main/**/*.js', 'constants/**/*.js', 'services/**/*.js', '/**/*.js']))
    //.pipe(embedTemplates())
    .pipe(addStream.obj(prepareTemplates()))
    .pipe(concat('bundle.min.js'))
    .pipe(uglify().on('error', swallowError))
    .pipe(sourcemaps.write('./'))
    .pipe(gulp.dest('dist/js'));
});

gulp.task('build-clean-vendor-js', function () {
    del('dist/js/vendor.min.js');
    gulp.start('build-vendor-js');
});

// inject bower components
gulp.task('build-vendor-js', function () {
    var filterJS = gulpFilter('**/*.js');
    return gulp.src(mainBowerFiles())
    .pipe(filterJS)
    .pipe(concat('vendor.min.js'))
    .pipe(uglify().on('error', swallowError))
    .pipe(gulp.dest("./dist/js"));
});

gulp.task('build-clean-vendor-css', function () {
    del('dist/css/vendor.min.css');
    gulp.start('build-vendor-css');
});

// inject bower components
gulp.task('build-vendor-css', function () {
    return gulp.src(mainBowerFiles('**/*.css'))
    //.pipe(concatCss('vendor.min.css')) // concatCss -> replace css source url with the relative path 
    .pipe(concat('vendor.min.css'))
    .pipe(minifycss())
    .pipe(gulp.dest("./dist/css"));
});

gulp.task("clean", function (cb) {
    rimraf('dist', cb);
});

gulp.task('watch', function() {
    gulp.watch(['./app/**/*.js','./app/**/*.html'], function() {
        runSequence('build-clean-js','browser-sync');
    });
    gulp.watch(['./app/template/**/*.html','./app/index.html'], function() {
        runSequence('build-index','browser-sync');
    });
});

// Compile sass into CSS & auto-inject into browsers
gulp.task('sass', function() {
    return gulp.src("src/main/resources/scss/*.scss")
    .pipe(sass())
    .pipe(gulp.dest("./dist/css"))
    .pipe(browserSync.stream());
});

var swallowError = function(err) {
  gutil.log(err.toString());
  this.emit('end');
};

// watch files for changes and reload
gulp.task('serve', ['build-clean','watch'],function() {
    browserSync.init({
        server: './dist',
        port: 3000,
        notify: false
    });
});



