package m.schoolinapp

object Language {
    var LANG = 1
    private var Lang = 1

    fun Language() {
        LANG = Lang
    }

    fun getLang(): Int {
        return LANG;
    }

    fun setLang(Lang: Int) {
        LANG = Lang
    }
}