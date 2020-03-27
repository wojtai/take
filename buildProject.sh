cd Project-Films-Angular/
ng build --prod
cd ..
rm Project-Films-Spring/src/main/resources/static/*
cp Project-Films-Angular/dist/Project-Films-Angular/* Project-Films-Spring/src/main/resources/static/
