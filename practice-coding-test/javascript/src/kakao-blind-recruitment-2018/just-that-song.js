// @ts-check

/**
 * @param {string} m
 * @param {string[]} musicinfos
 * @returns {string}
 */
function solution(m, musicinfos) {
  const getMinutes = (s) => s.substr(0, 2) * 60 + s.substr(3)
  const thatSongs = musicinfos
    .map((x) => x.split(','))
    .map((x, i) => {
      const minutes = getMinutes(x[1]) - getMinutes(x[0])
      let music = x[3].replace(/\w#/g, (c) => c.toLowerCase())
      music = music.padEnd(minutes, music)

      return {
        i,
        title: x[2],
        minutes,
        music,
      }
    })
    .filter((x) => x.music.includes(m.replace(/\w#/g, (c) => c.toLowerCase())))
    .sort((a, b) => {
      const t = b.minutes - a.minutes
      if (t === 0) {
        return a.i - b.i
      }
      return t
    })

  return thatSongs.length === 0 ? '(None)' : thatSongs[0].title
}

const m = 'CC#BCC#BCC#BCC#B'
const musicinfos = ['03:00,03:30,FOO,CC#B', '04:00,04:08,BAR,CC#BCC#BCC#B']
console.log(solution(m, musicinfos))
