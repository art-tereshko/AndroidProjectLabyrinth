//package game;
//
//public class OutilsBall
//{
//    /**
//     * @param ball est la liste de TOUTES les ball en mouvement
//     * @param cetteBall est l'une d'entre elles.
//     * @return la liste des autres ball que cetteBall, c'est-à-dire la liste de toutes les ball sauf cetteBall
//     *
//     * */
//    public static Vector<Ball> autresBalls(Ball cetteBall, Vector<Ball> ball)
//    {
//        Vector<Ball> autresBalls = new Vector<Ball>();
//
//        Ball ballCourante;
//
//        int i;
//
//        for( i = 0; i < ball.size(); ++i)
//        {
//            ballCourante = ball.get(i);
//            if ( ballCourante.getClef() != cetteBall.getClef())
//                autresBalls.add(ballCourante);
//        }
//
//        return autresBalls;
//    }
//
//
//    /**
//     * @param cetteBall : une ball particulière
//     * @param ball : une liste de ball, cette liste peut contenir cetteball
//     *
//     * gestion de l'éventuelle  collision de cette ball avec les autres ball
//     *
//     * ball est la liste de toutes les ball en mouvement
//     *
//     * Le comportement par défaut est le choc parfaitement élastique (c-à-d rebond sans amortissement)
//     *
//     * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 ball impliquées dans le choc sont modifiées
//     * si renvoie false, il n'y a pas de collision et les ball sont laissées intactes
//     * */
//    public static  boolean gestionCollisionBallBall(Ball cetteBall, Vector<Ball> ball)
//    {
//        //--- on récupère d'abord dans autresBalls toutes les ball sauf cetteBall ----
//
//        Vector<Ball> autresBalls = OutilsBall.autresBalls(cetteBall, ball);
//
//        //--- on cherche à présent la 1ère des autres ball avec laquelle cetteBall est en collision ---------------------
//        //-------------- on suppose qu'il ne peut y avoir de collision qui implique plus de deux ball à la fois ---------------
//
//        Ball ballCourante;
//
//        int i;
//
//        for ( i = 0 ; i < autresBalls.size(); ++i)
//        {
//            ballCourante = autresBalls.get(i);
//            if (Collisions.CollisionBallBall( cetteBall.getPosition(), cetteBall.getRayon(), cetteBall.getVitesse(), cetteBall.masse(), ballCourante.getPosition(), ballCourante.getRayon(), ballCourante.getVitesse(), ballCourante.masse()))
//            {
//                cetteBall.bruitage(Ball.bruitbulle);//lecture de son
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    /**
//     * @param cetteBall : une ball particulière
//     * @param ball : une liste de ball, cette liste peut contenir cetteball
//     *
//     * On suppose que cetteBall subit l'attraction gravitationnelle due aux ball contenues dans "ball" autres que cetteBall.
//     *
//     * tâche : calcule a, le vecteur accélération subi par cetteBall résultant de l'attraction par les autres ball de la liste.
//     *
//     * @return a : le vecteur accélération résultant
//     *
//     * */
//    public static Vecteur gestionAccélérationNewton(Ball cetteBall, Vector<Ball> ball)
//    {
//
//        //--- on récupère d'abord dans autresBalls toutes les ball sauf celle-ci ----
//
//        Vector<Ball> autresBalls = OutilsBall.autresBalls(cetteBall, ball);
//
//        //-------------- à présent on récupère les masses et les positions des autres ball ------------------
//        int i;
//        Ball ballCourante;
//
//        int d = autresBalls.size();
//
//        double masses [] = new double[d];   // les masses des autres ball
//        Vecteur C [] = new Vecteur[d];      // les positions des autres ball
//
//        for ( i = 0; i < d; ++i)
//        {
//            ballCourante = autresBalls.get(i);
//            masses[i] = ballCourante.masse();
//            C[i] = ballCourante.getPosition();
//        }
//
//        //------------------ à présent on calcule le champ de gravité exercé par les autres ball sur cette ball ------------------
//
//        return  MecaniquePoint.champGravitéGlobal( cetteBall.getPosition(),  masses, C);
//    }
//}
