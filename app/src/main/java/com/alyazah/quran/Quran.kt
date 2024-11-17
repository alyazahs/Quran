package com.alyazah.quran

import com.google.gson.JsonElement

/*{
    "code": 200,
    "status": "OK",
    "data": {
    "surahs": [
    {
        "number": 1,
        "name": "سُورَةُ ٱلْفَاتِحَةِ",
        "englishName": "Al-Faatiha",
        "englishNameTranslation": "The Opening",
        "revelationType": "Meccan",
        "ayahs": [
        {
            "number": 1,
            "text": "In the name of God, The Most Gracious, The Dispenser of Grace:",
            "numberInSurah": 1,
            "juz": 1,
            "manzil": 1,
            "page": 1,
            "ruku": 1,
            "hizbQuarter": 1,
            "sajda": false
        },
*/

data class Quran(
    val code: Int,
    val status: String,
    val data: SurahData
)

data class SurahData(
    val surahs: List<Surah>
)

data class Surah(
    val number: Int,
    val name: String,
    val englishName: String,
    val englishNameTranslation: String,
    val revelationType: String,
    val ayahs: List<Ayah>
)

data class Ayah(
    val number: Int,
    val text: String,
    val numberInSurah: Int,
    val juz: Int,
    val manzil: Int,
    val page: Int,
    val ruku: Int,
    val hizbQuarter: Int,
    val sajda: JsonElement
)
