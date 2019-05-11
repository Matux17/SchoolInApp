package m.schoolinapp

object Level {
    var LVL: Int = 0
    private var Lvl: Int = 0

    fun Level() {
        LVL = Lvl
    }

    fun getLvl(): Int {
        return LVL
    }

    fun setLvl(Lvl: Int) {
        LVL = Lvl
    }
}