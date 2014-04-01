import java.util.ArrayList;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class kelvin_bacon {
    class Actor {
        final HashSet<Movie> movies;

        Actor(HashSet<Movie> _m) {
            movies = _m;
        }
    }

    class Movie {
        final HashSet<Actor> actors;

        Movie(HashSet<Actor> _a) {
            actors = _a;
        }
    }

    class Result {
        final int degree;
        final ArrayList<Actor> path;

        Result(int _degree, ArrayList<Actor> _path) {
            degree = _degree;
            path = _path;
        }
    }

    public Result calculateDegree(Actor u, Actor v) {
        Queue<Actor> q = new LinkedList<Actor>();
        q.add(u);
        IdentityHashMap<Actor, Actor> visitedActors = new IdentityHashMap<Actor, Actor>();
        IdentityHashMap<Movie, Boolean> visitedMovies = new IdentityHashMap<Movie, Boolean>();
        visitedActors.put(u, null);
        int degree = 0;

        while (!q.isEmpty()) {
            Actor c = q.poll();
            for (Movie m : c.movies) {
                if (visitedMovies.containsKey(m)) {
                    continue;
                } else {
                    visitedMovies.put(m, true);
                }

                visitedMovies.put(m, true);
                for (Actor a : m.actors) {
                    if (visitedActors.containsKey(a)) {
                        continue;
                    } else {
                        visitedActors.put(a, c);
                    }

                    if (a == u) {
                        return new Result(degree, backtrack(v, visitedActors));
                    } else {
                        q.add(a);
                    }
                }
            }

            degree++;
        }

        return null;
    }

    private ArrayList<Actor> backtrack(Actor v, IdentityHashMap<Actor, Actor> visitedActors) {
        Actor c = v;
        ArrayList<Actor> result = new ArrayList<Actor>();

        while (c != null) {
            result.add(c);
            c = visitedActors.get(c);
        }

        return result;
    }
}