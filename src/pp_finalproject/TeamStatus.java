/**
 * Nome: Diogo Gomes Cardoso
 * Número: 8210193
 * Turma: LEI1T1
 *
 *
 * Nome: Bruno Miguel Rodrigues Novais
 *  Número: 8210333
 *  Turma: LEI1T1
 */
package pp_finalproject;

/**
 * The <h1>TeamStats</h1> enum provides the states a Team can get.
 */
public enum TeamStatus {
    /**
     * If It's <h2>WORKING</h2> than it is associated with a valid
     * ConstructionSite.
     */
    WORKING,
    /**
     * If It's <h2>INACTIVE</h2> It's associated with a invalid
     * ConstructionSite.
     */
    INACTIVE,
    /**
     * If It's <h2>FREE</h2> It has no ConstructionSite's associated and Its
     * free to be assigned a constructionSite.
     */
    FREE;
}
