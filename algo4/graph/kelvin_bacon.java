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

    public int calculateDegree(Actor u, Actor v) {
        Queue<Actor> q = new LinkedList<Actor>();
        q.add(u);
        IdentityHashMap<Actor, Boolean> visitedActors = new IdentityHashMap<Actor, Boolean>();
        IdentityHashMap<Movie, Boolean> visitedMovies = new IdentityHashMap<Movie, Boolean>();
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
                        visitedActors.put(a, true);
                    }

                    if (a == u) {
                        return degree;
                    } else {
                        q.add(a);
                    }
                }
            }

            degree++;
        }

        return degree;
    }
}