package plane;

/**
 * Given two lines on a Cartesian plane, determine whether the two lines would intersect.
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain CC150-7.3}
 *
 */
public class math_plane_two_lines_intersect {
    public class Line {
        public final double slope;
        public final double yIntercept;

        public Line(double _slope, double _yIntercept) {
            slope = _slope;
            yIntercept = _yIntercept;
        }

        public boolean isIntercept(Line other) {
            double mySlope = 0.0 + slope, urSlope = 0.0 + other.slope;
            double myInterc = 0.0 + yIntercept, urInterc = 0.0 + other.yIntercept;

            return mySlope != urSlope || myInterc == urInterc;
        }
    }
}