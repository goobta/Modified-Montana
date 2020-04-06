// Load an STL file from a git repo
// Loading a local file also works here
File maskFile = ScriptingEngine.fileFromGit(
	"https://github.com/agupta231/Modified-Montana.git",
	"MontanaMasks.stl");
// Load the .CSG from the disk and cache it in memory
CSG mask = Vitamins.get(maskFile);

mask = mask.rotx(90)
		 .movez(-7);

List<Polygon> polys = Slice.slice(mask, new Transform(), 0);
Polygon coverOutline = polys[0];

CSG cover = Extrude.polygons(coverOutline, coverOutline.transformed(new Transform().movez(5.0)));

return [mask, cover];